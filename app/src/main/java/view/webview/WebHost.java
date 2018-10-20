package view.webview;

import android.app.Activity;
import android.webkit.JavascriptInterface;

/**
 * Created by Zzz on 2017/7/5.
 */

public class WebHost {

    private Activity activity;

    public WebHost(Activity activity){
        this.activity = activity;
    }

    @JavascriptInterface
    public void finish(){
        activity.finish();
    }
}
