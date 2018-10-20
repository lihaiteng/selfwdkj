package zztest.activity.appcompat;

import android.view.MenuItem;
import android.widget.Toast;

import com.turui.yuncheng.R;

import activity.appcompat.ToolBarActivity;
import activity.ActivityHelper;

/**
 * Created by bockey on 2017/2/6.
 */
public class TestUseToolBarActivity extends ToolBarActivity {

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_toolbar_activity);
        //other findview
    }

    @Override
    protected void initToolBar() {
        super.initToolBar();
        findToolbar(R.id.toolbar);
        setTitle("Li");
        setNavigation(R.drawable.ic_launcher);  //图片大小没法设置
        setMenuId(R.menu.menu_main);
        setIToolbarNavigationListener(new IToolbarNavigationListener() {
            @Override
            public void onClickNavigation() {
                Toast.makeText(context, "setIToolbarNavigationListener", Toast.LENGTH_SHORT).show();
            }
        });
        setIMenuItemListener(new IMenuItemListener() {
            @Override
            public void onMenuItemClick(MenuItem item) {
                Toast.makeText(context, item.getTitle()+"<><>", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void control() {
        super.control();
        setBackType(ActivityHelper.BackType.MAIN);
    }
}
