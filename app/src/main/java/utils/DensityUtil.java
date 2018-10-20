package utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import utils.log.LogUtil;

public class DensityUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        LogUtil.d("scale",scale+"");
        LogUtil.d("value",pxValue / scale + 0.5f+"");
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取手机宽度px
     */
    public static int getScreenWidth(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        return w_screen;
    }

    /**
     * 获取手机宽度px，减去两边的padding dp 值
     */
    public static int getScreenWidth(Context context,int paddingDp){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int paddingPx = dip2px(context,paddingDp * 2);
        return w_screen - paddingPx;
    }

    /**
     * 获取手机高度px
     */
    public static int getScreenHeight(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int h_screen = dm.heightPixels;
        return h_screen;
    }

    /**
     * 获取全屏宽和高
     */
    public static int[] getWindowWidthHeight(Activity activity){
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        int screenWidthDip = dm.widthPixels; // 屏幕宽（dip，如：320dip）
        int screenHeightDip = dm.heightPixels; // 屏幕宽（dip，如：533dip）
        int screenWidth = (int)(screenWidthDip * density + 0.5f); // 屏幕宽（px，如：720px）
        int screenHeight = (int)(screenHeightDip * density + 0.5f); // 屏幕高（px，如：1280px）
        return new int[]{screenWidth,screenHeight};
    }
}
