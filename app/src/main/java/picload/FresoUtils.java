package picload;

import android.content.Context;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import utils.DensityUtil;

/**
 * Created by 一脸灬邪气 on 2017/12/14 0014 2017/12/14 0014.
 * HDJY.setBug(null);
 */

public class FresoUtils {
    /**
     * 设置宽 适应屏幕
     * @param context
     * @param drawee
     * @param paddingValue
     * @return
     */
    public static SimpleDraweeView setWidth(Context context,SimpleDraweeView drawee,int paddingValue){
        int width = DensityUtil.getScreenWidth(context,paddingValue);
        ViewGroup.LayoutParams params = drawee.getLayoutParams();
        params.width = width;
        drawee.setLayoutParams(params);
        drawee.setAspectRatio(1.66f);
        //有 fresco:roundedCornerRadius="10dp"属性 才可以获取  hierarchy.getRoundingParams() 否则会报错
//        GenericDraweeHierarchy hierarchy = drawee.getHierarchy();
//        RoundingParams roundingParams = hierarchy.getRoundingParams();
//        roundingParams.setCornersRadius(10);
        return drawee;
    }

    /**
     * 设置宽高铺满屏幕
     * @param context
     * @param drawee
     * @return
     */
    public static SimpleDraweeView setMatchSreen(Context context,SimpleDraweeView drawee,int
            barHeightDp){
        int width = DensityUtil.getScreenWidth(context);
        int height = DensityUtil.getScreenHeight(context);
        ViewGroup.LayoutParams params = drawee.getLayoutParams();
        params.width = width;

        //状态栏高度
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height","dimen", "android");
        if(resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        params.height = height - result -DensityUtil.dip2px(context,barHeightDp);
        drawee.setLayoutParams(params);
        return drawee;
    }
}
