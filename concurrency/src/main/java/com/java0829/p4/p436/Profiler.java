package com.java0829.p4.p436;

import java.util.concurrent.TimeUnit;

public class Profiler {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<Long>(){
        protected long inn(){
            return System.currentTimeMillis();
        }
    };

    private static final void begin(){
        threadLocal.set(System.currentTimeMillis());

    }

    private static final long end(){
        return System.currentTimeMillis() - threadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Profiler.end());
    }
}
