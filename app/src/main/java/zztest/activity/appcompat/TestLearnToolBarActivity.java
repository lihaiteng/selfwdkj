package zztest.activity.appcompat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.turui.yuncheng.R;

/**
 * Created by bockey on 2017/2/6.
 */
public class TestLearnToolBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_toolbar_activity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_launcher);//设置toolbar的大图标最左边，也可以在style中设置
        toolbar.setLogo(R.drawable.ic_launcher);//设置toolbar的小图标
        toolbar.setTitle("Tilte");//设置toolbar的大标题
        toolbar.setSubtitle("SubTitle");//设置toolbar的小标题
        //有些设置要放到这个方法之后才有效，
        //比如setNavigationOnClickListener
        //比如setOnMenuItemClickListener
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_a:
                        Toast.makeText(TestLearnToolBarActivity.this, "aaaa", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_b:
                        Toast.makeText(TestLearnToolBarActivity.this, "bbbb", Toast.LENGTH_SHORT).show();
                        break;
//                    case R.id.action_selfmore:
//                        Toast.makeText(TestLearnToolBarActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
//                        break;
                    case R.id.action_c:
                        Toast.makeText(TestLearnToolBarActivity.this, "cccc", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_d:
                        Toast.makeText(TestLearnToolBarActivity.this, "dddd", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_e:
                        Toast.makeText(TestLearnToolBarActivity.this, "eeee", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
    //引入菜单资源,在这里也可以给menu设置点击事件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //作用和上面的  toolbar.setOnMenuItemClickListener  是一样的，两者二选一
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("onOptionsItemSelected",item.toString());
        return false;
    }
}
