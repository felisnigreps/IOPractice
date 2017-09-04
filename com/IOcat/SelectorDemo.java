package com.IOcat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by gxu on 2016/12/7.
 */
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        //创建一个none block channel
        SocketChannel c = SocketChannel.open();

        //创建一个selector
        Selector selector = Selector.open();

        //设置channel为非阻塞模式
        c.configureBlocking(false);

        //注册 channel的监听事件,返回一个selectionKey
        //这个方法的第二个参数是一个interest集合，代表的意思是selector对channel的什么动作感兴趣
        //Interest集合
        //SelectionKey.OP_READ :读就绪
        //electionKey.OP_ACCEPT :接收就绪
        //SelectionKey.OP_WRITE :写就绪
        //SelectionKey.OP_CONNECT :连接就绪
        SelectionKey key = c.register(selector, SelectionKey.OP_CONNECT);

        //selectionKey中还包含其他的集合
        //使用下面方法和可判断是否包含其中内容
        //其余三个一样办法
        int interestInfo = key.interestOps();
        boolean isRead = (interestInfo & SelectionKey.OP_READ) == SelectionKey.OP_READ;
        // System.out.println(isRead);
        //Ready集合是通道准备就绪时的集合，可以用以下方式访问集合，进行验证
        int readyOps = key.readyOps();
        key.isAcceptable();
        key.isConnectable();
        key.isWritable();
        key.isReadable();
        //通过selectionKey来访问Selector和Channel十分简单

        Channel channel = key.channel();
        Selector selector1 = key.selector();
        //我们也可以给selectionKey添加相关对象，比如说和Channel一起使用的buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        //一次只能添加一个对象，添加第二个对象时丢弃第一个对象.也可以改变register的参数在第一次添加的时候注册对象。
        key.attach(byteBuffer);
        //通过以下方法来获得添加的对象
        ByteBuffer cache = (ByteBuffer) key.attachment();

        //通过select方法来返回自从上次检查后有多少个对象就绪了select会阻塞(wakeup方法可以唤醒)，selectNow直接返回
        System.out.println(selector.selectNow());
        selector.close();
    }
}
