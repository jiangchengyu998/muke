package com.offer.p2;

public class Night {

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(9));
        System.out.println(fibonacci(10));
    }

    public static long fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        long fibNMinusOne = 0;
        long fibNMinusTwo = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusOne = fibNMinusTwo;
            fibNMinusTwo = fibN;
        }
        return fibN;
    }
}
