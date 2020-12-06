package com.concurrent;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {

    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    /**
     * 假设只有四个sheet，所以启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的银行流水结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(()->{

                // 计算当前sheet的银行流水数据，计算代码。。。
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                // 银行流水计算完成，插入一个屏障
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("单个完成");
            });

        }
        System.out.println("计算完成");
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet计算得出的结果
        for (Map.Entry<String, Integer> stringIntegerEntry : sheetBankWaterCount.entrySet()) {
            result += stringIntegerEntry.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);

    }


    public static void main(String[] args) {

        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

}
