package com.IOcat;

public class A {
    public static void main(String[] args) {
        ClassLoader a = A.class.getClassLoader();
        System.out.println(a);
        System.out.println(a.getParent());
        System.out.println(a.getParent().getParent());

    }


}
