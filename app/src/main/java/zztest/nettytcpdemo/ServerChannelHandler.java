package zztest.nettytcpdemo;

import android.util.Log;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import utils.log.LogUtil;

/**
 * Created by user on 2016/10/27.
 */

public class ServerChannelHandler extends SimpleChannelInboundHandler<Test.ProtoTest> {
    private static final String TAG = "ServerChannelHandler";
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Test.ProtoTest protoTest) throws Exception {
        Log.d(TAG, "channelRead0: " + channelHandlerContext.name());
        LogUtil.d("5","服务器 业务处理 ServerChannelHandler");
        Test.ProtoTest res = Test.ProtoTest.newBuilder()
                .setId(protoTest.getId())
                .setTitle("res" + protoTest.getTitle())
                .setContent("res" + protoTest.getContent())
                .build();
        channelHandlerContext.writeAndFlush(res);
    }
}
