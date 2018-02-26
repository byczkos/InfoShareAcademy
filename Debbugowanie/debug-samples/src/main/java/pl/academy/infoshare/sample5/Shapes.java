package pl.academy.infoshare.sample5;

public class Shapes {

    public static void main(String[] args) {
        Shape s1 = new Triangle();
        Shape s2 = new Circle();
        Shape s3 = new Circle();

        s1.draw();
        s2.draw();
        s3.draw();
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle drawing 2");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Triangle drawing");
    }
}