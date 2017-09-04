package com.IOcat;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by gxu on 2016/12/7.
 */
public class FileTransform {
    public static void main(String[] args) throws IOException {
        RandomAccessFile a = new RandomAccessFile("/Users/xugenli/NIO.txt","rw");
        RandomAccessFile b = new RandomAccessFile("/Users/xugenli/NIO_01.txt","rw");
        FileChannel from = a.getChannel();
        FileChannel to = b.getChannel();
        //从另一个channel中读取数据
        to.transferFrom(from,0,from.size());
        //反过来
        from.transferTo(0,to.size(),to);
    }
}
