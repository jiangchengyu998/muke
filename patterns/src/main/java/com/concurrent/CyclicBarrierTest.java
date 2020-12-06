package com.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()->{
        System.out.println("barrierAction");
    });

    public static void main(String[] args) {
        new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);

        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("调用一个await（）后：" + cyclicBarrier.getNumberWaiting());

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        System.out.println(cyclicBarrier.getNumberWaiting());
//        System.out.println(cyclicBarrier.getParties());

        System.out.println("调用二个await（）后：" + cyclicBarrier.getNumberWaiting());

        System.out.println(2);

    }
}
