package utils.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import utils.log.LogUtil;

public class SharedpreferencesUtil{

    private SharedPreferences settings;

    private SharedPreferences.Editor editor;

    private String fileName;//存储文件名

    private Context context;

    //一个settings 对应一个本地缓存文件
    public SharedpreferencesUtil(Context context,String fileName) {
        this.context = context;
        this.fileName = fileName;
        settings = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editor = settings.edit();
    }

//----------------设置数据-----------------------
    public void setSP(String key, String value) {
        if (value == null) {
            return;
        }
        editor.putString(key, value);
        editor.commit();
    }

    public void setSP(String key,boolean value){
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void setSP(String key,int value){
        editor.putInt(key, value);
        editor.commit();
    }

    public void setSP(String key,float value){
        editor.putFloat(key, value);
        editor.commit();
    }

    public void setSP(String key,long value){
        editor.putLong(key, value);
        editor.commit();
    }

    //存储实体类
    public void setEntity(String key,Object obj) {
        // 创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 创建对象输出流，并封装字节流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // 将对象写入字节流
            oos.writeObject(obj);
            // ******将字节流编码成base64的字符窜
            String obj_Base64 = new String(Base64.encodeBase64(baos.toByteArray()));
            LogUtil.d("set entity"+key,obj_Base64);
            editor.putString(key, obj_Base64);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //存储Bitmap类
    public void setBitmap(String key,Bitmap bitmap,Bitmap.CompressFormat type,int quality){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(type, quality, byteArrayOutputStream);
        String picBase64=new String(Base64.encodeBase64(byteArrayOutputStream.toByteArray()));
        LogUtil.d("set bitmap"+key,picBase64);
        editor.putString(key,picBase64);
        editor.commit();
    }

    //-----------------获取数据----------------------
    public String getSP(String key, String value) {
        String s = settings.getString(key, value);
        return s;
    }

    public boolean getSP(String key, boolean value) {
        boolean s = settings.getBoolean(key, value);
        return s;
    }

    public int getSP(String key, int value) {
        int s = settings.getInt(key, value);
        return s;
    }

    public float getSP(String key, float value) {
        float s = settings.getFloat(key, value);
        return s;
    }

    public long getSP(String key, long value) {
        long s = settings.getLong(key, value);
        return s;
    }

    //获取实体类
    public Object getEntity(String key){
        Object obj = null;
        String obj_Base64 = settings.getString(key, "");
        LogUtil.d("get entity"+key,obj_Base64);
        if(obj_Base64.equals("")){
            return null;
        }
        //读取字节
        byte[] base64 = Base64.decodeBase64(obj_Base64.getBytes());
        //**********封装到字节流
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
        try {
            //再次封装
            ObjectInputStream bis = new ObjectInputStream(bais);
            obj = bis.readObject();
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    //获取Bitmap类
    public Bitmap getBitmap(String key){
        Bitmap bitmap=null;
        String pic_Base64 = settings.getString(key, "");
        LogUtil.d("get bitmap"+key,pic_Base64);
        if(pic_Base64.equals("")){
            return  null;
        }
        byte[] base64 = Base64.decodeBase64(pic_Base64.getBytes());
        bitmap= BitmapFactory.decodeByteArray(base64,0,base64.length);
        return bitmap;
    }

    //清空某个缓存文件的数据
    public void clearFile(){
        editor.clear();
        editor.commit();
    }
    //remove某个key的数据
    public void removeKey(String key){
        editor.remove(key);
        editor.commit();
    }
    //remove某些key以外的数据 TODO
}

