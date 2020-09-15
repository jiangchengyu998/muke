package com.Decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape shape = new BlueShapeDecorator(new RedShapeDecorator(new Circle()));
        shape.draw();
    }
}
