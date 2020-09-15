package com.Decorator;

public class BlueShapeDecorator implements Shape {

    private Shape shape;
    public BlueShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        System.out.println("Blue!");
        shape.draw();
        System.out.println("end Blue!");

    }
}
