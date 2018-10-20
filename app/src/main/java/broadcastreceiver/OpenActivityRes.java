package broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import zztest.http.TestLearnRetrofitActivity;
import zztest.netty.TestUdpRemoteActivity;

public class OpenActivityRes extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("lhttest")) {
            Intent aintent = new Intent(context,TestLearnRetrofitActivity.class);
            context.startActivity(aintent);
        }
    }
}
