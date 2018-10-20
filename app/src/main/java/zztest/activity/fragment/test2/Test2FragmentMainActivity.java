package zztest.activity.fragment.test2;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.turui.yuncheng.R;

import activity.fragment.BaseFragmentActivity;
import view.myview.ViewTitleLayout1;

/**
 * Created by bockey on 2017/2/4.
 */
public class Test2FragmentMainActivity extends BaseFragmentActivity {

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
//        findToolbar(R.id.toolbar);
//        setTitle("Li");
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
//                Toast.makeText(context, item.getTitle() + "<><>", Toast.LENGTH_SHORT).show();
//            }
//        });



    }

    TextView text;

    @Override
    protected void initView(){
        super.initView();

        setLayoutID(R.layout.test_activity_fragments2, R.id.aaa, R.id.bbb);

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
    }
}
