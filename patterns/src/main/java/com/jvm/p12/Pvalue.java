package com.jvm.p12;

public class Pvalue {
    private int value = 1;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Pvalue pvalue = new Pvalue();
        Thread thread = new Thread(() -> {
            pvalue.setValue(2);
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(pvalue.getValue());
        });
        thread.start();
        thread2.start();
    }
}
