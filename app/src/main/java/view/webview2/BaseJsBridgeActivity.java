package view.webview2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.github.lzyzsd.jsbridge.BridgeWebView;

import activity.ActivityHelper;
import activity.appcompat.ToolBarActivity;
import utils.choosephoto.ChoosePhotoUtil;
import utils.dialog.ChangeDialogTextColorUtil;
import utils.log.LogUtil;

public class BaseJsBridgeActivity extends ToolBarActivity {

    private static final int PERMISSION_CALL_BACK = 0;
    public static final int FILECHOOSER_RESULTCODE = 1;
    private static final int REQ_CAMERA = 2;
    private static final int REQ_CHOOSE = 3;

    private BridgeWebView webView;
    private ProgressBar progressbar;


    @SuppressLint("JavascriptInterface")
    public void setWebView(BridgeWebView webView){
        this.webView = webView;
        webView.setWebViewClient(new MyWebViewClient());
        setBack();
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
        url+="?isWX=false";
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

    /**
     * 返回文件选择
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        LogUtil.d(mUploadMessage == null);
        LogUtil.d(mFilePathCallback == null);
        if ( mUploadMessage== null && mFilePathCallback == null)
            return;
        Uri uri = null;
        if (requestCode == REQ_CAMERA) {
            LogUtil.d("相机回调");
            uri = Uri.fromFile(ChoosePhotoUtil.getCAMERAPhoto("Temp.jpg"));
        } else if (requestCode == REQ_CHOOSE) {
            LogUtil.d("相册回调");
            if (intent == null) {
                LogUtil.d("intent is null");
                Uri[] uris = new Uri[1];
                uris[0] = Uri.parse("");
                mFilePathCallback.onReceiveValue(uris);
                mFilePathCallback = null;
                return;
            }
            uri =  Uri.fromFile(ChoosePhotoUtil.getChoosePhotoFile(intent,activity,"Temp.jpg"));
        }
        if(uri != null){
            if (mFilePathCallback != null) {
                Uri[] uris = new Uri[1];
                uris[0] = uri;
                mFilePathCallback.onReceiveValue(uris);
            } else {
                mUploadMessage.onReceiveValue(uri);
            }
            mFilePathCallback = null;
            mUploadMessage = null;
        }else{
            if (mFilePathCallback != null) {
                Uri[] uris = new Uri[1];
                uris[0] = Uri.parse("");
                mFilePathCallback.onReceiveValue(uris);
                mFilePathCallback = null;
            } else {
                mUploadMessage.onReceiveValue(Uri.parse(""));
                mUploadMessage = null;
            }
        }
        super.onActivityResult(requestCode, resultCode, intent);
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
            if(!url.contains("isWX")){
                if(url.contains("?")){
                    url+="&isWX=false";
                }else{
                    url+="?isWX=false";
                }
            }
            LogUtil.d(url);
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

    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mFilePathCallback;
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

        /**
         * alert弹框
         * @return
         */
        @Override
        public boolean onJsAlert(WebView view, String url, final String message, JsResult result) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder .setTitle("提示")
                            .setMessage(message)
                            .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    ChangeDialogTextColorUtil.GetAlertDialogTitleMsg(dialog, Color.BLACK,Color.BLACK);
                }
            });
            result.confirm();//这里必须调用，否则页面会阻塞造成假死
            return true;
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin,GeolocationPermissions.Callback callback) {
            callback.invoke(origin, true, false);
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }


        public boolean onShowFileChooser(
                WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            LogUtil.d("onShowFileChooser");
            if (mFilePathCallback != null) return true;
            mFilePathCallback = filePathCallback;
            selectImage();
            return true;
        }

        // For Android 3.0+
        public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
            LogUtil.d("openFileChooser For Android 3.0+");
            if (mUploadMessage != null) return;
            mUploadMessage = uploadMsg;
            selectImage();
        }

        // For Android < 3.0
        public void openFileChooser(ValueCallback<Uri> uploadMsg) {
            LogUtil.d("openFileChooser or Android < 3.0");
            openFileChooser(uploadMsg, "");
        }

        // For Android  > 4.1.1
        public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            LogUtil.d("openFileChooser For Android  > 4.1.1");
            openFileChooser(uploadMsg, acceptType);
        }
    }

    protected final void selectImage() {
        ChoosePhotoUtil.showDialog(activity, new ChoosePhotoUtil.IBtnInterface() {
            @Override
            public void action() {
                ChoosePhotoUtil.startPhoto(activity, REQ_CHOOSE);
            }
        }, new ChoosePhotoUtil.IBtnInterface() {
            @Override
            public void action() {
                ChoosePhotoUtil.startCapture(activity, REQ_CAMERA);
            }
        }, new ChoosePhotoUtil.IBtnInterface() {
            @Override
            public void action() {
                if (mFilePathCallback != null) {
                    Uri[] uris = new Uri[1];
                    uris[0] = Uri.parse("");
                    mFilePathCallback.onReceiveValue(uris);
                    mFilePathCallback = null;
                } else {
                    mUploadMessage.onReceiveValue(Uri.parse(""));
                    mUploadMessage = null;
                }
            }
        });
    }
}
