package utils;

import android.content.Context;
import android.os.Environment;

/**
 * Created by liht on 2018/5/14 0014.
 */

public class PhoneUtil {
    /**
     * @Description:判断是否插入SD卡
     */
    public static boolean isHasSdcard() {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取外部存储下包目录路径
     * @param c
     * @return
     */
    public static String OutPackagePath(Context c){
        return Environment.getExternalStorageDirectory().getAbsolutePath()+"/Android/data/"
                + AppUtil.getPackageName(c);
    }

    /**
     * 获取外部存储下包目录下自定义文件路径
     * @param c
     * @return
     */
    public static String OutPackageSelfDirPath(Context c,String Name){
        return OutPackagePath(c)+"/"+Name;
    }

    /**
     * 获取外部存储下包目录下files目录下的Name文件夹的路径
     * @param c
     * @return
     */
    public static String SDCardPackagePath(Context c,String Name){
        return c.getExternalFilesDir(Name).getAbsolutePath();
    }
}
