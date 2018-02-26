package com.infoshareacademy.jjdd3.env;

public class EnvironmentReader implements IEnvironmentReader {
    @Override
    public String read() {
        return System.getenv("ENV");
    }
}
