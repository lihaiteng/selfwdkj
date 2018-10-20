package zztest.nettytcpdemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import utils.log.LogUtil;

/**
 * Created by user on 2016/10/27.
 */

public class NettyServer {
    private ServerBootstrap mServerBootstrap;
    private EventLoopGroup mWorkerGroup;
    private ChannelFuture channelFuture;
    private boolean isInit;

    private static NettyServer INSTANCE;

    public final static int PORT_NUMBER = 8888;

    private NettyServer() {
    }

    public static NettyServer getInstance() {
        if (INSTANCE == null) {
            synchronized (NettyServer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NettyServer();
                }
            }
        }
        return INSTANCE;
    }

    public void init() {
        if (isInit) {
            return;
        }
        //创建worker线程池，这里只创建了一个线程池，使用的是netty的多线程模型
        mWorkerGroup = new NioEventLoopGroup();
        //服务端启动引导类，负责配置服务端信息
        mServerBootstrap = new ServerBootstrap();
        mServerBootstrap.group(mWorkerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                        LogUtil.d("1","服务器 初始化 handler");
                        ChannelPipeline pipeline = nioServerSocketChannel.pipeline();
                        pipeline.addLast("ServerSocketChannel out", new OutBoundHandler());
                        pipeline.addLast("ServerSocketChannel in", new InBoundHandler());
                    }
                })
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        LogUtil.d("4","服务器 childHandler");
                        //为连接上来的客户端设置pipeline
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast("decoder", new ProtobufDecoder(Test.ProtoTest.getDefaultInstance()));
                        pipeline.addLast("encoder", new ProtobufEncoder());
                        pipeline.addLast("out1", new OutBoundHandler());
                        pipeline.addLast("out2", new OutBoundHandler());
                        pipeline.addLast("in1", new InBoundHandler());
                        pipeline.addLast("in2", new InBoundHandler());
                        pipeline.addLast("handler", new ServerChannelHandler());
                    }
                });

        channelFuture = mServerBootstrap.bind(PORT_NUMBER);
        isInit = true;
    }

    public void shutDown() {
        LogUtil.d("connect service shutDown");
        if (channelFuture != null && channelFuture.isSuccess()) {
            isInit = false;
            channelFuture.channel().closeFuture();
            mWorkerGroup.shutdownGracefully();
        }
    }
}
