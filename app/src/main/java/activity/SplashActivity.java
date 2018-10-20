package activity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.turui.yuncheng.R;

import activity.base.BaseActivity;
import http.bean.TestPostBean;
import http.bean.TestUserMsgBean;
import http.retrofit.error.BaseSubscriber;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import utils.DensityUtil;
import utils.log.LogUtil;
import zztest.picload.TestFresoActivity;

/**
 * Created by Zzz on 2017/7/5.
 */

public class SplashActivity  extends BaseActivity{

    private int SPLASH_SHOW_TIME = 2;

    private Handler handler;

    private Runnable runnable;

    private SimpleDraweeView draweeView;

    private TextView textView;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.b_activity_splash);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if( (SPLASH_SHOW_TIME -= 1) < 0){
                    showIndex();
                }else {
                    textView.setText("跳过 "+ SPLASH_SHOW_TIME +"S");
                    handler.postDelayed(this,1000);
                }
            }
        };
        draweeView = (SimpleDraweeView)findViewById(R.id.draweeView);
        textView = (TextView)findViewById(R.id.textView);
        ViewGroup.LayoutParams params = draweeView.getLayoutParams();
        //动态改变SimpleDraweeView宽高
        int[] wh = DensityUtil.getWindowWidthHeight(activity);
        params.width = wh[0];
        params.height = wh[1];
        draweeView.setLayoutParams(params);
    }

    @Override
    protected void control() {
        super.control();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);//失去焦点或者finish后 移除handler的runable
    }

    @Override
    protected void onResume() {
        super.onResume();
        setImage();
    }

    public void showIndex(){
        Intent intent = new Intent(activity, TestFresoActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.b_splash_fade_in, R.anim.b_splash_fade_out);
        finish();
    }

    public void setImage(){
        Observable<TestPostBean> testPostBean = service.getPostBeanO("18367803056","111111zzz","ios");
        testPostBean
                .flatMap(new Func1<TestPostBean, Observable<TestUserMsgBean>>() {
                    @Override
                    public Observable<TestUserMsgBean> call(TestPostBean testPostBean) {
                        String key = testPostBean.getDatas().getKey();
                        return service.getGerUserMsg(key);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<TestUserMsgBean>(context){
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }

                    @Override
                    public void onNext(TestUserMsgBean testUserMsgBean) {
                        super.onNext(testUserMsgBean);
                        LogUtil.d("2  next","success");
                        String url = testUserMsgBean.getDatas().getMember_info().getAvator();
                        Uri uri = Uri.parse(url);
                        draweeView.setController(getDraweeController(uri,draweeView));
                    }
                });
    }

    public class ControllerDraweeListener extends BaseControllerListener {
        @Override
        public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
            super.onFinalImageSet(id, imageInfo, animatable);
            LogUtil.d("pic listener","success");
            textView.setVisibility(View.VISIBLE);
            textView.setText("跳过 "+ SPLASH_SHOW_TIME +"S");
            handler.postDelayed(runnable,1000);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handler.removeCallbacks(runnable);//点击后移除handler的runable
                    showIndex();
                }
            });
        }

        @Override
        public void onFailure(String id, Throwable throwable) {
            super.onFailure(id, throwable);
            LogUtil.d("pic listener","error");
        }
    }

    public DraweeController getDraweeController(Uri uri, DraweeView draweeView){
        return Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .setOldController(draweeView.getController())
                .setControllerListener(new SplashActivity.ControllerDraweeListener())
                .build();
    }
}
