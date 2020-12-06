package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest3 {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception ignored) {
                }
            }
        });
        thread.start();
//        thread.interrupt();
        System.out.println(c.getNumberWaiting());

        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
        System.out.println(c.getNumberWaiting());
    }

}
