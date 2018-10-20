package zztest.view.recyclerview.swiperefreshlayout;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.turui.yuncheng.R;

import java.util.ArrayList;

import activity.appcompat.ToolBarActivity;
import zztest.view.recyclerview.recyclerview.TestAdapter2;

/**
 * Created by Zzz on 2017/6/30.
 */

public class TestSwipeRefreshLayoutActivity extends ToolBarActivity {

    private RecyclerView recycler;
    private TestAdapter2 adapter;
    private ArrayList<String> data;
    private SwipeRefreshLayout swipe_refresh_widget;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_activity_swipe);

        recycler = (RecyclerView)findViewById(R.id.recycler);
        swipe_refresh_widget = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_widget);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);

        data = new ArrayList<>();
        for(int i=0;i<15;i++){
            data.add("第一次-----"+i);
        }
        adapter = new TestAdapter2(this);
        adapter.setData(data);
        recycler.setAdapter(adapter);

        swipe_refresh_widget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        adapter.clearData();
                        for(int i = 0; i < 15 ;i++){
                            data.add("刷新之后-----" + i);
                        }
                        adapter.notifyDataSetChanged();
                        swipe_refresh_widget.setRefreshing(false);
                    }

                }, 1000);
            }
        });
        recycler.setOnScrollListener(new RecyclerView.OnScrollListener(){
            int lastVisibleItem ;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE ) {
                    if(lastVisibleItem + 1 >= 45){
                        Toast.makeText(context, "已无更多", Toast.LENGTH_SHORT).show();
                    }else if(lastVisibleItem + 1 == data.size()){
//                        swipe_refresh_widget.setRefreshing(true);
                        new Handler().postDelayed(new Runnable(){
                            public void run() {
                                for(int i = 0; i < 15 ;i++){
                                    data.add("加载更多" + (i + data.size()) );
                                }
                                adapter.notifyDataSetChanged();
//                                swipe_refresh_widget.setRefreshing(false);
                            }
                        }, 1000);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
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
