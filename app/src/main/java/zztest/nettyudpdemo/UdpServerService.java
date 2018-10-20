package zztest.nettyudpdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class UdpServerService extends Service {

    private UdpServer service;

    //定义onBinder方法所返回的对象
    private MyBinder binder = new MyBinder();

    public class MyBinder extends Binder
    {
        public void send()
        {
            service.send();
        }
    }

    //必须实现的方法,绑定该Service时回调该方法
    @Override
    public IBinder onBind(Intent intent) {
        //Log.i(TAG, "onBind方法被调用!");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            service = UdpServer.getInstance();
            service.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
