package com.IOcat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by GXU on 2016/12/23.
 */
public class BufferDemo1 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("/Users/xugenli/NIO.txt","rw");
            FileChannel channel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(4);
            //这个方法会沿着管道读取数据 返回值为读取的字节的数目 如果返回-1的话代表读取完毕 没数据可读，依旧调用读的时候返回为0
            int readByte = channel.read(byteBuffer);
            //int a = channel.read(byteBuffer);

            System.out.println(readByte);
            //System.out.println(a);
            //如果没有读取结束
            while(readByte!=-1){
                //反转 buffer 切换到写模式
                byteBuffer.flip();
                //取得数据 输出
                while (byteBuffer.hasRemaining()){
                    System.out.print((char)byteBuffer.get());
                }
                //重新读
                byteBuffer.clear();
                readByte = channel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            file.close();
        }
    }
}
