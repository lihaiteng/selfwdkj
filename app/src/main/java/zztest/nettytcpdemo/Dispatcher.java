package zztest.nettytcpdemo;

import android.support.v4.util.ArrayMap;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import utils.log.LogUtil;
import zztest.nettytcpdemo.business.OnReceiveListener;

/**
 * Created by user on 2016/10/27.
 */

public class Dispatcher extends SimpleChannelInboundHandler<Test.ProtoTest> {
    private ArrayMap<Integer, OnReceiveListener> receiveListenerHolder;

    public Dispatcher() {
        receiveListenerHolder = new ArrayMap<>();
    }

    public void holdListener(Test.ProtoTest test, OnReceiveListener onReceiveListener) {
        LogUtil.d("2","客户端 Dispatcher  send 设置 发送消息所对应的接受时的回调");
        receiveListenerHolder.put(test.getId(), onReceiveListener);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Test.ProtoTest protoTest) throws Exception {
        LogUtil.d("3","客户端 Dispatcher 业务处理 handler");
        if (receiveListenerHolder.containsKey(protoTest.getId())) {
            OnReceiveListener listener = receiveListenerHolder.remove(protoTest.getId());
            if (listener != null) {
                listener.handleReceive(protoTest);
            }
        }
    }
}
