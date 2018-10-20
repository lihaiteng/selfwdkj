package zztest.nettyudpdemo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import utils.log.LogUtil;

public class ClientHandler  extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        String response = datagramPacket.content().toString(CharsetUtil.UTF_8);
        if (response.startsWith("谚语查询结果: ")) {
            LogUtil.d("client","handler"+response);
            channelHandlerContext.close();
        }
        if (response.startsWith("这是一个推送: ")) {
            LogUtil.d("client","这是一个推送");
            channelHandlerContext.close();
        }
    }
}
