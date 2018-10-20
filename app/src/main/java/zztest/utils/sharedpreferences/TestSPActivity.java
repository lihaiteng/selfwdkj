package zztest.utils.sharedpreferences;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.turui.yuncheng.R;

import java.util.ArrayList;

import activity.base.BaseActivity;
import utils.log.LogUtil;
import utils.sharedpreferences.SharedpreferencesUtil;

/**
 * Created by Zzz on 2017/7/3.
 */

public class TestSPActivity extends BaseActivity {
    SharedpreferencesUtil spUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_retrofit_activity);
        spUtil = new SharedpreferencesUtil(context,"setting");

        TestBean bean = new TestBean();
        bean.age = 18;
        bean.name = null;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Petter");
        arrayList.add("Chalise");
        arrayList.add("Aliess");
        bean.arrayList = arrayList;
        spUtil.setEntity("one",bean);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
        spUtil.setBitmap("img",bitmap, Bitmap.CompressFormat.PNG,50);
    }

    public void one(View view){
        TestBean bean = (TestBean)spUtil.getEntity("one");
        LogUtil.d("bean",bean.age+"<--->"+bean.name+"<--->"+bean.arrayList.get(0)+"<--->"+bean.arrayList.get(1)+"<--->"+bean.arrayList.get(2));

        Bitmap bean2 = (Bitmap)spUtil.getBitmap("img");
        ImageView img = (ImageView) findViewById(R.id.img);
        img.setImageBitmap(bean2);
    }
}
