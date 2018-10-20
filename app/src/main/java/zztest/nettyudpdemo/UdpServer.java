package zztest.nettyudpdemo;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import utils.log.LogUtil;
import zztest.nettytcpdemo.NettyServer;

public class UdpServer {

    private static UdpServer INSTANCE;

    public final int port = 8765;

    private UdpServer() {
    }

    public static UdpServer getInstance() {
        if (INSTANCE == null) {
            synchronized (NettyServer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UdpServer();
                }
            }
        }
        return INSTANCE;
    }

    private Bootstrap b;
    public void run() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(b==null){
                        LogUtil.d("server","开启");
                        EventLoopGroup group = new NioEventLoopGroup();
                        try {
                            b = new Bootstrap();
                            b.group(group).channel(NioDatagramChannel.class)  // UDP: NioDatagramChannel
                                    .option(ChannelOption.SO_BROADCAST, true) // 广播
                                    .handler(new ServerHandler());
                            b.bind(port).sync().channel().closeFuture().await();
                        } finally {
                            group.shutdownGracefully();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void send(){
        Channel ch = b.bind(port).channel();
        ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("这是一个推送", CharsetUtil.UTF_8), new InetSocketAddress("127.0.0.1", 8865)));
    }
}
