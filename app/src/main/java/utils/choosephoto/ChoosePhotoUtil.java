package utils.choosephoto;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import com.turui.yuncheng.BuildConfig;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import utils.dialog.ChangeDialogTextColorUtil;
import utils.log.LogUtil;

public class ChoosePhotoUtil {

    private static final double M_LENGTH = 1024*1024;//兆

    private static final int QUALITY = 80;//压缩质量

    public static final String PHOTO_PERMISSION = Manifest.permission.WRITE_EXTERNAL_STORAGE;//存储读写权限，就是相册

    public static final String CAPTURE_PERMISSION = Manifest.permission.CAMERA;//相机权限

    public static final String CAMERA_FILE_PATH = Environment.getExternalStorageDirectory()
            .getPath()+File.separator+"TEMP.jpg";
    private static File FILE = new File(CAMERA_FILE_PATH);

    /**
     * 弹出dialog 选择相册 或 相机
     * @param activity
     * @param requestCode_Photo
     * @param requestCode_Camera
     */
    public static void showDialog(final Activity activity, final int requestCode_Photo,final int requestCode_Camera){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("请选择")
                .setPositiveButton("相册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startPhotoWithPermissionCheck(activity, requestCode_Photo);
                    }
                })
                .setNegativeButton("拍照", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startCaptureWithPermissionCheck(activity, requestCode_Camera);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
        ChangeDialogTextColorUtil.GetAlertDialogMsg(dialog, Color.BLACK);
    }

    /**
     * 弹出dialog 选择相册 或 相机
     * @param activity
     */
    public static void showDialog(final Activity activity,final IBtnInterface iPhoto,final IBtnInterface iCamera,final IBtnInterface iCannel){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("请选择")
                .setPositiveButton("相册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        iPhoto.action();
                    }
                })
                .setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        iCannel.action();
                    }
                })  .setNegativeButton("拍照", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                iCamera.action();
            }
        }).setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();
        ChangeDialogTextColorUtil.GetAlertDialogMsg(dialog, Color.BLACK);
    }

    /**
     * 选择相册，打开相册界面
     * @param activity
     * @param requestCode 即是 intent的code,也是permission请求的code,方便在onRequestPermissionsResult回调中做相应的intent请求
     */
    public static void startPhotoWithPermissionCheck(Activity activity , int requestCode){
        if (ActivityCompat.checkSelfPermission(activity, PHOTO_PERMISSION) == PackageManager.PERMISSION_GRANTED) {
            startPhoto(activity,requestCode);
        }else{
            ActivityCompat.requestPermissions(activity, new String[] {PHOTO_PERMISSION}, requestCode);
        }
    }

    /**
     * 打开相册
     * @param activity
     * @param requestCode
     */
    public static void startPhoto(Activity activity ,int requestCode){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 在相册选完照片的回调onActivityResult中，通过传过来的intent获取对应的图片文件
     * @param data
     * @param context
     * @param fileName
     * @return
     */
    public static File getChoosePhotoFile(Intent data, final Activity context, String fileName) {
        String sdState = Environment.getExternalStorageState();
        File file = new File("");
        Bitmap bitmap;
        if(!sdState.equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(context,"没有安装sd card",Toast.LENGTH_SHORT).show();
        }else{
            Uri uriin = data.getData();
            if(uriin != null) {
                String[] cols = {MediaStore.Images.Media.DATA};
                Cursor c = context.getContentResolver().query(uriin, cols, null, null, null);
                c.moveToFirst();
                int index = c.getColumnIndex(cols[0]);
                String path = c.getString(index);//原始图片的路径
                c.close();

                file = compressFile(path,fileName);//根据原始图片路径，创建并返回压缩的图片文件
                return file;
            }else{
                Bundle bundle = data.getExtras();
                bitmap = (Bitmap)bundle.get("data");
                file = new File(Environment.getExternalStorageDirectory()+"/"+fileName);
                try{
                    if(!file.exists())
                        file.createNewFile();
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                    bos.flush();
                    bos.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                return file;
            }
        }
        return file;
    }

    /**
     * 选择相机，打开相机界面
     * @param activity
     * @param requestCode
     */
    public static void startCaptureWithPermissionCheck(Activity activity , int requestCode){
        if (ActivityCompat.checkSelfPermission(activity, CAPTURE_PERMISSION) == PackageManager.PERMISSION_GRANTED) {
            startCapture(activity,requestCode);
        }else{
            ActivityCompat.requestPermissions(activity, new String[] {CAPTURE_PERMISSION}, requestCode);
        }
    }

    /**
     * 调用相机,并且将拍摄的照片存储到  FILE 中
     * @param activity
     * @param requestCode
     */
    public static void startCapture(Activity activity ,int requestCode){
//        FILE = new File(activity.getExternalFilesDir("img"),"TEMP.jpg");
        Intent i = new Intent();
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        //判断是否是AndroidN以及更高的版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            i.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID + ".fileProvider", FILE);
            i.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            Uri uri = Uri.fromFile(FILE);
            //指定存储路径，这样就可以保存原图了
            i.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }
        activity.startActivityForResult(i, requestCode);
    }

    /**
     * 获取拍照原图压缩后文件 的方法
     * @param fileName 压缩后的文件名
     * @return
     */
    public static File getCAMERAPhoto(String fileName){
        File file = compressFile(FILE.getAbsolutePath(),fileName);
        return file;
    }

    /**
     * 从图片文件中 获取 Bitmap
     * @param file
     * @return
     */
    public static Bitmap getBitmapFromFile(File file){
        return BitmapFactory.decodeFile(file.getPath());
    }


    /**
     * 根据原始图片路径，创建并返回压缩的图片文件
     * @param path
     * @param compressFileName
     * @return
     */
    public static File compressFile(String path,String compressFileName){
        File file2 = new File(path);
        double mbNumber2 = file2.length()/M_LENGTH;
        DecimalFormat df2   =new   DecimalFormat("###0.00");
        String s2= df2.format(mbNumber2);
        LogUtil.d("原文件大小", s2+"M");

//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Matrix m = new Matrix();
        m.setRotate(isRotate(path));
        m.postScale(0.2f,0.2f);
        Bitmap bitmap = BitmapFactory.decodeFile(path);//options
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, false);
        File file = new File(Environment.getExternalStorageDirectory()+"/"+compressFileName);
        try{
            FileOutputStream os  =  new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,QUALITY,os);
            double mbNumber = file.length()/M_LENGTH;
            DecimalFormat df   =new   DecimalFormat("###0.00");
            String s= df.format(mbNumber);
            LogUtil.d("压缩后文件大小", s+"M");
            os.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 图片文件 图像需要选装的角度
     * @param path
     * @return
     */
    private static int isRotate(String path){
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (Exception e) {
        }
        return degree;
    }

    public interface IBtnInterface {
        void action();
    }
}
