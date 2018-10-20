package netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import utils.log.LogUtil;
import zztest.nettyudpdemo.ServerHandler;

public class UdpServer {

    private static UdpServer INSTANCE;

    private final int port = 8765;

    private Bootstrap bootstrap;
    private EventLoopGroup group;

    private UdpServer() {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ServerHandler());
    }

    public static UdpServer getInstance() {
        if (INSTANCE == null) {
            synchronized (UdpServer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UdpServer();
                }
            }
        }
        return INSTANCE;
    }

    public void run(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    LogUtil.d("server","开启");
                    bootstrap.bind(port).sync().channel().closeFuture().await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onDestory(){
        LogUtil.d("server","开启");
    }
}
