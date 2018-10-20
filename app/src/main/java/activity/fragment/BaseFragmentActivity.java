package activity.fragment;

import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.readystatesoftware.viewbadger.BadgeView;
import com.turui.yuncheng.R;

import java.util.ArrayList;

import activity.ActivityHelper;
import activity.appcompat.ToolBarActivity;

/**
 * Created by bockey on 2017/2/4.
 */
public class BaseFragmentActivity extends ToolBarActivity {

    protected Class[]  fragments;  //fragment数组

    protected String[] texts;   //spec标题数组

    protected int[] imgs;    //spec图标数组

    protected ArrayList<BadgeView> badgeViews;  //tab角标集合

    protected int layoutId = -1;  //home activity布局id

    protected int frameId;  //home activity布局中 fragment所在 桢布局的id

    protected int tabHostId; //home activity布局中 tabhost的id

    protected int specIndicator = -1; //tabhost每个spec的 view布局id

    protected int specImgId = -1; //spec 中 img空件id

    protected int specTextId = -1; //spec 中 text空件id

    protected int specBadgeRelId = -1; //spec角标id

    private int textColor = R.color.white; //badge 字体颜色

    private int backColor = R.color.red;  //badge 背景色

    private float textSize = 10f;  //badge 字体大小

    protected FrameLayout fragmentLayout;  //fragment所在 桢布局

    protected FragmentTabHost tabHost;

    //spec布局中的
    private RelativeLayout badgeRel; //包含角标的布局

    private TextView text;

    private ImageView img;

    @Override
    protected void initSpecil() {
        super.initSpecil();
        initTabBar();
        setTabSpec();
    }

    protected void initTabBar(){
    }

    @Override
    protected void control() {
        super.control();
        setBackType(ActivityHelper.BackType.MAIN);
    }

    /**
     * 不使用默认布局时需要 调用该方法
     * @param layoutId  布局id
     * @param frameId   桢布局id
     * @param tabHostId tabhost ID
     */
    protected void setLayoutID(int layoutId,int frameId,int tabHostId){
        this.layoutId = layoutId;
        this.frameId = frameId;
        this.tabHostId = tabHostId;
        setLayout(layoutId);
    }

    //使用默认的布局
    protected void setLayoutID(){
        setLayout(layoutId);
    }


    /**
     * 不使用默认spec布局时需要 调用该方法  无badge的情况
     * @param specIndicator spec的布局id
     * @param specImgId  spec中Imageview id
     * @param specTextId Textview id
     */
    protected void setSpecViewID(int specIndicator,int specImgId,int specTextId){
        setSpecViewID(specIndicator, specImgId, specTextId,-1);
    }

    //不使用默认spec布局时需要 调用该方法 有badge的情况
    protected void setSpecViewID(int specIndicator,int specImgId,int specTextId,int specBadgeRelId){
        this.specIndicator = specIndicator;
        this.specImgId = specImgId;
        this.specTextId = specTextId;
        this.specBadgeRelId =specBadgeRelId;
    }


    public void setFragments(Class[] fragments){
        this.fragments = fragments;
    }

    public void setTexts(String[] texts){
        this.texts = texts;
    }

    public void setImgs(int[] imgs){
        this.imgs = imgs;
    }

    private void setLayout(int layoutID){
        if(layoutID == -1){
            setContentView(R.layout.b_activity_home);//如果使用自定义布局，那么该布局必须存在特定规范的 桢布局和FragmentTabHost
            frameId = R.id.fragmentsLayout;
            tabHostId = R.id.tabHost;
        }else{
            setContentView(layoutID);
        }

        fragmentLayout = (FrameLayout)findViewById(frameId);

        tabHost = (FragmentTabHost)findViewById(tabHostId);
    }

    //设置Spec
    protected void setTabSpec(){

        badgeViews = new ArrayList<>();

        tabHost.setup(this, getSupportFragmentManager(), frameId);

        for(int i=0;i<fragments.length;i++){

            TabHost.TabSpec tabSpec = tabHost.newTabSpec(texts[i]).setIndicator(getIndicator(i));

            tabHost.addTab(tabSpec,fragments[i],null);

        }

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                doTabChanged(tabId);
            }
        });

    }

    //切换tab时会执行的方法
    protected void doTabChanged(String tabId){}

    //显示当前fragment
    protected void showCurFragment(int index){
        tabHost.setCurrentTab(index);
    }

    //设置badge的显示文字
    protected void setBadge(int index,String hint){
        if(badgeRel != null){
            BadgeView bv = badgeViews.get(index);
            bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
            bv.setText(hint);
            bv.setTextSize(textSize);
            bv.setTextColor(getResources().getColor(textColor));
            bv.setBadgeBackgroundColor(getResources().getColor(backColor));
            if(hint != null && !hint.equals("") && !hint.equals("0")){
                bv.show();
            }else{
                bv.hide();
            }
        }
    }

    //隐藏badge
    protected void hindBadge(int i){
        BadgeView bv = badgeViews.get(i);
        bv.hide();
    }

    protected void setBadge(int index, int hint) {
        setBadge(index, String.valueOf(hint));
    }

    //设置badge的属性，不然就使用默认的
    protected void setBadgeParam(int textColor,int backColor,float textSize){
        this.textColor = textColor;
        this.textSize = textSize;
        this.backColor = backColor;
    }

    //spec布局
    protected View getIndicator(int i){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        if(specIndicator == -1){
            specIndicator = R.layout.b_view_tabspec;
            specImgId = R.id.img;
            specTextId = R.id.text;
            specBadgeRelId = R.id.badgeRel;
        }

        view = inflater.inflate(specIndicator,null);

        badgeRel = (RelativeLayout)view.findViewById(specBadgeRelId);

        img = (ImageView)view.findViewById(specImgId);

        text = (TextView)view.findViewById(specTextId);

        img.setImageResource(imgs[i]);

        text.setText(texts[i]);

        BadgeView bv = new BadgeView(context,badgeRel);
        badgeViews.add(bv);
        setBadge(i, null);
        return view;
    }
}
