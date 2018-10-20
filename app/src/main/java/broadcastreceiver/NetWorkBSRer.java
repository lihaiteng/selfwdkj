package broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by liht on 2018/5/15 0015.
 */

public class NetWorkBSRer extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")){
            //移动数据连接上时
            if (gprs.isConnected()){
                Toast.makeText(context,"正在使用数据流量", Toast.LENGTH_SHORT).show();
            }else if (wifi.isConnected()) {//wifi连接上时
                Toast.makeText(context,"Wifi已连接", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context,"没有网络", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
