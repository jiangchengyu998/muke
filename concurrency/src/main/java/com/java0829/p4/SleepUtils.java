package com.java0829.p4;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static void second(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
