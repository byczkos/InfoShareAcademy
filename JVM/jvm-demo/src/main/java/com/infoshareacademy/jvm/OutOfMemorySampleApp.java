package com.infoshareacademy.jvm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemorySampleApp {

    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("OutOfMemoryThread");

        System.out.println("Press enter to start ...");
        System.in.read();
        System.out.println("Starting ...");

        List<Object> list = new ArrayList<>();
        int i =0;

        while(true) {
            list.add(new Object());
            if(i % 10000 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
