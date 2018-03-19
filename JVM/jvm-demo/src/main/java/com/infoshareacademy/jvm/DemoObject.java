package com.infoshareacademy.jvm;

public class DemoObject {

    private final String name;

    public DemoObject(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage Collected - " + name);
    }
}
