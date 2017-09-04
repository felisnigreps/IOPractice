package com.IOcat;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by gxu on 2016/12/6.
 */
public class PipedStreamTest {
    public static void main(String[] args) throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        try {
            inputStream.connect(outputStream);
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        outputStream.write("wub lad dup dup".getBytes());
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int data = inputStream.read();
                        while (data != -1) {
                            System.out.print((char) data);
                            data = inputStream.read();
                        }
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            a.start();
            b.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
