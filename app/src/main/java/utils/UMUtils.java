//package utils;
//
//import android.app.Activity;
//import android.widget.Toast;
//
//import com.umeng.socialize.ShareAction;
//import com.umeng.socialize.UMShareListener;
//import com.umeng.socialize.bean.SHARE_MEDIA;
//import com.umeng.socialize.media.UMImage;
//import com.umeng.socialize.media.UMWeb;
//import com.umeng.socialize.shareboard.SnsPlatform;
//import com.umeng.socialize.utils.ShareBoardlistener;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import utils.log.LogUtil;
//
///**
// * Created by link on 03/08/16.
// */
//public class UMUtils {
//    /**打开分享面板
//     * new ShareAction(MainActivity.this)
//     .setPlatform(SHARE_MEDIA.QQ)//传入平台
//     .withText("hello")//分享内容
//     .setCallback(umShareListener)//回调监听器
//     .share();
//     */
//
//    /**
//     *
//     * private UMShareListener shareListener = new UMShareListener() {
//            @Override
//            public void onStart(SHARE_MEDIA platform) {
//
//            }
//            @Override
//            public void onResult(SHARE_MEDIA platform) {
//                Toast.makeText(ShareDetailActivity.this,"成功了",Toast.LENGTH_LONG).show()；
//            }
//
//            @Override
//            public void onError(SHARE_MEDIA platform, Throwable t) {
//                Toast.makeText(ShareDetailActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onCancel(SHARE_MEDIA platform) {
//                Toast.makeText(ShareDetailActivity.this,"取消了",Toast.LENGTH_LONG).show();
//
//            }
//        };
//     */
//    private Activity activity;
//    private Map<SHARE_MEDIA,String> platformMap;
//    private ShareAction shareAction;
//
//    public UMUtils(Activity activity){
//        this.activity = activity;
//        platformMap = new HashMap<>();
//        platformMap.put(SHARE_MEDIA.WEIXIN,"微信");
//        platformMap.put(SHARE_MEDIA.WEIXIN_CIRCLE,"微信朋友圈");
//        shareAction = new ShareAction(activity).setDisplayList();
//    }
//
//
//
//    public void Open(final String text,final String imgUrl, final String url, final String title,
//                     final String description){
//        shareAction.setShareboardclickCallback(new ShareBoardlistener() {
//            @Override
//            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
//                new ShareAction(activity).withText(text)
//                        .setCallback(umShareListener)
//                        .withMedia(WebShare(imgUrl,url,title,description))
//                        .setPlatform(share_media)
//                        .share();
//
//            }
//        });
//    }
//
//    private UMWeb WebShare(String imgUrl,String url,String title,String description){
//        UMImage image = new UMImage(activity,imgUrl);
//
//        UMWeb web = new UMWeb(url);
//        web.setTitle(title);//标题
//        web.setThumb(image);  //缩略图
//        web.setDescription(description);//描述
//        return web;
//    }
//
//    private UMShareListener umShareListener = new UMShareListener() {
//        @Override
//        public void onStart(SHARE_MEDIA share_media) {
//
//        }
//
//        @Override
//        public void onResult(SHARE_MEDIA platform) {
//            Toast.makeText(activity, platformMap.get(platform) + " 分享成功", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onError(SHARE_MEDIA platform, Throwable t) {
//            Toast.makeText(activity, platformMap.get(platform) + " 分享失败", Toast.LENGTH_SHORT).show();
//            if (t != null) {
//                LogUtil.d("throw", "throw:" + t.getMessage());
//            }
//        }
//
//        @Override
//        public void onCancel(SHARE_MEDIA platform) {
//            Toast.makeText(activity, platformMap.get(platform) + " 分享取消", Toast.LENGTH_SHORT).show();
//        }
//    };
//}
