package zztest.view.somesimple;

import android.os.Handler;

import com.kyleduo.switchbutton.SwitchButton;
import com.turui.yuncheng.R;

import activity.base.BaseActivity;

public class TestSwitchButtonActivity extends BaseActivity {

    SwitchButton switchButton;

    Handler handler;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_activity_switchbtn);
        switchButton = (SwitchButton)findViewById(R.id.switchButton);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchButton.setChecked(!switchButton.isChecked());
                handler.postDelayed(this,3000);
            }
        },3000);
    }
}
