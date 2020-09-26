package com.Strategy.v1;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void  algorithmInterface() {
        //具体的算法...
        System.out.println("算法A");
    }
}
