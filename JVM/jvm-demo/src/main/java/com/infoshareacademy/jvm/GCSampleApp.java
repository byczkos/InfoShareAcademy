package com.infoshareacademy.jvm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GCSampleApp {

    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("GCSampleThread");

        System.out.println("Press enter to start ...");
        System.in.read();
        System.out.println("Starting ...");

        List<Object> list = new ArrayList<>();

        for (int i = 0; i < 1000 ; i++) {
            for (int j = 0; j < 10000 ; j++) {
                list.add("Start");
            }
            list.clear();
        }

    }
}
