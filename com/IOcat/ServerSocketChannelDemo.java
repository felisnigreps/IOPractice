package com.IOcat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by gxu on 2016/12/7.
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));
        //阻塞模式，可以设置为非阻塞模式serverSocketChannel.configureBlocking(false),如果没有检测到那么就accpet()立即返回空
        for (; ; ) {
            SocketChannel socketChannel = channel.accept();
            //do something with the socket channel
        }
    }
}
