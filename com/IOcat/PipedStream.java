package com.IOcat;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by gxu on 2016/12/6.
 */
public class PipedStream {
    public static void main(String[] args) {
        try (PipedOutputStream outputStream = new PipedOutputStream();
             PipedInputStream inputStream = new PipedInputStream(outputStream)) {
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        outputStream.write("wub lad dup dup".getBytes());
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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            a.start();
            b.start();
//            try {
//                b.join();
//                a.join();
//            } catch (InterruptedException ie) {
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
