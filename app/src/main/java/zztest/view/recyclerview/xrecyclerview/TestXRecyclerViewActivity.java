package zztest.view.recyclerview.xrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.turui.yuncheng.R;

import java.util.ArrayList;
import activity.appcompat.ToolBarActivity;

/**
 * Created by Zzz on 2017/6/30.
 */

public class TestXRecyclerViewActivity extends ToolBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
    }

    private XRecyclerView recycler;
    private TestAdapter adapter;
    private ArrayList<String> data;
    private ArrayList<String> dataBase;
    boolean flag = true;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_activity_xrecycler);

        recycler = (XRecyclerView)findViewById(R.id.xrecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);

        data = new ArrayList<>();
        for(int i=0;i<15;i++){
            data.add("第一次-----"+i);
        }
        dataBase = data;
        adapter = new TestAdapter(data);
        recycler.setAdapter(adapter);

        View header =   LayoutInflater.from(this).inflate(R.layout.test_header_xrecycler, (ViewGroup)findViewById(android.R.id.content),false);
        recycler.addHeaderView(header);

        recycler.setLoadingMoreEnabled(false);

        recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        adapter.setData(dataBase);
                        recycler.refreshComplete();
                        flag = true;
                        recycler.setLoadingMoreEnabled(true);
                    }
                }, 1000);            //refresh data here
            }
            @Override
            public void onLoadMore() {
                if(flag){
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            for(int i = 0; i < 15 ;i++){
                                data.add("加载更多" + (i + data.size()) );
                            }
                            adapter.notifyDataSetChanged();
                            recycler.loadMoreComplete();
                            flag = false;
                        }
                    }, 1000);
                }else{
                    Toast.makeText(context,"无更多",Toast.LENGTH_SHORT).show();
                    recycler.setLoadingMoreEnabled(false);//不加这句底部会出现空白的部分
                }
            }
        });
    }

    @Override
    protected void initToolBar() {
        super.initToolBar();
        findToolbar(R.id.toolbar);
        setNavigation(R.drawable.ic_launcher);
        setIToolbarNavigationListener(new IToolbarNavigationListener() {
            @Override
            public void onClickNavigation() {
                activity.finish();
            }
        });
        setTitle("标题");
    }

    @Override
    protected void control() {
        super.control();
    }
}
