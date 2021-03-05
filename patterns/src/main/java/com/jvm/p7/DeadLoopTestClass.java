package com.jvm.p7;

public class DeadLoopTestClass {
    static class DeadLoopClass{
        static {
            if (true) {
                System.out.println(Thread.currentThread() + "innit DeadLoopClass!");
                while (true) {

                }
            }

        }
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + "start");
            DeadLoopClass deadLoopClass = new DeadLoopClass();
            System.out.println(Thread.currentThread() + "end");
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

    }
}
