//package com.turui.wdkj.pay;
//
//import android.content.Intent;
//import android.view.KeyEvent;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.turui.hdjy.R;
//
//import activity.StartActivity;
//import activity.base.BaseActivity;
//import app.AppData;
//import http.bean.GetPayOrderBean;
//import http.retrofit.error.BaseSubscriber;
//import rx.Observable;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;
//import utils.sharedpreferences.SharedpreferencesUtil;
//
///**
// * Created by liht on 2018/1/16 0016.
// */
//
//public class PayResultActivity extends BaseActivity {
//
//    private ImageView img;
//    private TextView msgText;
//    private TextView moneyText;
//    private TextView timeText;
//    private TextView wayText;
//    private TextView backBtn;
//    @Override
//    protected void initView() {
//        super.initView();
//        setContentView(R.layout.payresult_activity);
//        img = (ImageView)findViewById(R.id.img);
//        msgText = (TextView)findViewById(R.id.msgText);
//        moneyText = (TextView)findViewById(R.id.moneyText);
//        timeText = (TextView)findViewById(R.id.timeText);
//        wayText = (TextView)findViewById(R.id.wayText);
//        backBtn = (TextView)findViewById(R.id.backBtn);
//    }
//
//    private SharedpreferencesUtil spUtil;
//    @Override
//    protected void control() {
//        super.control();
//        spUtil = new SharedpreferencesUtil(this, AppData.spName);
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goPersonal();
//            }
//        });
//        getOrderInfoHttp();
//    }
//
//    private void getOrderInfoHttp(){
//        Observable<GetPayOrderBean> payOrderO = service.GetPayOrder(0);
//        payOrderO.observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new BaseSubscriber<GetPayOrderBean>(context){
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                    }
//
//                    @Override
//                    public void onNext(GetPayOrderBean getPayOrderBean) {
//                        super.onNext(getPayOrderBean);
//                        GetPayOrderBean.DataEntity.OrderInfoEntity obj = getPayOrderBean.getData().getOrderInfo();
//                        moneyText.setText("￥"+ String.valueOf(obj.getPayTotalFee()));
//                        timeText.setText(obj.getPaymentTime());
//                        wayText.setText(obj.getTradeType());
//                    }
//                });
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            goPersonal();
//            return true;
//        }
//        return super.onKeyDown(keyCode,event);
//    }
//
//    private void goPersonal(){
//        Intent intent = new Intent(context, StartActivity.class);
//        intent.putExtra("from","paysuccess");
//        startActivity(intent);
//        finish();
//    }
//}
