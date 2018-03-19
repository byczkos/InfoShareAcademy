package com.infoshareacademy.jvm;

public class GCSample2 {

    public static void main(String[] args) {
        DemoObject o1 = new DemoObject("My demo object 1");
        DemoObject o2 = new DemoObject("My demo object 2");
        DemoObject o3 = new DemoObject("My demo object 3");

        o2 = o1;

        System.gc();
    }
}
