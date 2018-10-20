package zztest.nettyudpdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;

import com.turui.yuncheng.R;

public class Netty2Activity extends Activity{

    private UdpServerService.MyBinder binder;

    ServiceConnection conn = new ServiceConnection() {
        public void onServiceConnected(ComponentName name, IBinder service) {
            //Log.e(TAG, "onServiceConnected");//绑定成功回调，这个IBinder对象即可实现与被绑定Service 之间的通信!
            binder = (UdpServerService.MyBinder) service;//这样就可以通过binder通信Service了
        }
        public void onServiceDisconnected(ComponentName name) {
            //Log.e(TAG, "onServiceDisconnected");
            //Android系统在同service的连接意外丢失时调用这个．比如当service崩溃了或被强杀了．当客户端解除绑定时，这个方法不会被调用．
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_nettyudp1_main);
    }

    public void serverRun(View v){
        Intent intent = new Intent(this, UdpServerService.class);
        startService(intent);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void clientRun(View v){
        try {
            new Client().run(8865);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ServiceSendToClient(View v){
        binder.send();
    }
}
