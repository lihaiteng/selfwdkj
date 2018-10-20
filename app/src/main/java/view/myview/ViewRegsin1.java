package view.myview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.turui.yuncheng.R;

import java.util.Timer;
import java.util.TimerTask;

import view.base.EditTextHelper;

/**
 * Created by link on 28/12/2016.
 */

public class ViewRegsin1 extends SelfBaseRelativeLayout{

    //EditText的帮助类
    private EditTextHelper editTextHelper;

    //控件
    private RelativeLayout rel;

    private ImageView leftImg;

    private TextView leftText;

    private EditText rightEditText;

    private Button codeBtn;


    //布局属性
    private int regsin1_background;

    private int regsin1_leftimg_src;

    private String regsin1_left_text;

    private int regsin1_edit_background;

    private String regsin1_edit_hint;

    private String regsin1_btn_start_text;

    private String regsin1_btn_end_text;

    private int regsin1_btn_start_text_color;

    private int regsin1_btn_end_text_color;

    private int regsin1_btn_background;

    private int regsin1_time;

    //字段
    private int baseTime;

    //其它
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    setCode(regsin1_time+" S");
                    regsin1_time -= 1;
                    setCodeBtnTextColor(regsin1_btn_end_text_color);
                    break;
                case 2:
                    timer.cancel();
                    setCode(regsin1_btn_end_text, 1);
                    setCodeBtnTextColor(regsin1_btn_start_text_color);
                    codeBtn.setEnabled(true);
                    regsin1_time = baseTime;
                    break;
            }
        }
    };

    private class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            if(regsin1_time >= 0){
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }else{
                Message msg = new Message();
                msg.what = 2;
                handler.sendMessage(msg);
            }
        }
    };

    private Timer timer;
    private MyTimerTask timerTask;

    public ViewRegsin1(Context context, AttributeSet attrs) {
        super(context, attrs);

        getTypeArray(R.styleable.ViewRegsin1);

        regsin1_background = typedArray.getResourceId(R.styleable.ViewRegsin1_regsin1_background,0);

        regsin1_leftimg_src = typedArray.getResourceId(R.styleable.ViewRegsin1_regsin1_leftimg_src, 0);

        regsin1_left_text = typedArray.getString(R.styleable.ViewRegsin1_regsin1_left_text);

        regsin1_edit_background = typedArray.getResourceId(R.styleable.ViewRegsin1_regsin1_edit_background, 0);

        regsin1_edit_hint = typedArray.getString(R.styleable.ViewRegsin1_regsin1_edit_hint);

        regsin1_btn_start_text = typedArray.getString(R.styleable.ViewRegsin1_regsin1_btn_start_text);

        regsin1_btn_end_text = typedArray.getString(R.styleable.ViewRegsin1_regsin1_btn_end_text);

        regsin1_btn_start_text_color = typedArray.getColor(R.styleable.ViewRegsin1_regsin1_btn_start_text_color, context.getResources().getColor(R.color.white));

        regsin1_btn_end_text_color = typedArray.getColor(R.styleable.ViewRegsin1_regsin1_btn_end_text_color, context.getResources().getColor(R.color.black));

        regsin1_btn_background = typedArray.getResourceId(R.styleable.ViewRegsin1_regsin1_btn_background,0);

        regsin1_time = typedArray.getInt(R.styleable.ViewRegsin1_regsin1_time, 60);

        baseTime = regsin1_time;

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        getView(R.layout.b_view_verification);

        rel = (RelativeLayout)findViewById(R.id.rel);

        leftImg = (ImageView)findViewById(R.id.leftImg);

        leftText = (TextView)findViewById(R.id.leftText);

        rightEditText = (EditText)findViewById(R.id.rightEditText);

        codeBtn = (Button)findViewById(R.id.codeBtn);

        editTextHelper = new EditTextHelper(rightEditText);

        setBackground(regsin1_background);
        setLeftImg(regsin1_leftimg_src);
        setLeftText(regsin1_left_text);
        setEditHintText(regsin1_edit_hint);
        setCode(regsin1_btn_start_text, 0);
        setCodeBtnTextColor(regsin1_btn_start_text_color);
        setEditTextBackground(regsin1_edit_background);

    }

    public ViewRegsin1 setBackground(int color){
        if(color != 0)
            rel.setBackgroundColor(getResources().getColor(color));
        return this;
    }

    public ViewRegsin1 setLeftImg(int id){
        if(regsin1_leftimg_src != 0){
            leftImg.setVisibility(VISIBLE);
            leftImg.setImageResource(id);
        }else{
            leftImg.setVisibility(GONE);
        }

        return this;
    }

    public ViewRegsin1 setLeftText(String s){
        if(regsin1_left_text != null){
            leftText.setText(s);
        }else{
            leftText.setText("验证码:");
        }

        return this;
    }

    public ViewRegsin1 setEditHintText(String s) {
        editTextHelper.setEditHintText(s);
        return this;
    }

    public String getEditText() {
        return editTextHelper.getEditText();
    }

    public ViewRegsin1 setEditTextBackground(int res) {
        editTextHelper.setEditTextBackground(res);
        return this;
    }

    public ViewRegsin1 setInputLength(int length) {
        editTextHelper.setInputLength(length);
        return this;
    }

    public ViewRegsin1 getFource() {
        editTextHelper.getFource();
        return this;
    }

    public ViewRegsin1 lostFource() {
        editTextHelper.lostFource();
        return this;
    }

    public ViewRegsin1 setImOption(EditTextHelper.ImoptionType type, EditTextHelper.IfOnClockDown ifOnClockDown) {
        editTextHelper.setImOption(EditTextHelper.ImoptionType.NEXT,ifOnClockDown);
        return this;
    }

    //code btn
    public ViewRegsin1 setCode(String s,int type){

        switch (type){
            case 0:
                if(regsin1_btn_start_text == null){
                    s = "获取验证码";
                }
                break;
            case 1:
                if(regsin1_btn_start_text == null){
                    s = "重新获取";
                }
                break;
            default:
                break;
        }

        codeBtn.setText(s);

        return this;
    }

    public ViewRegsin1 setCode(String s){

        return setCode(s,-1);

    }

    public ViewRegsin1 setCodeBtnTextColor(int id){
        codeBtn.setTextColor(id);

        return this;
    }

    //TODO
    public ViewRegsin1 setCodeBtnClick(final IFForGetCode ifForGetCode){

        codeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifForGetCode.httpForGetCode()){
                    timer = new Timer();
                    timerTask = new MyTimerTask();
                    codeBtn.setEnabled(false);
                    timer.schedule(timerTask,0,1000);
                }
            }
        });

        return this;
    }

    public interface IFForGetCode{
        boolean httpForGetCode();
    }
}
