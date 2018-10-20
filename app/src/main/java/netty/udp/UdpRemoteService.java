package netty.udp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class UdpRemoteService extends Service {

     private IUdpAidlInterface.Stub mBinder = new IUdpAidlInterface.Stub() {
         @Override
         public void temp() throws RemoteException {
             UdpServer.getInstance().run();
         }
     };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        UdpServer.getInstance().run();
//        Toast.makeText(this,"aaaaaa",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        UdpServer.getInstance().onDestory();
    }
}
