package activity;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by bockey on 2017/2/6.
 */
public class ActivityHelper {

    //目标activity
    private Activity activity;

    //webActivity情况下的webviw控件
    private WebView webView;

    //双击退出app 的第一次时间记录
    private long beforeTime = 0;

    //点击back键后的执行类型
    public enum BackType{
        SIMPLE,  //finish
        MAIN,     //双击退出app
        WEB
    }

    private BackType backType = BackType.SIMPLE;

    public void setBackType(BackType backType){
        this.backType = backType;
    }

    public ActivityHelper(Activity activity){
        this.activity = activity;
    }

    public ActivityHelper(Activity activity, BackType backType){
        this(activity);
        if(backType != null){
            this.backType = backType;
        }
    }

    public ActivityHelper(Activity activity, BackType backType, WebView webView){
        this(activity,backType);
        this.webView = webView;
    }

    public boolean onBackDwon() {
        switch (backType){
            case WEB:
                if(webView!=null){
                    if(webView.canGoBack()){
                        webView.goBack();
                    }else if(!webView.canGoBack() ){
                        backDoForMain();
                    }
                    return true;
                }//如果webView 那么back操作执行simple的finish
            case SIMPLE:
                activity.finish();
                return true;
            case MAIN:
                backDoForMain();
                return true;
        }
        return false;
    }

    private void backDoForMain(){
        long time = System.currentTimeMillis();
        if( time - beforeTime > 2000){
            Toast.makeText(activity, "再次点击退出程序", Toast.LENGTH_SHORT).show();
            beforeTime = time;
        }else{
            activity.finish();
        }
    }

}
