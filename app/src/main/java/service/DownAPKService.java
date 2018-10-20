//package service;
//
//import android.app.NotificationManager;
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Handler;
//import android.os.IBinder;
//import android.os.Message;
//import android.support.v4.app.NotificationCompat;
//import android.support.v4.content.FileProvider;
//
//import com.turui.hdjy.R;
//
//import java.io.File;
//
//import http.retrofit.base.IHttpService;
//import http.retrofit.error.BaseSubscriber;
//import http.retrofit.progress.Download;
//import http.retrofit.progress.DownloadProgressListener;
//import http.retrofit.progress.DownloadRetrofit;
//import utils.AppUtil;
//import utils.PhoneUtil;
//
///**
// * Created by liht on 2018/5/14 0014.
// */
//
//public class DownAPKService extends Service {
//
//    private Service service;
//
//    private final int NotificationID = 0x10000;
//    private NotificationManager mNotificationManager = null;
//    private NotificationCompat.Builder builder;
//
//    // 文件下载路径
//    private String apkUrl = "";
//    // 文件保存路径(如果有SD卡就保存SD卡,如果没有SD卡就保存到手机包名下的路径)
//    private String APK_dir = "";
//
//    private DownloadProgressListener listener;
//
//    private Handler ProgressHandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Download downloadBean = (Download)msg.obj;
//            if(downloadBean.getProgress() < 100){
//                int x = Long.valueOf(downloadBean.getCurrentFileSize_KB()).intValue();
//                int totalS = Long.valueOf(downloadBean.getTotalFileSize_KB()).intValue();
//                builder.setProgress(totalS, x, false);
//                builder.setContentText("已下载"+downloadBean.getProgress()+"%");
//                //builder.setContentInfo(String.valueOf(downloadBean.getProgress()));//右边的百分比数字显示
//                mNotificationManager.notify(NotificationID, builder.build());
//            }else{
//                //取消
//                mNotificationManager.cancel(NotificationID);
//            }
//        }
//    };
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        service = this;
//        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        builder = new NotificationCompat.Builder(getApplicationContext());
//        initAPKDir();// 创建保存路径
//        initHttp();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        apkUrl = intent.getStringExtra("apkurl");
//        downFileAction(apkUrl);
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    private void initAPKDir() {
//        APK_dir = PhoneUtil.OutPackageSelfDirPath(service,"DownLoad");
//        File destDir = new File(APK_dir);
//        if (!destDir.exists()) {// 判断文件夹是否存在
//            destDir.mkdirs();
//        }
//    }
//
//    public void initHttp(){
//        listener = new DownloadProgressListener() {
//            @Override
//            public void update(long bytesRead, long contentLength, boolean done) {
//                Download download = new Download();
//                download.setTotalFileSize(contentLength);
//                download.setCurrentFileSize(bytesRead);
//                int progress = (int) ((bytesRead * 100) / contentLength);
//                download.setProgress(progress);
//
//                Message msg = new Message();
//                msg.obj = download;
//                ProgressHandler.sendMessage(msg);
//            }
//        };
//    }
//
//    /**
//     * 已完善的带进度值的功能
//     */
//    public void downFileAction(String apkUrl){
//        final File file = new File(APK_dir, AppUtil.getPackageName(service)+".apk");
//        new DownloadRetrofit(IHttpService.HOST, listener)
//                .downloadAPK(apkUrl, file, new BaseSubscriber(this){
//                    @Override
//                    public void onCompleted() {
//                        downloadCompleted(file);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//                    }
//
//                    @Override
//                    public void onStart() {
//                        super.onStart();
//                        builder.setSmallIcon(R.drawable.ic_launcher);
//                        builder.setContentTitle(AppUtil.getApplicationName(service));
//                        builder.setContentText("请稍等...");
//                        builder.setAutoCancel(true);
//                        builder.setNumber(0);
//                        builder.setTicker("正在下载新版本");
//                        mNotificationManager.notify(NotificationID, builder.build());
//                    }
//                });
//    }
//
//    /**
//     * 下载完成后安装apk
//     * @param file
//     */
//    private void downloadCompleted(File file) {
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
//            Uri apkUri = FileProvider.getUriForFile(this, "com.turui.hdjy.fileProvider", file);
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            // 由于没有在Activity环境下启动Activity,设置下面的标签
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            //添加这一句表示对目标应用临时授权该Uri所代表的文件
//            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
//            startActivity(intent);
//        }else{
//            Intent localIntent = new Intent("android.intent.action.VIEW");
//            localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            localIntent.setDataAndType(Uri.parse("file://" + file.toString()),
//                    "application/vnd.android.package-archive");
//            startActivity(localIntent);
//        }
//    }
//
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        stopSelf();
//    }
//}
