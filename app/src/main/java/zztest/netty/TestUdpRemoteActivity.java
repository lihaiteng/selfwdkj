package zztest.netty;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.turui.yuncheng.R;

import java.util.Calendar;

import broadcastreceiver.OpenActivityRes;
import netty.udp.IUdpAidlInterface;
import netty.udp.UdpRemoteService;
import utils.log.LogUtil;
import zztest.nettyudpdemo.Client;
import zztest.nettyudpdemo.UdpServerService;

public class TestUdpRemoteActivity extends Activity {

    private IUdpAidlInterface udpAidlInterface;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtil.d("ServiceConnection","ServiceConnection");
            udpAidlInterface = IUdpAidlInterface.Stub.asInterface(iBinder);
//            try {
//                udpAidlInterface.temp();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_udpremote_activity);
    }

    public void serverRun(View v){
        Intent intent = new Intent(this, UdpRemoteService.class);
        intent.setPackage("com.turui.yuncheng.netty.udp.UdpRemoteService");
        startService(intent);
        bindService(intent,serviceConnection, BIND_AUTO_CREATE);
        //unbindService(serviceConnection);

        //开启一个闹钟
//        setAlarm();
    }

    private void setAlarm(){
        //操作：发送一个广播，广播接收后Toast提示定时操作完成
//        Intent intent = new Intent(this, UdpRemoteService.class);
//        intent.setPackage("com.turui.yuncheng.netty.udp.UdpRemoteService");
//        PendingIntent sender=PendingIntent.getService(TestUdpRemoteActivity.this, 0, intent, 0);

        Intent intent = new Intent(this, OpenActivityRes.class);
        intent.setAction("lhttest");
//        sendBroadcast(intent);
        PendingIntent sender=PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

        //设定一个10秒后的时间
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 5);

        AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
        //或者以下面方式简化
        //alarm.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+5*1000, sender);
    }

    public void clientRun(View v){
        try {
            new Client().run(8865);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
