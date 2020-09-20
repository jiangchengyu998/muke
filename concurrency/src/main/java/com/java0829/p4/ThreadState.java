package com.java0829.p4;

public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();

        // 一個获取锁成功，一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();

    }

    /**
     * 不断的进行休眠
     */
    static class TimeWaiting implements Runnable{

        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    /**
     * 该线程在waiting.class 实例上等待
     */
    static class Waiting implements Runnable {
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.fillInStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 获取锁之后不会释放锁
     */
    static class Blocked implements Runnable {

        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }
}
