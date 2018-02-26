package com.infoshareacademy.jjdd3.env;

public class EnvironmentPrinter {
    private final IEnvironmentReader reader;

    public EnvironmentPrinter(IEnvironmentReader reader) {
        this.reader = reader;
    }

    public String print() {
        return "Current environment is " + this.reader.read();
    }
}
