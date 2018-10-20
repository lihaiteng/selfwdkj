package zztest.activity.fragment.test;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.turui.yuncheng.R;

import activity.fragment.BaseFragmentActivity;
import view.myview.ViewTitleLayout1;

/**
 * Created by bockey on 2017/2/4.
 */
public class Test1FragmentsMainActivity extends BaseFragmentActivity {

    @Override
    protected void initTabBar() {
        super.initTabBar();
        setFragments(new Class[]{FragmentA.class, FragmentB.class});
        setTexts(new String[]{"AAA", "BBB"});
        setImgs(new int[]{R.drawable.b_spec_img_a, R.drawable.b_spec_img_a});
        setBadgeParam(R.color.white, R.color.green, 10f);
        setSpecViewID(R.layout.b_view_tabspec, R.id.img, R.id.text, R.id.badgeRel);
    }

    @Override
    protected void initToolBar() {
        super.initToolBar();
        findToolbar(R.id.toolbar);
        setNavigation(R.drawable.ic_launcher);
        setTitle("Li");
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
                Toast.makeText(context, item.getTitle() + "<><>", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    protected void initView(){
        super.initView();
        //使用自己布局
        TextView text;
        setLayoutID(R.layout.test_activity_fragments, R.id.aaa, R.id.bbb);
        text = (TextView)findViewById(R.id.text);
        text.setText("aaaaaaaaaa");

        //使用默认布局
//        setLayoutID();

        ViewTitleLayout1 vv = (ViewTitleLayout1)findViewById(R.id.title);
        vv.setTitleText("哈哈");
        vv.left_title_layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).finish();
            }
        });

    }

    @Override
    protected void control() {
        super.control();
        setBadge(0, 0);
        setBadge(1, 1);

    }

    @Override
    protected void doTabChanged(String tabId) {
        super.doTabChanged(tabId);
//        text.setText(tabId);
//        setTitle(tabId);
    }
}
