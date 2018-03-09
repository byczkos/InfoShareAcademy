package com.infoshareacademy.mockito;

public class Car {
    Type type;

    public String generateName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type.getName());
        stringBuilder.append(" ");
        stringBuilder.append(type.getModel());

        return stringBuilder.toString();
    }
}
