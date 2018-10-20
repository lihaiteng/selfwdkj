-optimizationpasses 5
-dontusemixedcaseclassnames
#-dontskipnonpubliclibraryclasses                ->如果应用程序引入的有jar包,并且想混淆jar包里面的class
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keep public class * extends android.app.Activity
-keep public class * extends android.support.v7.app.AppCompatActivity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

-dontwarn android.support.v4.**
-dontwarn android.support.v7.**
-dontwarn android.annotation


#-libraryjars libs/alipaySdk-20160223.jar
#-libraryjars libs/android-viewbadger.jar
#-libraryjars libs/core-3.0.0.jar
#-libraryjars libs/libammsdk.jar
#-libraryjars libs/libapshare.jar
#-libraryjars libs/mta-sdk-1.6.2.jar
#-libraryjars libs/open_sdk_r5756.jar
#-libraryjars libs/SocialSDK_tencentWB_3.jar
#-libraryjars libs/SocialSDK_WeiXin_2.jar
#-libraryjars libs/umeng_social_sdk.jar
#-libraryjars libs/universal-image-loader-1.9.5.jar
#-libraryjars libs/volley.jar
#-libraryjars libs/weiboSDKCore_3.1.4.jar


-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}

-keep class android.support.v4.**{*;}
-keep class android.support.v7.**{*;}
-keepattributes *Annotation*

#项目中的实体
-keep class http.bean.**{*;}
-keep class http.retrofit.HttpStatus{*;}



#对于引用第三方包的情况，可以采用下面方式避免打包出错：
#-libraryjars libs/aaa.jar
#-dontwarn com.xx.yy.**
#-keep class com.xx.yy.** { *;}

# Gson混淆脚本
-keep class com.google.gson.stream.** {*;}
-keep class com.youyou.uuelectric.renter.Network.user.** {*;}

 #支付宝
# -keep class com.alipay.android.app.IAliPay{*;}
# -keep class com.alipay.android.app.IAlixPay{*;}
# -keep class com.alipay.android.app.IRemoteServiceCallback{*;}
# -keep class com.alipay.android.app.lib.ResourceMap{*;}
-dontwarn com.alipay.**
-dontwarn com.ta.utdid2.**
-dontwarn com.ut.device.**
-keep class com.alipay.** { *; }
-keep class com.ta.utdid2.** { *; }
-keep class com.ut.device.** { *; }

# 微信支付
-dontwarn com.tencent.mm.**
-dontwarn com.tencent.wxop.stat.**
-keep class com.tencent.mm.** {*;}
-keep class com.tencent.wxop.stat.**{*;}

# 银联
-dontwarn com.unionpay.**
-keep class com.unionpay.** {*;}

# Retrofit
#-dontnote retrofit2.Platform
#-dontnote retrofit2.Platform$IOS$MainThreadExecutor
#-dontwarn retrofit2.Platform$Java8
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

 #-------------okhttp-----------------
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *;}
-dontwarn okio.**

# RxJava RxAndroid
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

# Fresco
-keep class com.facebook.fresco.** {*;}
-keep interface com.facebook.fresco.** {*;}
-keep enum com.facebook.fresco.** {*;}







-dontwarn com.handmark.pulltorefresh.library.**
-keep class com.handmark.pulltorefresh.library.** { *;}
-dontwarn com.handmark.pulltorefresh.library.extras.**
-keep class com.handmark.pulltorefresh.library.extras.** { *;}
-dontwarn com.handmark.pulltorefresh.library.internal.**
-keep class com.handmark.pulltorefresh.library.internal.** { *;}

 #-------------UM-----------------
 -dontshrink
  -dontoptimize
  -dontwarn com.google.android.maps.**
  -dontwarn android.webkit.WebView
  -dontwarn com.umeng.**
  -dontwarn com.tencent.weibo.sdk.**
  -dontwarn com.facebook.**
  -keep public class javax.**
  -keep public class android.webkit.**
  -dontwarn android.support.v4.**
  -keep enum com.facebook.**
  -keepattributes Exceptions,InnerClasses,Signature
  -keepattributes *Annotation*
  -keepattributes SourceFile,LineNumberTable

  -keep public interface com.facebook.**
  -keep public interface com.tencent.**
  -keep public interface com.umeng.socialize.**
  -keep public interface com.umeng.socialize.sensor.**
  -keep public interface com.umeng.scrshot.**

  -keep public class com.umeng.socialize.* {*;}


  -keep class com.facebook.**
  -keep class com.facebook.** { *; }
  -keep class com.umeng.scrshot.**
  -keep public class com.tencent.** {*;}
  -keep class com.umeng.socialize.sensor.**
  -keep class com.umeng.socialize.handler.**
  -keep class com.umeng.socialize.handler.*
  -keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}
  -keep class com.tencent.mm.sdk.modelmsg.** implements com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}

  -keep class im.yixin.sdk.api.YXMessage {*;}
  -keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}

  -dontwarn twitter4j.**
  -keep class twitter4j.** { *; }

  -keep class com.tencent.** {*;}
  -dontwarn com.tencent.**
  -keep public class com.umeng.soexample.R$*{
      public static final int *;
  }
  -keep public class com.umeng.soexample.R$*{
      public static final int *;
  }
  -keep class com.tencent.open.TDialog$*
  -keep class com.tencent.open.TDialog$* {*;}
  -keep class com.tencent.open.PKDialog
  -keep class com.tencent.open.PKDialog {*;}
  -keep class com.tencent.open.PKDialog$*
  -keep class com.tencent.open.PKDialog$* {*;}

  -keep class com.sina.** {*;}
  -dontwarn com.sina.**
  -keep class  com.alipay.share.sdk.** {
     *;
  }
  -keepnames class * implements android.os.Parcelable {
      public static final ** CREATOR;
  }

  -keep class com.linkedin.** { *; }
  -keepattributes Signature