package com.Decorator;

/**
 * 圆形
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I am Circle!");
    }
}
