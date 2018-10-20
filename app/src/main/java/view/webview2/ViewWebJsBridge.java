package view.webview2;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.widget.ProgressBar;


import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.turui.yuncheng.R;

import view.myview.SelfBaseRelativeLayout;

public class ViewWebJsBridge extends SelfBaseRelativeLayout {

    private ProgressBar progressBar;
    private BridgeWebView webView;
    private WebSettings settings;

    public ViewWebJsBridge(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        getView(R.layout.b_view_jsbridgeweb);
        progressBar = (ProgressBar)findViewById(R.id.bar);


        webView = (BridgeWebView)findViewById(R.id.webview);
        settings = webView.getSettings();
        //设置获取焦点
        requestFocus();
        //设置没有缓存
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        //设置使用缓存
//        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //支持javascript
        settings.setJavaScriptEnabled(true);
        //自适应屏幕
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //手势缩放，且隐藏按钮
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        //启用地理定位
        settings.setGeolocationEnabled(true);
        String dir = context.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
        //设置定位的数据库路径
        settings.setGeolocationDatabasePath(dir);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
    }

    public ProgressBar getProgressbar(){
        return  progressBar;
    }

    public BridgeWebView getWebView(){
        return webView;
    }
}
