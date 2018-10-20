package view.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by bockey on 2017/1/21.
 */
public class SelfBaseRelativeLayout extends RelativeLayout{

    protected Context context;

    protected View view;

    protected LayoutInflater inflater;

    protected TypedArray typedArray;

    protected AttributeSet attrs;

    public SelfBaseRelativeLayout(Context context) {
        this(context,null);
    }

    public SelfBaseRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context,attrs);
    }

    protected void init(Context context, AttributeSet attrs) {

        this.context = context;

        this.attrs = attrs;

        inflater = LayoutInflater.from(context);

    }

    public void getTypeArray(int[] styleAttr){

        typedArray = context.obtainStyledAttributes(attrs,styleAttr);

    }

    public void getView(int layout){

        view = inflater.inflate(layout,this,true);

    }


}
