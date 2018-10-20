//package com.turui.wdkj.pay;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.graphics.Color;
//import android.os.Handler;
//import android.os.Message;
//import android.support.annotation.NonNull;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.alipay.sdk.app.PayTask;
//import com.facebook.drawee.generic.GenericDraweeHierarchy;
//import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
//import com.facebook.drawee.generic.RoundingParams;
//import com.facebook.drawee.view.SimpleDraweeView;
//import com.tencent.mm.opensdk.modelpay.PayReq;
//import com.tencent.mm.opensdk.openapi.IWXAPI;
//import com.tencent.mm.opensdk.openapi.WXAPIFactory;
//import com.turui.hdjy.R;
//import com.unionpay.UPPayAssistEx;
//
//import java.io.BufferedReader;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.Callable;
//import java.util.concurrent.FutureTask;
//
//import activity.appcompat.ToolBarActivity;
//import app.AppData;
//import http.bean.GetPayOrderBean;
//import http.bean.LoginBean;
//import http.bean.PayBean;
//import http.bean.UploadBean;
//import http.retrofit.UpdateUtil;
//import http.retrofit.error.BaseSubscriber;
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//import picload.FresoUtils;
//import rx.Observable;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;
//import utils.DensityUtil;
//import utils.choosephoto.ChoosePhotoUtil;
//import utils.dialog.AlertDialogHelper;
//import utils.dialog.ChangeDialogTextColorUtil;
//import utils.log.LogUtil;
//import utils.sharedpreferences.SharedpreferencesUtil;
//
///**
// * Created by 一脸灬邪气 on 2017/12/5 0005 2017/12/5 0005.
// * WDKJ.setBug(null);
// */
//
//public class PayActivity extends ToolBarActivity {
//    private EditText payYinYeText,payAddressText;
//    private TextView payNameText,payTypeText,payMemberLevelText,payLevelText;
//    private TextView cardImgFileText,cardImg2FileText,yingyeFileText;
//    private LinearLayout cardLinear,cardLinear2,yingyeLinear,rentalAreementLinear;
//    private RelativeLayout greenRel,redRel,blueRel,yellowRel;
//    private SimpleDraweeView cardImg,cardImg2,yingyeImg;
//    private Button payBtn;
//    private TextView changeText;
//
//    private LinearLayout rentalAreementImgLinear;
//
//    private final int REQUEST_CODE_Z = 0x7c51;
//    private final int REQUEST_CODE_F = 0x7c52;
//    private final int REQUEST_CODE_YY = 0x7c53;
//    private final int REQUEST_CODE_XieYi = 0x7c57;
//
//    private final int REQUEST_CAMERA_CODE_Z = 0x7c54;
//    private final int REQUEST_CAMERA_CODE_F = 0x7c55;
//    private final int REQUEST_CAMERA_CODE_YY = 0x7c56;
//    private final int REQUEST_CAMERA_CODE_XieYi = 0x7c58;
//
//    private Map<Integer,SimpleDraweeView> map;
//
//    private String cardZ,cardF,yingye;
//    private String address,yingyeNo;
//
//    private LinearLayout addressInputLinear,yingYeInputLinear;
//
//    private int type=0;
//    private String payUrl="";
//
//    private int width;
//
//    private static final int ALI_PAY_FLAG = 1;
//    private static final int YinLian_PAY_FLAG = 2;
//
//    //银联 01 测试环境，00正式环境
//    public static final String mode = "01";
//    public static final int PLUGIN_VALID = 0;
//    public static final int PLUGIN_NOT_INSTALLED = -1;
//    public static final int PLUGIN_NEED_UPGRADE = 2;
//    //WX
//    private IWXAPI api;
//
//    private SharedpreferencesUtil spUtil;
//    private LoginBean.DataEntity.UserInfoEntity userInfo;
//    @Override
//    protected void initView() {
//        super.initView();
//        setContentView(R.layout.pay_activity);
//        changeText = (TextView)findViewById(R.id.changeText);
//
//        payNameText = (TextView)findViewById(R.id.payNameText);
//        payTypeText = (TextView)findViewById(R.id.payTypeText);
//        //payMemberLevelText = (TextView)findViewById(R.id.payMemberLevelText);
//        payLevelText = (TextView)findViewById(R.id.payLevelText);
//
//        payYinYeText = (EditText)findViewById(R.id.payYinYeText);
//        payAddressText = (EditText)findViewById(R.id.payAddressText);
//
//        addressInputLinear = (LinearLayout)findViewById(R.id.addressInputLinear);
//        yingYeInputLinear = (LinearLayout)findViewById(R.id.yingYeInputLinear);
//
//        cardLinear = (LinearLayout)findViewById(R.id.cardLinear);
//        cardLinear2 = (LinearLayout)findViewById(R.id.cardLinear2);
//        yingyeLinear = (LinearLayout)findViewById(R.id.yingyeLinear);
//        rentalAreementLinear = (LinearLayout)findViewById(R.id.rentalAreementLinear);
//
//        rentalAreementImgLinear = (LinearLayout)findViewById(R.id.rentalAreementImgLinear);
//
//        cardImgFileText = (TextView)findViewById(R.id.cardImgFileText);
//        cardImg2FileText = (TextView)findViewById(R.id.cardImg2FileText);
//        yingyeFileText = (TextView)findViewById(R.id.yingyeFileText);
//
//        greenRel = (RelativeLayout)findViewById(R.id.greenRel);
//        redRel = (RelativeLayout)findViewById(R.id.redRel);
//        blueRel = (RelativeLayout)findViewById(R.id.blueRel);
//        yellowRel = (RelativeLayout)findViewById(R.id.yellowRel);
//
//        cardImg = (SimpleDraweeView)findViewById(R.id.cardImg);
//        cardImg2 = (SimpleDraweeView)findViewById(R.id.cardImg2);
//        yingyeImg = (SimpleDraweeView)findViewById(R.id.yingyeImg);
//
//        FresoUtils.setWidth(context,cardImg,25);
//        FresoUtils.setWidth(context,cardImg2,25);
//        FresoUtils.setWidth(context,yingyeImg,25);
//
//        map = new HashMap<>();
//        map.put(REQUEST_CODE_Z,cardImg);
//        map.put(REQUEST_CODE_F,cardImg2);
//        map.put(REQUEST_CODE_YY,yingyeImg);
//
//        map.put(REQUEST_CAMERA_CODE_Z,cardImg);
//        map.put(REQUEST_CAMERA_CODE_F,cardImg2);
//        map.put(REQUEST_CAMERA_CODE_YY,yingyeImg);
//
//        payBtn = (Button)findViewById(R.id.payBtn);
//
//        payBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(context,"支付功能正在完善中",Toast.LENGTH_SHORT).show();
//                address = payAddressText.getText().toString().trim();
//                yingyeNo = payYinYeText.getText().toString().trim();
//                cardZ = cardImgFileText.getText().toString();
//                cardF = cardImg2FileText.getText().toString();
//                yingye = yingyeFileText.getText().toString();
//                if(type==2 &&(address ==null || yingyeNo==null ||"".equals(address) || "".equals
//                        (yingyeNo)))
//                    Toast.makeText(context,"请输入地址和营业执照号码", Toast.LENGTH_SHORT).show();
//                else if ("".equals(cardZ) || "".equals(cardF)){
//                    Toast.makeText(context,"请选择照片", Toast.LENGTH_SHORT).show();
//                }else if("".equals(yingye) && type==2){
//                    Toast.makeText(context,"请选择照片", Toast.LENGTH_SHORT).show();
//                }else if(textViewList.size()==0 && type==2){
//                    Toast.makeText(context,"请选择照片", Toast.LENGTH_SHORT).show();
//                }else{
//                    showChangePayWay();
//                }
//            }
//        });
//
//        api = WXAPIFactory.createWXAPI(this, AppData.WXAPPID);
//        api.registerApp(AppData.WXAPPID);
//
//        width = DensityUtil.getScreenWidth(context,25);
//    }
//
//    private List<TextView> textViewList = new ArrayList<>();
//    private void addSimpleDraweeView(String path){
//        //// TODO: 2018/1/24 0024
//        final LinearLayout linearLayout = new LinearLayout(context);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//        SimpleDraweeView sd = new SimpleDraweeView(context);
//        ViewGroup.LayoutParams p = new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
//        sd.setLayoutParams(p);
//        sd.setAspectRatio(1.66f);
//        sd.setImageURI(path);
//
////                RoundingParams roundingParams = RoundingParams.fromCornersRadii(10,10,10,10);
////                GenericDraweeHierarchy hierarchy = sd.getHierarchy();
////                hierarchy.setRoundingParams(roundingParams);
////                sd.setHierarchy(hierarchy);
//        GenericDraweeHierarchy genericDraweeHierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources())
//                .setRoundingParams(RoundingParams.fromCornersRadius(DensityUtil.dip2px(context,10)))
//                .build();
//        sd.setHierarchy(genericDraweeHierarchy);
//
//        linearLayout.addView(sd);
//
//        TextView textView = new TextView(context);
//        textView.setVisibility(View.GONE);
//        textView.setText(path);
//        textViewList.add(textView);
//        linearLayout.addView(textView);
//
//        View line = new View(context);
//        ViewGroup.LayoutParams vp = new ViewGroup.LayoutParams(4,4);
//        line.setLayoutParams(vp);
//        linearLayout.addView(line);
//
//        rentalAreementImgLinear.addView(linearLayout);
//
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View v) {
//                AlertDialogHelper.showAlertDialog(activity, "是否删除图片", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                }, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        textViewList.remove(rentalAreementImgLinear.indexOfChild(linearLayout));
//                        rentalAreementImgLinear.removeView(v);
//                    }
//                });
//            }
//        });
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        UpdateUtil updateUtil = new UpdateUtil(activity);
//        updateUtil.checkUpdate(service);
//    }
//
//    @Override
//    protected void initSpecil() {
//        super.initSpecil();
//
//        spUtil = new SharedpreferencesUtil(context, AppData.spName);
//        userInfo = (LoginBean.DataEntity.UserInfoEntity)spUtil.getEntity(AppData.spUsrName);
//
//        findToolbar(R.id.toolbar);
//        setNavigation(R.drawable.back);
////        setMenuId(R.menu.menu_login);
////        setIMenuItemListener(new IMenuItemListener() {
////            @Override
////            public void onMenuItemClick(MenuItem item) {
////
////            }
////        });
//        setTitle("育德教育");
//        setIToolbarNavigationListener(new ToolBarActivity.IToolbarNavigationListener() {
//            @Override
//            public void onClickNavigation() {
////                activityHelper.onBackDwon();
//                spUtil.setEntity(AppData.spUsrName,null);
//                finish();
//            }
//        });
//
//        //setBackType(ActivityHelper.BackType.MAIN);
//        setBackListener(new BackListener(){
//            @Override
//            public void doBack() {
//                spUtil.setEntity(AppData.spUsrName,null);
//                finish();
//            }
//        });
//    }
//
//    @Override
//    protected void control() {
//        super.control();
//
//        //getUserHttp();
//        getOrderInfoHttp();
//
//        changeText.setVisibility(View.GONE);
////        changeText.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                spUtil.setEntity(AppData.spUsrName,null);
////                Intent intent = new Intent(context, LoginActivity.class);
////                startActivity(intent);
////                finish();
////            }
////        });
//    }
//
//    private Handler mHandler = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case ALI_PAY_FLAG: {
//                    @SuppressWarnings("unchecked")
//                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
//                    /**
//                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
//                     */
//                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
//                    String resultStatus = payResult.getResultStatus();
//                    LogUtil.d("resultInfo",resultInfo);
//                    LogUtil.d("resultStatus",resultStatus);
//                    // 判断resultStatus 为9000则代表支付成功
//                    if (TextUtils.equals(resultStatus, "9000")) {
//                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
//                        Intent intent = new Intent(context, PayResultActivity.class);
//                        startActivity(intent);
//                        finish();
//                    } else if(TextUtils.equals(resultStatus, "6001")){
//                        Toast.makeText(context, "支付取消", Toast.LENGTH_SHORT).show();
//                    } else {
//                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
//                        Toast.makeText(context, "支付失败", Toast.LENGTH_SHORT).show();
//                    }
////                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
////                    builder.setTitle("支付结果通知");
////                    builder.setMessage(payResult.getMemo());
////                    builder.setInverseBackgroundForced(true);
////                    // builder.setCustomTitle();
////                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
////                        @Override
////                        public void onClick(DialogInterface dialog, int which) {
////                            dialog.dismiss();
////                        }
////                    });
////                    AlertDialog dialog = builder.create();
////                    dialog.show();
////                    ChangeDialogTextColorUtil.GetAlertDialogTitleMsg(dialog, Color.BLACK,Color.BLACK);
//                    break;
//                }
//                case YinLian_PAY_FLAG:{
//                    doStartUnionPayPlugin((String)msg.obj,mode);
//                }
//                default:
//                    break;
//            }
//        }
//    };
//
//
//    private void showChangePayWay(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("请选择支付方式");
//        builder.setItems(AppData.PayWay, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                payHttp(which);
//                dialog.dismiss();
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//        ChangeDialogTextColorUtil.GetAlertDialogTitle(dialog, Color.BLACK);
//    }
//
//    private void actionForAliPay(final String url){
//        LogUtil.d(url);
//        Runnable payRunnable = new Runnable() {
//
//            @Override
//            public void run() {
//                PayTask alipay = new PayTask(activity);
//                Map<String, String> result = alipay.payV2(url, true);//orderInfo
//
//                Message msg = new Message();
//                msg.what = ALI_PAY_FLAG;
//                msg.obj = result;
//                mHandler.sendMessage(msg);
//            }
//        };
//
//        Thread payThread = new Thread(payRunnable);
//        payThread.start();
//    }
//
//    private void actionForWXPay(PayBean.DataEntity.PayJsonEntity payBean){
////        String url = "http://wxpay.wxutil.com/pub_v2/app/app_pay.php";
////        //Toast.makeText(PayActivity.this, "获取订单中...", Toast.LENGTH_SHORT).show();
////        try{
////            JSONObject json = new JSONObject(get(url));
////            if(null != json && !json.has("retcode") ){
////                PayReq req = new PayReq();
////                //req.appId = "wxf8b4f85f3a794e77";  // 测试用appId
////                req.appId			= json.getString("appid");
////                req.partnerId		= json.getString("partnerid");
////                req.prepayId		= json.getString("prepayid");
////                req.nonceStr		= json.getString("noncestr");
////                req.timeStamp		= json.getString("timestamp");
////                req.packageValue	= json.getString("package");
////                req.sign			= json.getString("sign");
////                req.extData			= "app data"; // optional
////                //Toast.makeText(PayActivity.this, "正常调起支付", Toast.LENGTH_SHORT).show();
////                // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
////                api.sendReq(req);
////            }else{
////                Toast.makeText(PayActivity.this, "服务器请求错误", Toast.LENGTH_SHORT).show();
////            }
////        }catch(Exception e){
////            Toast.makeText(PayActivity.this, "异常："+e.getMessage(), Toast.LENGTH_SHORT).show();
////        }
//                PayReq req = new PayReq();
//                req.appId			= payBean.getAppId();
//                req.partnerId		= payBean.getPartnerid();
//                req.prepayId		= payBean.getPrepayid();
//                req.nonceStr		= payBean.getNonceStr();
//                req.timeStamp		= payBean.getTimeStamp();
//                req.packageValue	= payBean.getPackageX();
//                req.sign			= payBean.getSign();
//                //req.extData			= "app data"; // optional
//                api.sendReq(req);
//    }
//
//    private static final String TN_URL_01 = "http://101.231.204.84:8091/sim/getacptn";
//    private void actionForYinLianPay(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String tn = null;
//                InputStream is;
//                try {
//
//                    String url = TN_URL_01;
//
//                    URL myURL = new URL(url);
//                    URLConnection ucon = myURL.openConnection();
//                    ucon.setConnectTimeout(120000);
//                    is = ucon.getInputStream();
//                    int i = -1;
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    while ((i = is.read()) != -1) {
//                        baos.write(i);
//                    }
//
//                    tn = baos.toString();
//                    is.close();
//                    baos.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                Message msg = mHandler.obtainMessage();
//                msg.what = YinLian_PAY_FLAG;
//                msg.obj = tn;
//                mHandler.sendMessage(msg);
//            }
//        }).start();
//    }
//
//    public void doStartUnionPayPlugin(String tn, String mode) {
//        LogUtil.d("银联tn",tn);
//        // mMode参数解释：
//        // 0 - 启动银联正式环境
//        // 1 - 连接银联测试环境
//        int ret = UPPayAssistEx.startPay(this, null, null, tn, mode);
//        if (ret == PLUGIN_NEED_UPGRADE || ret == PLUGIN_NOT_INSTALLED) {
//            // 需要重新安装控件
//            LogUtil.d("plugin not found or need upgrade!!!");
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("提示");
//            builder.setMessage("完成购买需要安装银联支付控件，是否安装？");
//
//            builder.setNegativeButton("确定",
//                    new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            UPPayAssistEx.installUPPayPlugin(activity);
//                            dialog.dismiss();
//                        }
//                    });
//
//            builder.setPositiveButton("取消",
//                    new DialogInterface.OnClickListener() {
//
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//            AlertDialog dialog = builder.create();
//            dialog.show();
//            ChangeDialogTextColorUtil.GetAlertDialogTitleMsg(dialog, Color.BLACK, Color.BLACK);
//        }
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
//                        LogUtil.d(getPayOrderBean.getData().getOrderInfo().getAccountType());
//                        LogUtil.d(getPayOrderBean.getData().getOrderInfo().getRealName());
//
//                        greenRel.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                ChoosePhotoUtil.showDialog(activity,REQUEST_CODE_Z,REQUEST_CAMERA_CODE_Z);
//                            }
//                        });
//                        redRel.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                ChoosePhotoUtil.showDialog(activity,REQUEST_CODE_F,REQUEST_CAMERA_CODE_F);
//                            }
//                        });
//                        blueRel.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                ChoosePhotoUtil.showDialog(activity,REQUEST_CODE_YY,REQUEST_CAMERA_CODE_YY);
//                            }
//                        });
//                        yellowRel.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                ChoosePhotoUtil.showDialog(activity,REQUEST_CODE_XieYi,REQUEST_CAMERA_CODE_XieYi);
//                            }
//                        });
//
//                        payNameText.setText(getPayOrderBean.getData().getOrderInfo().getRealName());
//                        payTypeText.setText(getPayOrderBean.getData().getOrderInfo().getAccountTypef());
//                        payLevelText.setText(getPayOrderBean.getData().getOrderInfo().getAF_Name());
//                        type = getPayOrderBean.getData().getOrderInfo().getAccountType();
//                        if(getPayOrderBean.getData().getOrderInfo().getAccountType() == 2){
//                            addressInputLinear.setVisibility(View.VISIBLE);
//                            yingYeInputLinear.setVisibility(View.VISIBLE);
//                            yingyeLinear.setVisibility(View.VISIBLE);
//                            rentalAreementLinear.setVisibility(View.VISIBLE);
//                            //yingyeImg.setVisibility(View.VISIBLE);
//                        }
//                        payUrl = getPayOrderBean.getData().getOrderInfo().getPayUrl();
//                    }
//                });
//    }
//
////    private void getUserHttp(){
////        Observable<GetUserBean> getUserO = service.GetUser(0);
////        getUserO.observeOn(AndroidSchedulers.mainThread())
////                .subscribeOn(Schedulers.io())
////                .subscribe(new BaseSubscriber<GetUserBean>(activity){
////                    @Override
////                    public void onNext(GetUserBean getUserBean) {
////                        super.onNext(getUserBean);
////                        if("1".equals(getUserBean.getData().getUserInfo().getOpenState())){
////                            Intent intent = new Intent(context, PersonalActivity.class);
////                            startActivity(intent);
////                            finish();
////                        }else {
////                            getOrderInfoHttp();
////                            greenRel.setOnClickListener(new View.OnClickListener() {
////                                @Override
////                                public void onClick(View v) {
////                                    ChoosePhotoUtil.showDialog(activity,REQUEST_CODE_Z,REQUEST_CAMERA_CODE_Z);
////                                }
////                            });
////                            redRel.setOnClickListener(new View.OnClickListener() {
////                                @Override
////                                public void onClick(View v) {
////                                    ChoosePhotoUtil.showDialog(activity,REQUEST_CODE_F,REQUEST_CAMERA_CODE_F);
////                                }
////                            });
////                            blueRel.setOnClickListener(new View.OnClickListener() {
////                                @Override
////                                public void onClick(View v) {
////                                    ChoosePhotoUtil.showDialog(activity,REQUEST_CODE_YY,REQUEST_CAMERA_CODE_YY);
////                                }
////                            });
////                        }
////                    }
////                });
////    }
//
//    private void payHttp(final int payWay){//0 支付宝；1 微信 ；2 银联
//        String RentalAgreement = "";
//        for(int i=0;i<textViewList.size();i++){
//            RentalAgreement += textViewList.get(i).getText().toString();
//            if(i!=textViewList.size()-1){
//                RentalAgreement += ",";
//            }
//        }
//
//        String type = AppData.PayType[payWay];
//        Observable<PayBean> payO = service.Pay(cardZ,cardF,yingye,yingyeNo,address,type,true,
//                "android",RentalAgreement);
//        payO.observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new BaseSubscriber<PayBean>(context){
//                    @Override
//                    public void onNext(PayBean payBean) {
//                        super.onNext(payBean);
//                        switch (payWay){
//                            case 0:
//                                actionForAliPay(payBean.getData().getPayJson().getPaySDK());
//                                break;
//                            case 1:
//                                actionForWXPay(payBean.getData().getPayJson());
//                                break;
//                            case 2:
//                                actionForYinLianPay();
//                                break;
//                        }
//                    }
//                });
//    }
//
//    private String action;
//    private TextView saveText;
//    @Override
//    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        LogUtil.d("onActivityResult",requestCode);
//        if(resultCode == RESULT_OK && (
//                requestCode == REQUEST_CODE_Z ||
//                requestCode == REQUEST_CODE_F ||
//                requestCode == REQUEST_CODE_YY ||
//                        requestCode == REQUEST_CAMERA_CODE_Z ||
//                        requestCode == REQUEST_CAMERA_CODE_F ||
//                        requestCode == REQUEST_CAMERA_CODE_YY ||
//                    requestCode == REQUEST_CAMERA_CODE_XieYi ||
//                    requestCode == REQUEST_CODE_XieYi
//                )
//         ){
//            if(requestCode == REQUEST_CODE_Z || requestCode == REQUEST_CAMERA_CODE_Z) {
//                action = AppData.uploadCardZ;
//                saveText = cardImgFileText;
//            }
//            else if(requestCode == REQUEST_CODE_F || requestCode == REQUEST_CAMERA_CODE_F) {
//                action = AppData.uploadCardF;
//                saveText = cardImg2FileText;
//            } else if(requestCode == REQUEST_CODE_YY || requestCode == REQUEST_CAMERA_CODE_YY){
//                action = AppData.upYingYe;
//                saveText = yingyeFileText;
//            } else {
//                action = AppData.upFangWuXieYi;
//            }
//            File file = null;
//            if(requestCode == REQUEST_CODE_Z || requestCode == REQUEST_CODE_F || requestCode ==
//                    REQUEST_CODE_YY || requestCode == REQUEST_CODE_XieYi){
//                file = ChoosePhotoUtil.getChoosePhotoFile(data,activity, "HDJY_INFORMATION.jpg");
//            }else{
//                file = ChoosePhotoUtil.getCAMERAPhoto("HDJY_INFORMATION.jpg");
//            }
//            if(file!=null){
//                Map<String, RequestBody> params = new HashMap<>();
//                params.put("action",convertToRequestBody(action));
//
//                Observable<UploadBean> uploadO = service.UploadImg(params,convertToPart(file));
//                uploadO.observeOn(AndroidSchedulers.mainThread())
//                        .subscribeOn(Schedulers.io())
//                        .subscribe(new BaseSubscriber<UploadBean>(context){
//                            @Override
//                            public void onNext(UploadBean uploadBean) {
//                                super.onNext(uploadBean);
//                                if(requestCode != REQUEST_CAMERA_CODE_XieYi && requestCode !=
//                                        REQUEST_CODE_XieYi){
//                                    final String imgUrl = uploadBean.getData().getFileInfo().getFilePath();
//                                    SimpleDraweeView img = map.get(requestCode);
//                                    img.setImageURI(imgUrl);
//                                    img.setVisibility(View.VISIBLE);
//                                    saveText.setText(imgUrl);
//
////                                    img.setOnClickListener(new View.OnClickListener() {
////                                        @Override
////                                        public void onClick(View v) {
////                                            Intent intent = new Intent(context,ShowImgActivity.class);
////                                            intent.putExtra("url",imgUrl);
////                                            startActivity(intent);
////                                        }
////                                    });
//
//                                    Toast.makeText(context,uploadBean.getShowMsg(), Toast.LENGTH_SHORT).show();
//                                }else{
//                                    addSimpleDraweeView(uploadBean.getData().getFileInfo().getFilePath());
//                                }
//                            }
//                        });
//            }
//        }
//        //银联支付
//        if(!(requestCode == REQUEST_CODE_Z || requestCode ==
//                REQUEST_CODE_F || requestCode == REQUEST_CODE_YY ||
//                requestCode == REQUEST_CAMERA_CODE_XieYi ||
//                requestCode == REQUEST_CODE_XieYi)){
//            if (data == null) {
//                return;
//            }
//
//            String msg = "";
//            /*
//             * 支付控件返回字符串:success、fail、cancel 分别代表支付成功，支付失败，支付取消
//             */
//            String str = data.getExtras().getString("pay_result");
//            if (str.equalsIgnoreCase("success")) {
//                //msg = "支付成功！";
//                Intent intent = new Intent(context, PayResultActivity.class);
//                startActivity(intent);
//                finish();
//            } else if (str.equalsIgnoreCase("fail")) {
//                msg = "支付失败！";
//                Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
//            } else if (str.equalsIgnoreCase("cancel")) {
//                msg = "用户取消了支付";
//                Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
//            }
//
////            AlertDialog.Builder builder = new AlertDialog.Builder(this);
////            builder.setTitle("支付结果通知");
////            builder.setMessage(msg);
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
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            if(permissions[0].equals(ChoosePhotoUtil.PHOTO_PERMISSION)){
//                ChoosePhotoUtil.startPhoto(activity,requestCode);
//            }if( permissions[0].equals(ChoosePhotoUtil.CAPTURE_PERMISSION))
//                ChoosePhotoUtil.startCapture(activity,requestCode);
//        }
//    }
//    //retrofit上传图片所用方法
//    private RequestBody convertToRequestBody(String param){
//        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), param);
//        return requestBody;
//    }
//    private  MultipartBody.Part convertToPart(File file){
//        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part part = MultipartBody.Part.createFormData("File", file.getName(), requestBody);
//        return part;
//    }
//
//
//    //---for weixin----------------------------------------------
//    public static String get(final String url) {
//        final StringBuilder sb = new StringBuilder();
//        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                BufferedReader br = null;
//                InputStreamReader isr = null;
//                URLConnection conn;
//                try {
//                    URL geturl = new URL(url);
//                    conn = geturl.openConnection();//创建连接
//                    conn.connect();//get连接
//                    isr = new InputStreamReader(conn.getInputStream());//输入流
//                    br = new BufferedReader(isr);
//                    String line = null;
//                    while ((line = br.readLine()) != null) {
//                        sb.append(line);//获取输入流数据
//                    }
//                    System.out.println(sb.toString());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {//执行流的关闭
//                    if (br != null) {
//                        try {
//                            if (br != null) {
//                                br.close();
//                            }
//                            if (isr != null) {
//                                isr.close();
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        } }}
//                return sb.toString();
//            }
//        });
//        new Thread(task).start();
//        String s = null;
//        try {
//            s = task.get();//异步获取返回值
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return s;
//    }
//}
