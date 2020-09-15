package com.Decorator;

public class RedShapeDecorator implements Shape {

    private Shape shape;
    public RedShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        System.out.println("red!");
        shape.draw();
        System.out.println("end red!");

    }
}
