package com.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
//            countDownLatch.countDown();

        }).start();

        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println(countDownLatch.getCount());

        System.out.println(3);
    }
}
