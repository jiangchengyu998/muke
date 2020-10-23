package com.java0829.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public Car() {
        System.out.println("car.....Constructor......");
    }
    public void init(){
        System.out.println("car.....init");
    }
    public void destroy(){
        System.out.println("car.....destroy");
    }


}
