package zztest.activity.base;

import android.widget.Toast;

import com.turui.yuncheng.R;

import activity.ActivityHelper;
import activity.base.BaseActivity;
import view.base.EditTextHelper;
import view.myview.ViewRegsin1;

public class TestBaseActivity extends BaseActivity {

    ViewRegsin1 viewRegsin1;

    @Override
    protected void initView() {
        super.initView();

        setContentView(R.layout.test_activity_base);

        viewRegsin1 = (ViewRegsin1)findViewById(R.id.viewRegsin1);

        viewRegsin1.setCodeBtnClick(new ViewRegsin1.IFForGetCode() {
            @Override
            public boolean httpForGetCode() {
                return true;
            }
        });

        viewRegsin1.setImOption(EditTextHelper.ImoptionType.NEXT, new EditTextHelper.IfOnClockDown() {
            @Override
            public void onClickDown() {
                Toast.makeText(TestBaseActivity.this, "点击了键盘右下角哦", Toast.LENGTH_SHORT).show();
            }
        });

        setBackType(ActivityHelper.BackType.SIMPLE);
    }

    @Override
    protected void initSpecil() {
        super.initSpecil();
    }

    @Override
    protected void control() {
        super.control();
    }
}
