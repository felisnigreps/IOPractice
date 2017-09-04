package com.IOcat;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by gxu on 2016/8/15.
 */
public class ShowAllFiles {
    public static void main(String args[]) {
        File f = new File("/Users/xugenli");
        String[] list = f.list(new NameFilter("txt"));
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        System.out.println(System.currentTimeMillis());
    }


   static class NameFilter implements FilenameFilter {
        String fn;

        public NameFilter(String fn) {
            this.fn = fn;
        }

        @Override
        public boolean accept(File dir, String name) {
            String filename = new File(name).getName();
            return filename.indexOf(fn) != -1;
        }
    }


}
