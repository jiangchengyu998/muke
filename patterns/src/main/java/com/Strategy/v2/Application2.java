package com.Strategy.v2;

// 非运行时动态确定，在代码中指定使用哪种策略
public class Application2 {
    public static void main(String[] args) {
        //...
        EvictionStrategy evictionStrategy = new LruEvictionStrategy();
        UserCache userCache = new UserCache(evictionStrategy);
        //...
    }
}
