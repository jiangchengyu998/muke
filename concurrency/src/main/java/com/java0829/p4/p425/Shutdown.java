package com.java0829.p4.p425;

import java.util.concurrent.TimeUnit;

public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread counterThread = new Thread(one, "counterThread");
        counterThread.start();

        TimeUnit.SECONDS.sleep(1);
        counterThread.interrupt();
        Runner two = new Runner();
        counterThread = new Thread(two, "counterThread");
        counterThread.start();

        TimeUnit.SECONDS.sleep(1);
        two.cancel();

    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);

        }
        public void cancel(){
            on = false;
        }
    }

}
