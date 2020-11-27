package com.pool;

import java.util.concurrent.*;

public class ThreadPoolManager {

    private ThreadPoolExecutor threadPoolExecutor;
    private static volatile ThreadPoolManager instance;

    private ThreadPoolManager() {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(3);
        threadPoolExecutor = new ThreadPoolExecutor(1, 10, 10, TimeUnit.HOURS, arrayBlockingQueue, new MyThreadFactory() ,new MyRejectedExecutionHandler());
    }

    public static ThreadPoolManager getInstance(){
        if (instance == null) {
            synchronized (ThreadPoolManager.class) {
                if (instance == null) {
                    instance = new ThreadPoolManager();
                }
            }
        }
        return instance;
    }

    public void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    public void shutdown() {
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            ThreadPoolManager.getInstance().execute(()->{

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

        ThreadPoolManager.getInstance().shutdown();

    }

}

class MyRejectedExecutionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("线程名称：" + new Thread(r).getName());

        System.out.println("活跃线程数：" + executor.getActiveCount());
    }
}


class MyThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("d");
        return thread;
    }
}