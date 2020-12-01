package com.concurrent;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            try {
                String A = "银行流水A";  //
                String B = exgr.exchange(A);
                System.out.println("111A和B的数据是否一致" + A.equals(B) + ";A的数据："
                        + A + ";B的数据：" + B);
            } catch (InterruptedException e) {
            }
        });
        threadPool.execute(() -> {
            try {
                String B = "银行流水B";

                TimeUnit.SECONDS.sleep(2);
                String A = exgr.exchange("B");

                System.out.println("222A和B的数据是否一致" + A.equals(B) + ";A的数据："
                        + A + ";B的数据：" + B);
            } catch (InterruptedException e) {
            }
        });
        threadPool.shutdown();
    }
}
