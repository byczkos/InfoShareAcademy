package com.infoshareacademy;

public class Calculator {

    public Integer add(Integer[] params) {
        Integer result = 0;
        for (int i = 0; i < params.length ; i++) {
            result += params[i];
        }
        return result;
    }
}
