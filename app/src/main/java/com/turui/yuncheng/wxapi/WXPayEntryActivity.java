//package com.turui.wdkj.wxapi;
//
//import android.content.Intent;
//import android.widget.Toast;
//
//import com.tencent.mm.opensdk.constants.ConstantsAPI;
//import com.tencent.mm.opensdk.modelbase.BaseReq;
//import com.tencent.mm.opensdk.modelbase.BaseResp;
//import com.tencent.mm.opensdk.openapi.IWXAPI;
//import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
//import com.tencent.mm.opensdk.openapi.WXAPIFactory;
//import com.turui.hdjy.pay.PayResultActivity;
//
//import activity.base.BaseActivity;
//import app.AppData;
//
///**
// * Created by 一脸灬邪气 on 2017/12/18 0018 2017/12/18 0018.
// * HDJY.setBug(null);
// */
//
//public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {
//
//    private IWXAPI api;
//
//    @Override
//    protected void initView() {
//        super.initView();
//        //setContentView(R.layout.payresult_activity);
//
//        api = WXAPIFactory.createWXAPI(this, AppData.WXAPPID);
//        api.handleIntent(getIntent(), this);
//    }
//
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        setIntent(intent);
//        api.handleIntent(intent, this);
//    }
//
//    @Override
//    public void onReq(BaseReq req) {
//    }
//
//    @Override
//    public void onResp(BaseResp resp) {
//        int c = resp.errCode;
//        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
//            switch (c){
//                case 0:
//                    Intent intent = new Intent(context, PayResultActivity.class);
//                    startActivity(intent);
//                    finish();
//                    break;
//                case -1:
//                    Toast.makeText(context,"支付失败", Toast.LENGTH_SHORT).show();
//                    finish();
//                    break;
//                case -2:
//                    Toast.makeText(context,"支付取消", Toast.LENGTH_SHORT).show();
//                    finish();
//                    break;
//
//            }
////            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
////            builder.setTitle("支付结果通知");
////            builder.setMessage("支付结果---"+a+","+b+","+c);
////            builder.setInverseBackgroundForced(true);
////            // builder.setCustomTitle();
////            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
////                @Override
////                public void onClick(DialogInterface dialog, int which) {
////                    dialog.dismiss();
////                }
////            });
////            AlertDialog dialog = builder.create();
////            dialog.show();
////            ChangeDialogTextColorUtil.GetAlertDialogTitleMsg(dialog, Color.BLACK,Color.BLACK);
//        }
//    }
//}
