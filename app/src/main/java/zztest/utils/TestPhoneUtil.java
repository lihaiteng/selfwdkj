package zztest.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.turui.yuncheng.R;

import utils.PhoneUtil;

/**
 * Created by liht on 2018/5/15 0015.
 */

public class TestPhoneUtil extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_util_phone);

        TextView text = (TextView)findViewById(R.id.text);

        text.setText(PhoneUtil.OutPackageSelfDirPath(this,"DownLoad"));

    }
}
