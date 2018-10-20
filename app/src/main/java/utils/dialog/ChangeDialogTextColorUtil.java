package utils.dialog;

import android.app.AlertDialog;
import android.widget.TextView;

import java.lang.reflect.Field;

public class ChangeDialogTextColorUtil {

    /**
     * dialog的各部分文字颜色设置文字
     * @param dialog
     * @param titleColor
     * @param msgColor
     * @param positiveColor
     * @param nagetiveColor
     * @return
     */
    public static AlertDialog GetAlertDialog(AlertDialog dialog, int titleColor, int msgColor, int
            positiveColor, int nagetiveColor){
        try {
            Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
            mAlert.setAccessible(true);
            Object mAlertController = mAlert.get(dialog);
            if(titleColor!=-1){
                Field mTitle = mAlertController.getClass().getDeclaredField("mTitleView");
                mTitle.setAccessible(true);
                TextView mTitleView = (TextView)mTitle.get(mAlertController);
                mTitleView.setTextColor(titleColor);
            }
            if(msgColor!=-1){
                Field mMessage = mAlertController.getClass().getDeclaredField("mMessageView");
                mMessage.setAccessible(true);
                TextView mMessageView = (TextView) mMessage.get(mAlertController);
                mMessageView.setTextColor(msgColor);
            }
            if(positiveColor!=-1){
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(positiveColor);
            }
            if(nagetiveColor!=-1){
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(nagetiveColor);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }finally {
            return dialog;
        }
    }

    public static AlertDialog GetAlertDialogTitleMsg(AlertDialog dialog, int titleColor,int
            msgColor){
        return GetAlertDialog(dialog,titleColor,msgColor,-1,-1);
    }

    public static AlertDialog GetAlertDialogTitle(AlertDialog dialog, int titleColor){
        return GetAlertDialog(dialog,titleColor,-1,-1,-1);
    }

    public static AlertDialog GetAlertDialogMsg(AlertDialog dialog, int msgColor){
        return GetAlertDialog(dialog,-1,msgColor,-1,-1);
    }

}
