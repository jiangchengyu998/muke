package com.Strategy.v1;

public class Demo {
    public static void main(String[] args) {
        Strategy a = StrategyFactory.getStrategy("A");
        a.algorithmInterface();
        Strategy b = StrategyFactory.getStrategy("B");
        b.algorithmInterface();
    }
}
