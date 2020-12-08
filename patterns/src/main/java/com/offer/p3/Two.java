package com.offer.p3;

/**
 * 17.打印从1到最大的n位数：
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数999
 */
public class Two {

    public static void main(String[] args) {
//        printMaxOfN_1(10);
//        printToMaxOfN_2(2);
        printToMaxOfN_3(8);
    }

    public static void printMaxOfN_1(int n) {
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }
        for (int j = 1; j < number; j++) {
            System.out.println(j);

        }
    }

    public static void printToMaxOfN_3(int n) {
        if (n < 0) return;
        int[] numbers = new int[n];
        for (int i = 0; i < 10; i++) {
            numbers[0] = i;
            printToMaxOfNDigitsRecursively(numbers, n, 0);
        }
    }

    private static void printToMaxOfNDigitsRecursively(int[] numbers, int n, int index) {
        if (index == n - 1) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index + 1] = i;
            printToMaxOfNDigitsRecursively(numbers, n, index + 1);
        }
    }

    public static void printToMaxOfN_2(int n) {
        if (n <= 0) return;
        int[] numbers = new int[n];
        while (!increment(numbers)) {
            printNumber(numbers);
        }
    }

    private static boolean increment(int[] numbers) {
        boolean isOverflow = false;  // 是否退出循环
        int takeOver = 0; // 表示进位
        for (int i = numbers.length - 1; i >= 0; i--) {
            int sum = numbers[i] + takeOver;
            // 第一次进入这个循环的时候加一
            if (i == numbers.length - 1) {
                sum++;
            }
            if (sum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    // 进1
                    sum -= 10;
                    takeOver = 1;
                    numbers[i] = sum;
                }
            } else {
                numbers[i] = sum;
                break;
            }
        }
        return isOverflow;
    }

    public static void printNumber(int[] number) {   //该方法是负责打印一个正类，千万不要尝试将数组变成一个整数
        boolean isBeginning = true;
        for (int value : number) {
            // 从左到右，找到第一个不等于0的才打印
            if (isBeginning && value != 0)
                isBeginning = false;
            if (!isBeginning) {
                System.out.print(value);
            }
        }
        System.out.println();

    }

}
