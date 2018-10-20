package zztest.nettytcpdemo;

import android.util.Log;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utils.log.LogUtil;

/**
 * Created by user on 2016/10/27.
 */

public class InBoundHandler extends ChannelInboundHandlerAdapter {
    private static final String TAG = "InBoundHandler";
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Log.d(TAG, "channelRead: " + ctx.name());
        LogUtil.d("3","服务器 InBoundHandler");
        super.channelRead(ctx, msg);
    }
}
