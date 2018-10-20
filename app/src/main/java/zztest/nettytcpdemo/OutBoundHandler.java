package zztest.nettytcpdemo;

import android.util.Log;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import utils.log.LogUtil;

/**
 * Created by user on 2016/10/27.
 */

public class OutBoundHandler extends ChannelOutboundHandlerAdapter {
    private static final String TAG = "OutBoundHandler";
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        Log.d(TAG, "write: " + ctx.name());
        LogUtil.d("2","服务器 OutBoundHandler");
        super.write(ctx, msg, promise);
    }
}
