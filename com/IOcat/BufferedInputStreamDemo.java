package com.IOcat;

import java.io.*;

/**
 * Created by gxu on 2016/12/6.
 */
public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        int sz = 99;
        try(InputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/xugenli/NIO.txt"), sz)){
            int a = inputStream.read();
            while (a!=-1){
                System.out.print((char)a);
                a = inputStream.read();
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }

}
