package zztest.view.recyclerview.recyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.turui.yuncheng.R;

import java.util.ArrayList;

import activity.base.BaseActivity;
import view.recyclerview.recyclerview.SimpleDecoration;

/**
 * Created by Zzz on 2017/7/3.
 */
//相同的adapter,不同的LaqyoutManager
public class TestRecyclerviewActivity extends BaseActivity {

    RecyclerView recycler1,recycler2,recycler3;
    ArrayList<String> data1,data2,data3;
    TestAdapter2 adapter2;
    LinearLayoutManager linearLayoutManager1;
    GridLayoutManager linearLayoutManager;
    StaggeredGridLayoutManager linearLayoutManager3;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_activity_recyclerview);
        data1 = new ArrayList<>();
        data2 = new ArrayList<>();
        data3 = new ArrayList<>();
        for(int a=0;a<10;a++){
            data1.add("one"+a);
        }
        for(int b=0;b<60;b++){
            data2.add("two"+b);
        }
        for(int c=0;c<10;c++){
            data3.add("three"+c);
        }
        adapter2 = new TestAdapter2(activity);
        adapter2.setData(data2);

        linearLayoutManager1 = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        //表格：不同宽高的item也会保持对齐，同一使用较大的尺度
        linearLayoutManager = new GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false);
        //瀑布流：不同宽高的item，会保持自己原有的尺度，这就是跟GridLayoutManager的区别
        linearLayoutManager3 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        recycler1 = (RecyclerView)findViewById(R.id.recycler1);
        recycler1.setLayoutManager(linearLayoutManager1);
        recycler1.addItemDecoration(new SimpleDecoration(context,LinearLayoutManager.VERTICAL));
        recycler1.setAdapter(adapter2);

        recycler2 = (RecyclerView)findViewById(R.id.recycler2);
        recycler2.setLayoutManager(linearLayoutManager);
        recycler2.addItemDecoration(new SimpleDecoration(context,SimpleDecoration.HORIZONTAL_LIST));
        recycler2.setAdapter(adapter2);

        recycler3 = (RecyclerView)findViewById(R.id.recycler3);
        recycler3.setLayoutManager(linearLayoutManager3);
        recycler3.addItemDecoration(new SimpleDecoration(context,SimpleDecoration.VERTICAL_LIST));
        recycler3.setAdapter(adapter2);
    }

    @Override
    protected void control() {
        super.control();

    }
}
