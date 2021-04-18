package com.java0829;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 9, 7, 6, 1};

        insertionSort(arr, arr.length);

        for (int value : arr) {
            System.out.println(value);
        }
    }

    private static void insertionSort(int[] arr, int length) {
        if (length <= 1) return;
        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    private static void insertionSort2(int[] arr, int length) {
        if (length <= 1) return;
        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }
}
