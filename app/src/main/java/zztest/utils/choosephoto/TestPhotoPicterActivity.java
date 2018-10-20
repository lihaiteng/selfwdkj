package zztest.utils.choosephoto;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.turui.yuncheng.R;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import activity.appcompat.ToolBarActivity;
import utils.choosephoto.ChoosePhotoUtil;
import utils.log.LogUtil;

/**
 * Created by Zzz on 2017/7/5.
 */

public class TestPhotoPicterActivity extends ToolBarActivity {

    @Override
    protected void initToolBar() {
        super.initToolBar();
        findToolbar(R.id.toolbar);
        setTitle("Li");
        setNavigation(R.drawable.ic_launcher);  //图片大小没法设置
//        setMenuId(R.menu.menu_main);
        setIToolbarNavigationListener(new IToolbarNavigationListener() {
            @Override
            public void onClickNavigation() {
                Toast.makeText(context, "setIToolbarNavigationListener", Toast.LENGTH_SHORT).show();
            }
        });
//        setIMenuItemListener(new IMenuItemListener() {
//            @Override
//            public void onMenuItemClick(MenuItem item) {
//                Toast.makeText(context, item.getTitle()+"<><>", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    //相册请求
    private final int REQUEST_CODE = 111;
    private final int REQUEST_CODE2 = 222;
    private final int REQUEST_CODE3 = 333;
    //相机请求
    private final int REQUEST_CODE_c = 1111;
    private final int REQUEST_CODE2_c = 2222;
    private final int REQUEST_CODE3_c = 3333;

    private Map<Integer,ImageView> map;
    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_activity_choosepic);
        ImageView imageView = (ImageView)findViewById(R.id.one);
        ImageView imageView2 = (ImageView)findViewById(R.id.two);
        ImageView imageView3 = (ImageView)findViewById(R.id.three);
        map = new HashMap<>();
        map.put(REQUEST_CODE,imageView);
        map.put(REQUEST_CODE2,imageView2);
        map.put(REQUEST_CODE3,imageView3);
        map.put(REQUEST_CODE_c,imageView);
        map.put(REQUEST_CODE2_c,imageView2);
        map.put(REQUEST_CODE3_c,imageView3);
    }

    public void two(View v){
        ChoosePhotoUtil.showDialog(activity,REQUEST_CODE2,REQUEST_CODE2_c);
    }
    public void three(View v){
        ChoosePhotoUtil.showDialog(activity,REQUEST_CODE3,REQUEST_CODE3_c);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            File file;
            if(REQUEST_CODE == requestCode || REQUEST_CODE2 == requestCode || REQUEST_CODE3 ==
                    requestCode){
                file = ChoosePhotoUtil.getChoosePhotoFile(data,activity,"TEST.jpg");
            }else{
                file = ChoosePhotoUtil.getCAMERAPhoto("TEST.jpg");
            }
            Bitmap bitmap = ChoosePhotoUtil.getBitmapFromFile(file);
            ImageView v = map.get(requestCode);
            v.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            LogUtil.d(permissions[0]);
            if(permissions[0] == ChoosePhotoUtil.PHOTO_PERMISSION ){
               ChoosePhotoUtil.startPhoto(activity,requestCode);
            }if( permissions[0] == ChoosePhotoUtil.CAPTURE_PERMISSION )
                ChoosePhotoUtil.startCapture(activity,requestCode);
            }
        }

}
