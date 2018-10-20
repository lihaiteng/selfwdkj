package activity.appcompat;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import activity.base.BaseActivity;

/**
 * Created by bockey on 2017/2/6.
 */
public class ToolBarActivity extends BaseActivity {

    protected Toolbar toolbar;

    private int menuId = -1; //菜单资源文件

    private IToolbarNavigationListener iNavigationClick; //左边图片的点击事件

    private IMenuItemListener iMenuItemClick; //菜单的点击事件

    @Override
    protected void initSpecil() {
        super.initSpecil();
        initToolBar();
    }

    //toolbar控件绑定,toolbar标题,menu等设置,可以使用ToolBar，也可以不使用，而去选择自定义的titlelayout
    protected void initToolBar() {
    }

    //传入toolbar控件的id
    public void findToolbar(int toolbarId){
        toolbar = (Toolbar)findViewById(toolbarId);
    }

//-----以下属性要在 initToolBar()中设置
    //设置菜单  菜单资源文件：res>menu
    protected void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    //菜单的监听
    protected void setIMenuItemListener(IMenuItemListener iface){
        iMenuItemClick = iface;
    }

    //back图标
    protected void setNavigation(int navigationResId){
        if(toolbar != null){
            toolbar.setNavigationIcon(navigationResId);
        }
    }

    //导航图标的监听  back
    protected void setIToolbarNavigationListener(IToolbarNavigationListener iface){
        iNavigationClick = iface;
    }

    protected void setLogo(int logoId){
        if(toolbar != null){
            toolbar.setLogo(logoId);
        }
    }

    //标题
    protected void setTitle(String title){
        if(toolbar != null){
            toolbar.setTitle(title);
        }
    }

    protected void setSubTitle(String subTitle){
        if(toolbar != null){
            toolbar.setTitle(subTitle);
        }
    }
//------ end

    protected void control() {
        super.control();
        try{
            if(toolbar != null){
                setSupportActionBar(toolbar); //有些设置要放到这个方法之后才有效,如 点击事件
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        if(iNavigationClick == null ){ //如果没有设置back按钮的监听，那么默认 finish
                            finish();
                        }else{
                            iNavigationClick.onClickNavigation();
                        }
                    }
                });
                toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(iMenuItemClick != null){
                            iMenuItemClick.onMenuItemClick(item);
                        }
                        return false;
                    }
                });
            }

        }catch (NullPointerException e){
            e.printStackTrace();
            Log.e("lht ToolBarActivity => ","子类中重写initSpecil()方法中,设置的布局没有 Toolbar , 或者在initSpecil()中没有find  toolbar");
        }
    }

    //back按钮的监听
    public interface IToolbarNavigationListener{
        void onClickNavigation();
    }

    //菜单的监听
    public interface IMenuItemListener{
        void onMenuItemClick(MenuItem item);
    }

    //通过 menuId 设置菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(toolbar != null && menuId != -1){
            getMenuInflater().inflate(menuId, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
