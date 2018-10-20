//package zztest.service;
//
//import android.content.Intent;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Toast;
//
//import com.turui.yuncheng.R;
//
//import activity.appcompat.ToolBarActivity;
//import service.DownAPKService;
//
///**
// * Created by liht on 2018/5/14 0014.
// */
//
//public class TestDownAPKServiceActivity extends ToolBarActivity {
//
//    @Override
//    protected void initView() {
//        super.initView();
//        setContentView(R.layout.test_downapk_service);
//    }
//
//    @Override
//    protected void initToolBar() {
//        super.initToolBar();
//        findToolbar(R.id.toolbar);
//        setTitle("Li");
//        setNavigation(R.drawable.ic_launcher);  //图片大小没法设置
//        setMenuId(R.menu.menu_main);
//        setIToolbarNavigationListener(new IToolbarNavigationListener() {
//            @Override
//            public void onClickNavigation() {
//                Toast.makeText(context, "setIToolbarNavigationListener", Toast.LENGTH_SHORT).show();
//            }
//        });
//        setIMenuItemListener(new IMenuItemListener() {
//            @Override
//            public void onMenuItemClick(MenuItem item) {
//                Toast.makeText(context, item.getTitle()+"<><>", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void downapk(View v){
//        Intent intent = new Intent(this, DownAPKService.class);
//        intent.putExtra("apkurl","http://www.swxiangge.com/Android/swxiangge.apk");
//        startService(intent);
//    }
//}
