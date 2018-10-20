package zztest.utils.log;

import android.widget.TextView;

import com.turui.yuncheng.BuildConfig;
import com.turui.yuncheng.R;

import activity.base.BaseActivity;
import utils.log.LogUtil;

/**
 * Created by bockey on 2017/2/10.
 */
public class TestLogActivity extends BaseActivity {

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_activity_log);
        LogUtil.d("aaaaaaa");
        LogUtil.d("1111","2222");
        TextView text = (TextView)findViewById(R.id.text);
        text.setText(String.valueOf(BuildConfig.DEBUG));

        //获取栈信息
        StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                System.out.print(stackElements[i].getClassName()+"/t");
                //打印classname
                System.out.print(stackElements[i].getFileName()+"/t");
                //打印filename
                System.out.print(stackElements[i].getLineNumber()+"/t");
                //打印linenumber
                System.out.println(stackElements[i].getMethodName());
                //打印methodname
                System.out.println("-----------------------------------");
            }
        }
    }

    @Override
    protected void control() {
        super.control();
    }
}
