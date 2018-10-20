package utils.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;

public class AlertDialogHelper {

    public static void showAlertDialog(Context c, String msg,
                                       DialogInterface.OnClickListener listenerPositive){
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setMessage(msg)
                .setPositiveButton("确定", listenerPositive);
        AlertDialog dialog = builder.create();
        dialog.show();
        ChangeDialogTextColorUtil.GetAlertDialogMsg(dialog, Color.BLACK);
    }

    public static void showAlertDialog(Context c,String msg,
                                       DialogInterface.OnClickListener listenerNegative,
                                       DialogInterface.OnClickListener listenerPositive){
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setMessage(msg)
                .setPositiveButton("确定", listenerPositive)
                .setNegativeButton("取消",listenerNegative);
        AlertDialog dialog = builder.create();
        dialog.show();
        ChangeDialogTextColorUtil.GetAlertDialogMsg(dialog, Color.BLACK);
    }

}
