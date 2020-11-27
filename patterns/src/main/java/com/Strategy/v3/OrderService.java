package com.Strategy.v3;


import java.util.concurrent.locks.ReentrantLock;

public class OrderService {
    // 策略的使用
    public double discount(Order order) {
        double discount = 0.0;
        OrderType type = order.getType();
        if (type.equals(OrderType.NORMAL)) { // 普通订单
            //...省略折扣计算算法代码
        } else if (type.equals(OrderType.GROUPON)) { // 团购订单
            //...省略折扣计算算法代码
        } else if (type.equals(OrderType.PROMOTION)) { // 促销订单
            //...省略折扣计算算法代码
        }
        return discount;
    }

    // 策略的使用
    public double discount1(Order order) {

        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();


        OrderType type = order.getType();
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type);
        return discountStrategy.calDiscount(order);
    }
}
