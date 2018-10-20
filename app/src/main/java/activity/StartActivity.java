package activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;

import activity.base.BaseActivity;
import http.bean.LoginBean;
import utils.permission.PermissionUtils;
import utils.sharedpreferences.SharedpreferencesUtil;
import zztest.netty.TestUdpRemoteActivity;
import zztest.nettytcpdemo.ui.Netty1Activity;
import zztest.nettyudpdemo.Netty2Activity;
import zztest.vedio.VedioViewActivity;

/**
 * Created by bockey on 2017/2/6.
 */
public class StartActivity extends BaseActivity {

    private SharedpreferencesUtil spUtil;
    private LoginBean.DataEntity.UserInfoEntity userInfo;
    private int PERMISSION_REQCODE = 0x001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permission();
    }

    private void permission(){
        int result = PermissionUtils.checkAndRequestPermissions(new String[]{Manifest.permission
                .WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA,
                Manifest.permission.CALL_PHONE},PERMISSION_REQCODE,activity);
        if(result==0){
            init();
        }
    }

    private void init() {
        Intent intent = new Intent(this, VedioViewActivity.class);
        startActivity(intent);
        finish();

//        spUtil = new SharedpreferencesUtil(this, AppData.spName);
//        userInfo = (LoginBean.DataEntity.UserInfoEntity)spUtil
//                .getEntity(AppData.spUsrName);
//
//        if(userInfo==null){
//            Intent intent = new Intent(this, TestDownAPKServiceActivity.class);//LoginActivity
//            startActivity(intent);
//            finish();
//        }
//        else if(userInfo.getOpenState()==1){//解决问题：在http请求之后再做跳转的话，startActivty会一闪而过（打开后马上关闭）
//            Intent intent = new Intent(context, TestDownAPKServiceActivity.class);//PersonalActivity
////            if("paysuccess".equals(getIntent().getStringExtra("from"))){
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
////            }
//            startActivity(intent);
//            finish();
//        }
//        else{
//            getUserHttp();
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i=0;i<grantResults.length;i++){
            if(grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                finish();
                return;
            }
        }
        init();
    }

//    private void getUserHttp(){
//        Observable<GetUserBean> getUserO = service.GetUser(0);
//        getUserO.observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new BaseSubscriber<GetUserBean>(activity){
//                    @Override
//                    public void onNext(GetUserBean getUserBean) {
//                        super.onNext(getUserBean);
//                        int flag =getUserBean.getData().getUserInfo().getOpenState();
//                        userInfo.setOpenState(flag);
//                        userInfo.setIsCheck(getUserBean.getData().getUserInfo().getIsCheck());
//                        userInfo.setReferralViewURL(getUserBean.getData().getUserInfo().getReferralViewURL());
//                        spUtil.setEntity(AppData.spUsrName,userInfo);
//                        if(flag == 0){
//                            Intent intent = new Intent(context, PayActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }else {
//                            Intent intent = new Intent(context, PersonalActivity.class);
//                            if("paysuccess".equals(getIntent().getStringExtra("from"))){
//                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                            }
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        Intent intent = new Intent(context, LoginActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                });
//    }
}
