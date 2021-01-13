package com.offer.p2;

public class Fourteen {

    public static void main(String[] args) {
//        System.out.println(numberOf(0x7fffffff));
//        System.out.println(numberOf(0x80000000));
//        System.out.println(numberOf(0xffffffff));
        System.out.println(numberOf(0x00000005));
        System.out.println(numberOf(0xfffffffb));

    }

    public static int numberOf(int n){
        System.out.println(n);
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
