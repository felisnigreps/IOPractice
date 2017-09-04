package com.IOcat;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by gxu on 2016/12/6.
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/xugenli/NIO.txt","rw");
        //设置开始读取的指针
        file.seek(20);
        //获取指针
        long pointer = file.getFilePointer();
        System.out.println(pointer);
        //读取内容
        int a = file.read();
        while (a!=-1){
            System.out.print((char) a);
            a = file.read();
        }
        System.out.println(file.length());
        //指定位置写入
        file.seek(66);
        file.write("ssssssssssssssssssssssss".getBytes());
        file.close();

    }
}
