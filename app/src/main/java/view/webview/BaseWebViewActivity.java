package view.webview;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import activity.ActivityHelper;
import activity.appcompat.ToolBarActivity;
import utils.log.LogUtil;

/**
 * Created by Zzz on 2017/7/4.
 */

public class BaseWebViewActivity extends ToolBarActivity {

    private int PERMISSION_CALL_BACK = 111;

    private WebView webView;
    private ProgressBar progressbar;
    private WebHost webHost;

    @SuppressLint("JavascriptInterface")
    public void setWebView(WebView webView){
        this.webView = webView;
        webView.setWebViewClient(new MyWebViewClient());
        webHost = new WebHost(activity);
        webView.addJavascriptInterface(webHost,"js");//minSDK >=17 有效
    }

    public void setBack(){
        activityHelper = new ActivityHelper(activity, ActivityHelper.BackType.WEB,webView);
    }

    public void setProgressbar(ProgressBar bar){
        progressbar = bar;
        progressbar.setVisibility(View.VISIBLE);
        webView.setWebChromeClient(new MyWebChromeClient());
    }

    public void loadUrl(String url){
        LogUtil.d("url",url);
        webView.loadUrl(url);
    }

    //清除cookie缓存
    public void clearCache(){
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
    }

    private Intent intent;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_CALL_BACK && Manifest.permission.CALL_PHONE.equals(permissions[0]) && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            context.startActivity(intent);
        }
    }

    private Uri uri;
    public class MyWebViewClient extends WebViewClient {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("tel:")){
                uri= Uri.parse(url);
                intent = new Intent(Intent.ACTION_CALL,uri);
                if(ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    context.startActivity(intent);
                }else{
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CALL_BACK);
                }
                //这个超连接,java已经处理了
                return true;
            }
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    public class MyWebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                progressbar.setVisibility(View.GONE);
            } else {
                if (progressbar.getVisibility() == View.GONE)
                    progressbar.setVisibility(View.VISIBLE);
                progressbar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }
}
