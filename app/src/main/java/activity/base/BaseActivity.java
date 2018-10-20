package activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import activity.ActivityHelper;
import app.WDApplication;
import http.retrofit.base.IHttpService;

/**
 * Created by LiHT on 2017/5/9.
 */

public class BaseActivity extends AppCompatActivity {

    protected WDApplication app;
    protected IHttpService service;//retrofit http框架的接口
    protected ActivityHelper activityHelper;//自定义的activity帮助类，功能拓展
    protected Context context;
    protected Activity activity;

    private BackListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initSpecil();
        control();
    }
    protected void initView() {
        context = this;
        activity = this;
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activityHelper = new ActivityHelper(this);
        app = (WDApplication)getApplication();
        service = app.getiHttpService();
    }
    //特殊部分的初始化
    protected void initSpecil(){
    }
    //逻辑控制
    protected void control(){
    }
    //设置返回键的类型  : 双击退出，单机finish，webview回退
    public void setBackType(ActivityHelper.BackType backType){
        activityHelper.setBackType(backType);
    }

    public void setBackListener(BackListener listener){
        clickListener = listener;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(clickListener==null)
                return activityHelper.onBackDwon();
            else
                clickListener.doBack();
        }
        return super.onKeyDown(keyCode,event);
    }

    public IHttpService getService(){
        return  service;
    }

    public interface BackListener{
        void doBack();
    }
}
