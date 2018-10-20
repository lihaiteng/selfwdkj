package zztest.picload;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
import rx.schedulers.Schedulers;
import utils.log.LogUtil;

/**
 * Created by LiHT on 2017/6/8.
 */

public class TestFresoActivity extends BaseActivity {

    private SimpleDraweeView draweeView;

    private EditText username,pwd;

    private Button btn,btn2;
    Handler handler;
    String pic2 = "http://baike.baidu.com/pic/%E7%A7%8B%E7%94%B0%E7%8A%AC/504109/0/aa64034f78f0f7366aaf53b90255b319ebc41330?fr=lemma&ct=single";
    String pic1 = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1496909637&di=8901c68691eea77895d26c0dc4ac1158&src=http://img.weixinyidu.com/151212/c96ee601.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_fresco_activity);
        handler = new Handler();
        draweeView = (SimpleDraweeView) findViewById(R.id.myImg);
        username = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496919789911&di=18f18e2342c81cdb433c9d00636f91d3&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F06%2F26%2F146692579438812260.JPEG
                //Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496919789911&di=18f18e2342c81cdb433c9d00636f91d3&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F06%2F26%2F146692579438812260.JPEG");
//                Uri uri = Uri.parse("http://washop.turuitech.com/data/upload/shop/common/default_user_portrait.gif");
//                draweeView.setImageURI(uri);

                String name = username.getText().toString();
                String p = pwd.getText().toString();
                Observable<TestPostBean> testPostBean = service.getPostBeanO(name,p,"ios");
                testPostBean
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new BaseSubscriber<TestPostBean>(TestFresoActivity.this){
                            @Override
                            public void onCompleted() {
                                super.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                                LogUtil.d(e.getMessage());
                                Uri uri = Uri.parse(pic1);
                                draweeView.setImageURI(uri);
                            }

                            @Override
                            public void onNext(TestPostBean testPostBean) {
                                super.onNext(testPostBean);
                                String key = testPostBean.getDatas().getKey();
                                Observable<TestUserMsgBean> userMsgObservable = service.getGerUserMsg(key);
                                userMsgObservable
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribeOn(Schedulers.io())
                                        .subscribe(new BaseSubscriber<TestUserMsgBean>(TestFresoActivity.this){
                                            @Override
                                            public void onError(Throwable e) {
                                                super.onError(e);
                                                Uri uri = Uri.parse(pic2);
                                                draweeView.setController(getDraweeController(uri,draweeView));
                                            }

                                            @Override
                                            public void onNext(TestUserMsgBean testUserMsgBean) {
                                                super.onNext(testUserMsgBean);
                                                String url = testUserMsgBean.getDatas().getMember_info().getAvator();
                                                Log.e("aaasss",url);
                                                LogUtil.d(url);
                                                Uri uri = Uri.parse(url);
                                                draweeView.setImageURI(uri);//Fresco的建议是，直接用setImageURI的方法来设置图片，即使是本地的图片也用这种方法
                                                //draweeView.setController(getDraweeController(uri,draweeView));
//                                                RoundingParams roundingParams = new RoundingParams();
//                                                roundingParams.setRoundAsCircle(true);
//                                                GenericDraweeHierarchy hierarchy = draweeView.getHierarchy();
//                                                hierarchy.setRoundingParams(roundingParams);
                                            }
                                        });
                            }
                        });
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(pic1);
//                draweeView.setImageURI(uri);
                draweeView.setController(getDraweeController(uri,draweeView));
            }
        });
    }

    public void forBtn3(View v){
        Uri uri = Uri.parse("http://washop.turuitech.com/data/upload/shop/common/default_user_portrait.gif");
        draweeView.setController(getDraweeController(uri,draweeView));
    }

    public class ControllerDraweeListener extends BaseControllerListener {
        @Override
        public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
            super.onFinalImageSet(id, imageInfo, animatable);
            LogUtil.d("pic listener","success");
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
                .setControllerListener(new ControllerDraweeListener())
                .build();
    }
}
