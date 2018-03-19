package com.infoshareacademy.jvm;

import java.util.ArrayList;
import java.util.List;

class GCSample1 {

    public static void main(String[] args) {
        GCSample1.run(10);
        System.gc();
    }

    public static void run(int count) {
        // no references to any of the objects outside this method
        List<DemoObject> list = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            DemoObject o = new DemoObject("My demo object " + (i + 1));
            list.add(o);
        }
    }
}
