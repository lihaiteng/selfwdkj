package app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import http.retrofit.base.IHttpService;
import http.retrofit.base.RetrofitHelper;

public class WDApplication extends Application {

    //retrofit 网络请求框架的帮助类
    private static RetrofitHelper retrofitHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitHelper = new RetrofitHelper(IHttpService.HOST,getApplicationContext());//host初始设置
        Fresco.initialize(this);//fresco 图片加载框架初始化

        //UMShareAPI.get(this);
        //PlatformConfig.setWeixin(AppData.WXAPPID,AppData.WXAPPSELECT);
    }

    public IHttpService getiHttpService(){
        return  retrofitHelper.getiHttpService();
    }
}
