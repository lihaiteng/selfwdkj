package utils.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

/**
 * Created by Zzz on 2017/7/4.
 */

public class PermissionUtils {

    /**
     * Manifest.permission.WRITE_EXTERNAL_STORAGE 读写
     * Manifest.permission.CAMERA 相机
     * Manifest.permission.CALL_PHONE 电话
     */

    //检测权限是否授权
    public static boolean checkPermission(String permission,Context context){
        boolean b = ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
        return b;
    }

    //activity下请求单个权限
    public static void requestPermission(String permission,int reCode,Activity activity){
        ActivityCompat.requestPermissions(activity,new String[]{permission},reCode);
    }

    /**
     * activity下请求多个权限,返回0表示,权限已拥有；-1表示权限未拥有，进入请求权限状态，在回调中处理
     */
    //@RequiresApi(api = Build.VERSION_CODES.M)
    public static int checkAndRequestPermissions(String[] permissions, int reCodes,Activity
            activity){
        ArrayList<String> notAllowPermissionList = new ArrayList<>();
        for(int i=0;i<permissions.length;i++){
            String permission = permissions[i];
            if(!checkPermission(permission,activity)){
                notAllowPermissionList.add(permission);
            }
        }
        if(notAllowPermissionList.size()!=0){
            String[] notAllowPermission = new String[notAllowPermissionList.size()];
            for (int j=0;j<notAllowPermissionList.size();j++){
                notAllowPermission[j] = notAllowPermissionList.get(j);
            }
            ActivityCompat.requestPermissions(activity,notAllowPermission,reCodes);
            //activity.requestPermissions(notAllowPermission,reCodes);
            return -1;
        }
        return 0;
    }
}
