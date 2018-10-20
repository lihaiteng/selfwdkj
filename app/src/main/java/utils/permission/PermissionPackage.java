package utils.permission;

import android.Manifest;

/**
 * Created by liht on 2018/5/11 0011.
 */

public interface PermissionPackage {
     String WRITE = Manifest.permission.WRITE_EXTERNAL_STORAGE; //读写
     String CAMERA = Manifest.permission.CAMERA; //相机
     String PHONE = Manifest.permission.CALL_PHONE; //电话
}
