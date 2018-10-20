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

public class Client {
    public void run(int port) throws Exception {
        LogUtil.d("client","开启");
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ClientHandler());
            Channel ch = b.bind(port).sync().channel();
            // 向网段内的所有机器广播UDP消息
            ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语字典查询?", CharsetUtil.UTF_8), new InetSocketAddress("127.0.0.1", 8765))).sync();
            if (!ch.closeFuture().await(15000)) {
                LogUtil.d("client","超时");
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}
