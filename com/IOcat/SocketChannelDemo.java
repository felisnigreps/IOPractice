package com.IOcat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by gxu on 2016/12/7.
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        //创建并打开channel
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("http://jenkov.com", 80));
        //写数据到buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int a = channel.read(byteBuffer);
        while (a != -1) {
            System.out.print(a);
            a = channel.read(byteBuffer);
        }
        channel.close();
    }
}
