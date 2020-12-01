package com.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        System.out.println(s.availablePermits());


        for (int i = 0; i< THREAD_COUNT; i++) {
            threadPool.execute(() -> {
                try {
                    s.acquire();
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("save data");
                    System.out.println(s.availablePermits());
                    s.release();
                } catch (InterruptedException e) {
                }
            });
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最后可以使用的信号量："+s.availablePermits());

        threadPool.shutdown();
    }
}

