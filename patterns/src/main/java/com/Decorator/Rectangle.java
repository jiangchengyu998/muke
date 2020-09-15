package com.Decorator;

/**
 * 矩形
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("I am Rectangle!");
    }
}
