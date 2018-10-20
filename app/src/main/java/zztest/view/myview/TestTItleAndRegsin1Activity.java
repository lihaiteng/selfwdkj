package zztest.view.myview;

import android.os.Bundle;
import android.widget.Toast;

import com.turui.yuncheng.R;

import activity.base.BaseActivity;
import view.base.EditTextHelper;
import view.myview.ViewRegsin1;

/**
 * Created by bockey on 2017/3/28.
 */
public class TestTItleAndRegsin1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);

        ((ViewRegsin1)findViewById(R.id.viewRegsin1)).setCodeBtnClick(new ViewRegsin1.IFForGetCode() {
            @Override
            public boolean httpForGetCode() {
                return true;
            }
        });

        ((ViewRegsin1)findViewById(R.id.viewRegsin1)).setImOption(EditTextHelper.ImoptionType.NEXT, new EditTextHelper.IfOnClockDown() {
            @Override
            public void onClickDown() {
                Toast.makeText(context,"点击了键盘next",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
