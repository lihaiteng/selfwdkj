package zztest.nettytcpdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.turui.yuncheng.R;

import java.net.InetSocketAddress;

import utils.log.LogUtil;
import zztest.nettytcpdemo.NettyClient;
import zztest.nettytcpdemo.NettyServer;
import zztest.nettytcpdemo.Test;
import zztest.nettytcpdemo.business.OnReceiveListener;
import zztest.nettytcpdemo.business.OnServerConnectListener;
import zztest.nettytcpdemo.service.ServerService;

public class Netty1Activity extends AppCompatActivity {
    private EditText etTitle;
    private EditText etContent;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_nettytcp1_main);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etContent = (EditText) findViewById(R.id.etContent);
        tvRes = (TextView) findViewById(R.id.tvRes);
        Intent intent = new Intent(this, ServerService.class);
        startService(intent);

    }

    public void connect(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NettyClient.getInstance()
                        .connect(new InetSocketAddress("127.0.0.1", NettyServer.PORT_NUMBER), new OnServerConnectListener(){

                            @Override
                            public void onConnectSuccess() {

                            }

                            @Override
                            public void onConnectFailed() {

                            }
                        });
            }
        }).start();

    }

    public void send(View view) {
        Test.ProtoTest protoTest = Test.ProtoTest
                .newBuilder()
                .setId(1)
                .setTitle(etTitle.getText().toString())
                .setContent(etContent.getText().toString())
                .build();
        NettyClient.getInstance().send(protoTest, new OnReceiveListener() {
            @Override
            public void handleReceive(final Object msg) {
                LogUtil.d("send client");
                if (msg instanceof Test.ProtoTest) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            tvRes.setText("");
                            Test.ProtoTest test = (Test.ProtoTest) msg;
                            tvRes.setText(test.getId() + "\n" +
                                    test.getTitle() + "\n" +
                                    test.getContent());
                        }
                    });

                }
            }
        });
    }
}
