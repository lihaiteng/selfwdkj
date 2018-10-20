package http.retrofit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;

import app.AppData;
import http.bean.UpdateBean;
import http.retrofit.base.IHttpService;
import http.retrofit.error.BaseSubscriber;
import http.retrofit.progress.Download;
import http.retrofit.progress.DownloadProgressListener;
import http.retrofit.progress.DownloadRetrofit;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.SysUtil;
import utils.dialog.ChangeDialogTextColorUtil;
import utils.log.LogUtil;

/**
 * Created by liht on 2018/1/23 0023.
 */

public class UpdateUtil {

    public boolean ifHasProgressValue = true;//是否显示进度值

    private Activity activity;

    private DownloadProgressListener listener;

    private final ProgressDialog mypDialog;

    private static final NumberFormat format = NumberFormat.getPercentInstance();

    private static File file = new File(AppData.APK);

    public UpdateUtil(Activity a){
        this.activity = a;
        mypDialog = new ProgressDialog(activity);
        format.setMaximumFractionDigits(0);
        if(ifHasProgressValue){
            mypDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mypDialog.setIndeterminate(false);
            mypDialog.setCancelable(false);

            listener = new DownloadProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    Download download = new Download();
                    download.setTotalFileSize(contentLength);
                    download.setCurrentFileSize(bytesRead);
                    int progress = (int) ((bytesRead * 100) / contentLength);
                    download.setProgress(progress);

                    Message msg = new Message();
                    msg.obj = download;
                    ProgressHandler.sendMessage(msg);
                }
            };
        }
    }

    public void checkUpdate(final IHttpService service){
        Observable<UpdateBean> o = service.CheckUpdate(AppData.UpdateType);
        o.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<UpdateBean>(activity){
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if(!(e instanceof HttpException || e instanceof IOException)){
                            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                            builder.setMessage("获取更新信息失败,程序退出")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            activity.finish();
                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.setCancelable(false);
                            dialog.show();
                            ChangeDialogTextColorUtil.GetAlertDialogTitleMsg(dialog, Color.BLACK, Color.BLACK);
                        }
                    }

                    @Override
                    public void onNext(final UpdateBean updateBean) {
                        super.onNext(updateBean);
                        LogUtil.d(SysUtil.getVersionName(activity));
                        LogUtil.d(updateBean.getData().getVersionInfo().getVersion());
                        if(
                                !SysUtil.getVersionName(activity).equals(updateBean.getData().getVersionInfo().getVersion())
//                                true
                        ){
                            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                            builder.setMessage("发现新版本，是否立即下载安装？")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if(ifHasProgressValue){
                                                downFileAction(activity,updateBean.getData()
                                                        .getVersionInfo().getPackagePath());
                                            }else{
                                                downFileAction(service,activity,updateBean.getData()
                                                        .getVersionInfo().getPackagePath());
                                            }
                                        }
                                    })
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            activity.finish();
                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.setCancelable(false);
                            dialog.show();
                            ChangeDialogTextColorUtil.GetAlertDialogMsg(dialog, Color.BLACK);
                        }
                    }
                });
    }

    /**
     * 带进度值
     */

    public void downFileAction(Activity activity, String apkUrl){
        new DownloadRetrofit(IHttpService.HOST, listener)
                .downloadAPK(apkUrl, file, new BaseSubscriber(activity){
                    @Override
                    public void onCompleted() {
                        downloadCompleted(file);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        //downloadCompleted();
                    }

                    @Override
                    public void onNext(Object o) {
                    }
        });
    }

    private void downloadCompleted(File file) {
//        Intent localIntent = new Intent("android.intent.action.VIEW");
//        localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        localIntent.setDataAndType(Uri.parse("file://" + file.toString()),"application/vnd.android.package-archive");
//        activity.startActivity(localIntent);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            Uri apkUri = FileProvider.getUriForFile(activity, "com.turui.wzyy.fileProvider", file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            // 由于没有在Activity环境下启动Activity,设置下面的标签
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            activity.startActivity(intent);
        }else{
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            localIntent.setDataAndType(Uri.parse("file://" + file.toString()),
                    "application/vnd.android.package-archive");
            activity.startActivity(localIntent);
        }
    }

    private Handler ProgressHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Download downloadBean = (Download)msg.obj;
            if(downloadBean.getProgress() < 100){
                mypDialog.setMessage("下载中...");
                mypDialog.setMax(downloadBean.getTotalFileSize_KB());
                mypDialog.setProgress(downloadBean.getCurrentFileSize_KB());
                String right = "%1d KB/%2d KB";
                mypDialog.setProgressNumberFormat(right);
                mypDialog.setProgressPercentFormat(format);
                mypDialog.show();
                ChangeDialogTextColorUtil.GetAlertDialogMsg(mypDialog, Color.BLACK);
            }else{
                mypDialog.dismiss();
            }
        }
    };

/**
 *   无进度条
 */
    private boolean ifDown = false;
    public  void downFileAction(IHttpService service, final Activity activity, String url){
        if(!ifDown){
            ifDown = true;
            //Toast.makeText(activity,"开始下载",Toast.LENGTH_SHORT).show();
            final ProgressDialog mypDialog = new ProgressDialog(activity);
            mypDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mypDialog.setIndeterminate(true);
            mypDialog.setCancelable(false);
            mypDialog.setMessage("下载中...");
            mypDialog.setProgressPercentFormat(null);
            mypDialog.setProgressNumberFormat(null);
            mypDialog.show();
            ChangeDialogTextColorUtil.GetAlertDialogMsg(mypDialog, Color.BLACK);

            Observable<ResponseBody> downFileO = service.downloadFile(url);
            downFileO.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<ResponseBody>() {
                        @Override
                        public void onCompleted() {
                            mypDialog.dismiss();
                        }

                        @Override
                        public void onError(Throwable e) {
                            ifDown = false;
                            Toast.makeText(activity,"下载失败", Toast.LENGTH_SHORT).show();
                            mypDialog.dismiss();
                            activity.finish();
                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {
                            LogUtil.d("onNext"+file.getAbsolutePath());
                            OutputStream os = null;
                            InputStream is = responseBody.byteStream();
                            try {
                                os = new FileOutputStream(file);
                                int len ;
                                byte [] buff = new byte[1024];
                                while((len=is.read(buff))!=-1){
                                    os.write(buff,0,len);
                                }
                                ifDown = false;
                                mypDialog.dismiss();
                                Toast.makeText(activity,"下载成功",Toast.LENGTH_SHORT).show();
                                downloadCompleted(file);
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
    }
}
