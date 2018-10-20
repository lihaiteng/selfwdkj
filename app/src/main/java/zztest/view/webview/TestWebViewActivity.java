package zztest.view.webview;

import com.turui.yuncheng.R;

import view.webview.BaseWebViewActivity;
import view.webview.ViewWeb;

/**
 * Created by Zzz on 2017/7/4.
 */

public class TestWebViewActivity extends BaseWebViewActivity {

    ViewWeb myWebView;

    @Override
    protected void initView() {
        super.initView();
        setContentView(R.layout.test_activity_webview);
        myWebView = (ViewWeb)findViewById(R.id.viewWeb);
        setWebView(myWebView.getWebView());
        setProgressbar(myWebView.getProgressbar());
        loadUrl("http://wyht.86818.cn");
    }
}
