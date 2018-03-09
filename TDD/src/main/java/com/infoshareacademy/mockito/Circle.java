package com.infoshareacademy.mockito;

public class Circle {
    private Point center;
    private int r;

    public void printCircle() {
        System.out.println("Center: " + getCenterAsDescription());
        System.out.println("r: " + r);
    }

    public String getCenterAsDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(center.getX());
        stringBuilder.append(",");
        stringBuilder.append(center.getY());
        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    public Point getCenter() {
        return center;
    }

    public int getR() {
        return r;
    }
}
