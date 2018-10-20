package zztest.http.retrofithelper;

import android.content.Context;

import com.turui.yuncheng.BuildConfig;

import java.util.concurrent.TimeUnit;

import app.AppData;
import http.bean.LoginBean;
import http.retrofit.base.IHttpService;
import http.retrofit.converter.ReqErrorConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import utils.sharedpreferences.SharedpreferencesUtil;

/**
 * Created by LiHT on 2017/5/9.
 */

public class RetrofitHelper {
    private HttpLoggingInterceptor logging;
    private OkHttpClient client;
    private OkHttpClient.Builder builder;
    private Retrofit retrofit;
    private IHttpService iHttpService;

    private SharedpreferencesUtil spUtil;
    private LoginBean.DataEntity.UserInfoEntity userInfo;
//    private String UserID = "";

    public RetrofitHelper(String baseUrl, Context context){
        spUtil = new SharedpreferencesUtil(context,AppData.spName);
//        userInfo = (LoginBean.DataEntity.UserInfoEntity)spUtil.getEntity(AppData.spUsrName);
//        if(userInfo!=null) UserID=userInfo.getUserID();

        builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true);//连接失败后是否重新连接  //TODO
        builder.connectTimeout(15, TimeUnit.SECONDS);//超时时间15S   //TODO

        if(BuildConfig.DEBUG){
            logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);//TODO
            builder.addInterceptor(logging);//TODO
        }
//        builder.addInterceptor(new MustParamsInterceptor());//TODO
        client = builder.build();
        retrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(client)//设置okhttp
                //解析数据   GsonConverterFactory   ReqErrorConverterFactory
                .addConverterFactory(ReqErrorConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        iHttpService = retrofit.create(IHttpService.class);
    }

    public IHttpService getiHttpService(){
        return  iHttpService;
    }

//    public class MustParamsInterceptor implements Interceptor {
//        @Override
//        public okhttp3.Response intercept(Chain chain) throws IOException {
////            if("".equals(UserID)){
////                userInfo = (LoginBean.DataEntity.UserInfoEntity)spUtil.getEntity(AppData.spUsrName);
////                if(userInfo!=null) UserID=userInfo.getUserID();
////            }
//
//            String usrid = "";
//            userInfo = (LoginBean.DataEntity.UserInfoEntity)spUtil.getEntity(AppData.spUsrName);
//            if(userInfo!=null) usrid=userInfo.getUserID();
//            Request request = chain.request();
//            HttpUrl httpUrl = request.url().newBuilder()
//                    .addQueryParameter("apikey", AppData.apikey)
//                    .addQueryParameter("apisecret", AppData.apisecret)
//                    .addQueryParameter("UserID", usrid)
//                    .build();
//            request = request.newBuilder().url(httpUrl).build();
//            return chain.proceed(request);
//        }
//    }

}
