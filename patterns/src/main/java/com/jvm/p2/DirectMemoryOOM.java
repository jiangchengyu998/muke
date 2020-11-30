package com.jvm.p2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {
    public static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe)declaredField.get(null);
        while (true) {
            unsafe.allocateMemory(_1M);
        }
    }
}
