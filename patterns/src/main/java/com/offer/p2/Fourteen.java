package com.offer.p2;

public class Fourteen {

    public static void main(String[] args) {
        System.out.println(numberOf(15<<24));

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
