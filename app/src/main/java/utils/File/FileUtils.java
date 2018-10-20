package utils.File;

import android.net.Uri;
import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import app.AppData;
import utils.log.LogUtil;

public class FileUtils {
    /**
     * 通过Uri获取文件
     * @param uri
     * @return
     */
    public static File getFile(Uri uri){
        return new File(uri.toString());
    }

    /**
     * 获取File的Uri
     * @param file
     * @return
     */
    public static Uri getUri(File file){
        return Uri.fromFile(file);
    }

    /**
     * 把输入流中内容写入到文件
     * @param file
     * @param is
     * @return
     */
    public static boolean writeFromIs(File file, InputStream is){
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int len ;
            byte [] buff = new byte[1024];
            while((len=is.read(buff))!=-1){
                os.write(buff,0,len);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch(IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch(IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
    }

    /**
     * 删除该文件
     *
     * @param path
     */
    public static void delFile(String path) {
        if (!TextUtils.isEmpty(path)) {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * 清空文件夹
     */
    public static void clearDic(File file,String endStr) {
        if (file!=null && file.exists()) {
            for(File pic : file.listFiles()){
                if("".equals(endStr)||endStr==null){
                    pic.delete();
                }else if(pic.getName().endsWith(endStr)){
                    pic.delete();
                }
            }
        }
    }

    public static void clearDic(File file) {
        clearDic(file,null);
    }

    public static void initAppDic(){
        File AppDic;
        File Temp;
        File TempPic;
        File TempFile;
        if(!(AppDic = new File(AppData.APPDIC)).exists()){
            LogUtil.d("create APPDIC:"+AppDic.mkdir());
        }
        if(!(Temp = new File(AppData.Temp)).exists()){
            LogUtil.d("create APPDIC:"+Temp.mkdir());
        }else{
            clearDic(Temp);
        }
        if(!(TempPic = new File(AppData.TempPIC)).exists()){
            TempPic.mkdir();
        }else{
            clearDic(TempPic);
        }
        if(!(TempFile = new File(AppData.TempFile)).exists()){
            TempFile.mkdir();
        }else{
            clearDic(TempFile);
        }
    }
}
