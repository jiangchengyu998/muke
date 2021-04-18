package com.java0829;

/**
 * 冒泡排序算法
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 9, 7, 6, 1};

        bubbleSort(arr, arr.length);

        for (int value : arr) {
            System.out.println(value);
        }
    }

    /**
     * 循环n次，每次把最大的位放到最后面就完成了。
     *
     * @param arr
     * @param length
     */
    private static void bubbleSort(int[] arr, int length) {
        if (length <=1) return;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

    }

}
