package com.offer.p3;

/**
 * 16. 数值的整数次方：
 * 实现函数double power(double base, int exponent), 求base的exponent次方。不得使用库函数，不用考虑大数问题。
 */
public class One {

    public static void main(String[] args) {
        System.out.println(power(-2, 23));
    }

    public static double power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = power(base, exponent >> 1);
        result *= result;

        if ((exponent&0x1) == 1) {
            result *= base;
        }
        return result;
    }
}
