package com.concurrent.p5;

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
