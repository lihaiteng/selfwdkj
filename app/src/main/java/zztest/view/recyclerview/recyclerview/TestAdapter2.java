package zztest.view.recyclerview.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.turui.yuncheng.R;

import java.util.ArrayList;

import view.recyclerview.recyclerview.BaseRecyclerViewAdapter;

/**
 * Created by Zzz on 2017/6/30.
 */

public class TestAdapter2 extends BaseRecyclerViewAdapter<String> {

    public TestAdapter2(Activity c) {
        super(c);
    }

    public TestAdapter2(Activity c, ArrayList data) {
        super(c, data);
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                View view1 = inflater.inflate(getMyItemId(1),parent,false);
                MyViewHolder1 vh1 = new MyViewHolder1(view1);
                return vh1;
            case 2:
                View view2 = inflater.inflate(getMyItemId(2),parent,false);
                MyViewHolder2 vh2 = new MyViewHolder2(view2);
                return vh2;
            default:
                return null;
        }
    }

    //对ViewHolder做绑定操作
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        switch (viewType){
            case 1:
                MyViewHolder1 vh1 = (MyViewHolder1)holder;
                vh1.textView.setText(data.get(position));
                vh1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"监听1"+data.get(position),Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 2:
                MyViewHolder2 vh2 = (MyViewHolder2)holder;
                vh2.btn.setText(data.get(position));
                vh2.btn.setClickable(false);
                vh2.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"监听2"+data.get(position),Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

    //获取item总数
    @Override
    public int getItemCount() {
        return data.size();
    }

    //获取item的类型
    @Override
    public int getItemViewType(int position) {
        return position%2 == 0 ? 1 : 2;
    }

    //用type获取item的布局id
    public int getMyItemId(int type){
        return type == 1 ? R.layout.test_item_xrecycler : R.layout.test_item_recycler;
    }

    //用position获取item的布局id
    @Override
    public long getItemId(int position) {
        return position%2 == 0 ? R.layout.test_item_xrecycler : R.layout.test_item_recycler;
    }

    //类型一的item的ViewHolder
    public static class MyViewHolder1 extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder1(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }

    //类型二的item的ViewHolder
    public static class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView btn;
        public MyViewHolder2(View itemView) {
            super(itemView);
            btn = (TextView)itemView.findViewById(R.id.btn);
        }
    }

}
