package utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;

import java.util.List;

import utils.log.LogUtil;

public class SysUtil {
    /**
     * 获取apk版本号
     */
    public static String getVersionName(Context context) {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        String version = "";
        try {
            version = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            version = "";
        }
        LogUtil.d("版本号|"+version);
        return version;
    }

    /**
     * 判断某个进程是否存活
     */
    public static boolean isProessRunning(Context context, String proessName) {
        boolean isRunning = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> lists = am.getRunningAppProcesses();
        for(ActivityManager.RunningAppProcessInfo info : lists){
            if(info.processName.equals(proessName)){
                isRunning = true;
            }
        }
        return isRunning;
    }

    /**
     * 判断某个服务是否存活
     */
    public static boolean isServiceRunning(Context context, String serviceName) {
        boolean isRunning = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> lists = am.getRunningServices(30);
        for (ActivityManager.RunningServiceInfo info : lists) {//判断服务
            if(info.service.getClassName().equals(serviceName)){
                isRunning = true;
            }
        }
        return isRunning;
    }
}
