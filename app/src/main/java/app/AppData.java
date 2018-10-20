package app;

import android.os.Environment;

import com.turui.yuncheng.BuildConfig;

import java.io.File;

/**
 * Created by Zzz on 2017/6/29.
 */

public interface AppData {
    String spName = "yuncheng";//育德教育的存储文件

    String APPNAME = "yuncheng";
    String HOST = "http://192.168.1.225:8536";//http://tcpwx.zszdtech.com
    String APPDIC = Environment.getExternalStorageDirectory().getPath()+ File.separator+ BuildConfig.APPLICATION_ID;
    String Temp = APPDIC+ File.separator + "Temp";
    String TempPIC = Temp+ File.separator + "TempPIC";
    String TempFile = Temp+ File.separator + "TempFile";
    String APK = TempFile+ File.separator + "yuncheng.apk";


    String UpdateType = "727e169d-7eb7-4327-9faf-1573aa07632b";//apk更新类型
}
