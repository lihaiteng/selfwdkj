package view.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.turui.yuncheng.R;

import utils.DensityUtil;

/**
 * Created by bockey on 2017/3/28.
 */
public class ViewTitleLayout1 extends SelfBaseRelativeLayout {

    //控件
    public RelativeLayout left_title_layout1;

    public RelativeLayout left_title_layout2;

    public RelativeLayout centerLayout;

    public RelativeLayout right_title_layout1;

    public RelativeLayout right_title_layout2;

    public RelativeLayout right_title_layout3;

    private ImageView leftImg1,leftImg2,rightImg1,rightImg2,rightImg3;

    private TextView titleText;

    //属性
    private int bgColor;

    private int paddingSize;

    private int leftImgSrc1,leftImgSrc2,rightImgSrc1,rightImgSrc2,rightImgSrc3;

    private int title1TextColor;

    private String title1_text;

    public ViewTitleLayout1(Context context, AttributeSet attrs){
        super(context,attrs);

        getTypeArray(R.styleable.ViewTitleLayout1);

        bgColor = typedArray.getColor(R.styleable.ViewTitleLayout1_title1_bg_color,getResources().getColor(R.color.colorPrimary));

        paddingSize = typedArray.getInt(R.styleable.ViewTitleLayout1_title1_paddingside, DensityUtil.dip2px(context, 10));

        title1TextColor = typedArray.getColor(R.styleable.ViewTitleLayout1_title1_text_color,getResources().getColor(R.color.titleTextColor));

        title1_text = typedArray.getString(R.styleable.ViewTitleLayout1_title1_text);

        leftImgSrc1 = typedArray.getResourceId(R.styleable.ViewTitleLayout1_title1_left1_img, 0);

        leftImgSrc2 = typedArray.getResourceId(R.styleable.ViewTitleLayout1_title1_left2_img,0);

        rightImgSrc1 = typedArray.getResourceId(R.styleable.ViewTitleLayout1_title1_right1_img,0);

        rightImgSrc2 = typedArray.getResourceId(R.styleable.ViewTitleLayout1_title1_right2_img,0);

        rightImgSrc3 = typedArray.getResourceId(R.styleable.ViewTitleLayout1_title1_right3_img,0);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        getView(R.layout.b_view_titlelayout);

        left_title_layout1 = (RelativeLayout)findViewById(R.id.left_title_layout1);

        left_title_layout2 = (RelativeLayout)findViewById(R.id.left_title_layout2);

        centerLayout = (RelativeLayout)findViewById(R.id.centerLayout);

        right_title_layout1 = (RelativeLayout)findViewById(R.id.right_title_layout1);

        right_title_layout2 = (RelativeLayout)findViewById(R.id.right_title_layout2);

        right_title_layout3 = (RelativeLayout)findViewById(R.id.right_title_layout3);

        leftImg1 = (ImageView)findViewById(R.id.leftImg1);

        leftImg2 = (ImageView)findViewById(R.id.leftImg2);

        rightImg1 = (ImageView)findViewById(R.id.rightImg1);

        rightImg2 = (ImageView)findViewById(R.id.rightImg2);

        rightImg3 = (ImageView)findViewById(R.id.rightImg3);

        titleText = (TextView)findViewById(R.id.titleText);

        setBgColor(bgColor).setPaddingSize(paddingSize)
                .setImgs(leftImgSrc1, leftImgSrc2, rightImgSrc1, rightImgSrc2, rightImgSrc3)
                .setTitleText(title1_text)
                .setTitleTextColor(title1TextColor);
    }

    //设置背景色
    public ViewTitleLayout1 setBgColor(int color){
        setBackgroundColor(color);

        return this;
    }

    //设置设置左右padding
    public ViewTitleLayout1 setPaddingSize(int padSize){
        setPadding(padSize, 0, padSize, 0);

        return this;
    }

    //设置图片
    public ViewTitleLayout1 setImgs(int l1,int l2,int r1,int r2,int r3){
        if(l1 != 0)
            leftImg1.setImageResource(l1);
        if(l2 != 0)
            leftImg2.setImageResource(l2);
        if(r1 != 0)
            rightImg1.setImageResource(r1);
        if(r2 != 0)
            rightImg2.setImageResource(r2);
        if(r3 != 0)
            rightImg3.setImageResource(r3);
        return this;
    }
    //标题设置
    public ViewTitleLayout1 setTitleText(String s){
        titleText.setText(s);
        return this;
    }

    public ViewTitleLayout1 setTitleTextColor(int color){
        titleText.setTextColor(color);
        return this;
    }

}
