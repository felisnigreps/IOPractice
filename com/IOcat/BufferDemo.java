package com.IOcat;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by gxu on 2016/12/7.
 */
public class BufferDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/xugenli/NIO.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer front = ByteBuffer.allocate(24);
        ByteBuffer end = ByteBuffer.allocate(48);
        ByteBuffer[] s = {front,end};
        //下面方法都是按照buffer在数组中的顺序进行读写
        //scatter 分散，主语是channel. channel写数据到多个buffer中
        channel.read(s);
        //gather 聚集，主语是channel. channel从多个buffer中读取数据
        channel.write(s);
    }
}
