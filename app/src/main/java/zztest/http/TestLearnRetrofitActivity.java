package zztest.http;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.turui.yuncheng.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import activity.base.BaseActivity;
import http.bean.TestGetBean;
import http.bean.TestPostBean;
import http.retrofit.UpdateUtil;
import http.retrofit.error.RequestException;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import utils.File.FileUtils;
import utils.log.LogUtil;
import utils.permission.PermissionUtils;

public class TestLearnRetrofitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_retrofit_activity);
    }

    //call 同步请求
    public void one(View v){
        final Call<TestPostBean> postCall0 = service.getPostBean("18367803056","111111","ios");
        final Call<TestPostBean> postCall1 = service.getPostBean("15669289885e","111111","ios");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //同步请求：在当前线程中去做请求操作，会阻塞当前线程
                    TestPostBean bean0 = postCall0.execute().body();
                    /**
                     * call类型的一般请求 ,接口返回错误的话，ReqErrorResponseBodyConverter的40行抛出的异常
                     * 因为 retrofit 设置了 addConverterFactory(ReqErrorConverterFactory.create())，这个错误是专门给异步请求的error回调处理的
                     * 同步请求处理的话，那就catch
                     */
                    TestPostBean bean1 = postCall1.execute().body();
                    Log.e("1",bean0.getDatas().getUsername()+"<-->"+bean1.getDatas().getUsername());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (RequestException e){
                    Log.e("1",e.getMessage());
                }
            }
        }).start();
    }

    //call 异步请求
    public void two(View v){
        Call<TestPostBean> postCall0 =  service.getPostBean("18367803056","111111","ios");
        Call<TestPostBean> postCall1 =  service.getPostBean("15669289885e","111111","ios");
        postCall0.enqueue(new Callback<TestPostBean>() {
            @Override
            public void onResponse(Call<TestPostBean> call, Response<TestPostBean> response) {
                Log.e("2",response.body().getDatas().getUsername());
            }
            @Override
            public void onFailure(Call<TestPostBean> call, Throwable e) {
                Log.e("2",e.getMessage());
            }
        });
        postCall1.enqueue(new Callback<TestPostBean>() {
            @Override
            public void onResponse(Call<TestPostBean> call, Response<TestPostBean> response) {
                Log.e("2",response.body().getDatas().getUsername());
            }
            @Override
            public void onFailure(Call<TestPostBean> call, Throwable e) {
                Log.e("2",e.getMessage());
            }
        });
    }

    //observable  涉及到了 rxjava
    public void three(View v){
        Observable<TestGetBean> getCallO = service.getGetBeanO("index","type");
        getCallO.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<TestGetBean>(){
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e("4",e.getMessage());
                    }
                    @Override
                    public void onNext(TestGetBean getBean) {
                        Log.e("4",getBean.getDatas().getType_list()+"");
                    }
                });
    }

    //observable  自定义BaseSubscriber拓展了Subscriber
    public void four(View v){
//        Observable<TestPostBean> postCallO =  service.getPostBeanO("errorTest","111111","ios");
//        postCallO.subscribeOn(Schedulers.io())
//                .subscribe(new BaseSubscriber<TestPostBean>(this) {
//                    @Override
//                    public void onCompleted() {
//                        Log.e("3","onCompleted");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        Log.e("3",e.getMessage());
//                    }
//                    @Override
//                    public void onNext(TestPostBean postBean) {
//                        Log.e("3",postBean.getCode()+"");
//                    }
//                });

        MultipartBody.Part body1 = prepareFilePart("video", FileUtils.getUri(new File("")));
        MultipartBody.Part body2 = prepareFilePart("thumbnail", FileUtils.getUri(new File("")));

        // 添加其他的part
        RequestBody description = createPartFromString("hello, this is description speaking");

        // 最后执行异步请求操作
        //Call<ResponseBody> callUpload = service.uploadMultipleFiles(description, body1, body2);
        Map<String, MultipartBody.Part> maps = new HashMap();
        maps.put("a",body1);
        maps.put("a",body2);
        Call<ResponseBody> callUpload = service.uploadMultipleFiles2(description,maps);
        callUpload.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> callUpload,
                                   Response<ResponseBody> response) {
                Log.v("Upload", "success");
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }

    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                MediaType.parse(MULTIPART_FORM_DATA), descriptionString);
    }
    @NonNull
    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
        File file = FileUtils.getFile(fileUri);

        // 为file建立RequestBody实例
        RequestBody requestFile =
                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);

        // MultipartBody.Part借助文件名完成最终的上传
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

    /**
     * 简单的下载文件
     * @param v
     */
    public void downFile(View v){
        if(PermissionUtils.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,this)){
            downFileAction();
        }else{
            PermissionUtils.requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,111,this);
        }
    }

    public void downFileAction(){
        Observable<ResponseBody> downFileO = service.downloadFile("http://www.swxiangge.com/Android/swxiangge.apk");
        downFileO.observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        File file = new File(Environment.getExternalStorageDirectory()
                                +"/hdjytest.apk");
                        LogUtil.d("fileUrl",file.getAbsolutePath());
                        OutputStream os = null;
                        InputStream is = responseBody.byteStream();
                        try {
                            os = new FileOutputStream(file);
                            int len ;
                            byte [] buff = new byte[1024];
                            while((len=is.read(buff))!=-1){
                                os.write(buff,0,len);
                            }
                            Intent localIntent = new Intent("android.intent.action.VIEW");
                            localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            localIntent.setDataAndType(Uri.parse("file://" + file.toString()),
                                    "application/vnd.android.package-archive");
                            startActivity(localIntent);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            if(os!=null){
                                try {
                                    os.close();
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if(is!=null){
                                try {
                                    is.close();
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && requestCode == 111) {
            downFileAction();
        }
    }

    /**
     * 带进度条下载文件
     */
    public void downFile2(View view){
        UpdateUtil uf = new UpdateUtil(activity);
        uf.downFileAction(activity,"http://www.swxiangge.com/Android/swxiangge.apk");
    }
}
