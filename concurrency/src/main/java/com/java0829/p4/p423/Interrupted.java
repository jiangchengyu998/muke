package com.java0829.p4.p423;

import com.java0829.p4.SleepUtils;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepThread(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyThread(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread.interrupt() is " + sleepThread.isInterrupted());
        System.out.println("busyThread.interrupt() is " + busyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepThread implements Runnable {
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class BusyThread implements Runnable {
        public void run() {
            while (true) {
            }
        }
    }
}
