package view.recyclerview.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;

/**
 * Created by Zzz on 2017/7/3.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected ArrayList<T> data;
    protected Context context;
    protected Activity activity;
    protected LayoutInflater inflater;

    public BaseRecyclerViewAdapter(Activity c){
       this(c,null);
    }

    public BaseRecyclerViewAdapter(Activity c, ArrayList<T> data){
        context = c;
        activity = c;
        inflater = LayoutInflater.from(context);
        if(data == null)
            this.data = new ArrayList<T>();
        else
            this.data = data;
    }

    //数据的操作
    public void setData(ArrayList<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(ArrayList<T> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clearData(){
        data.clear();
        notifyDataSetChanged();
    }
}
