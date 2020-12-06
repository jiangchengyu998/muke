package com.offer.p2;

/**
 * 找出数组中重复的数字
 */
public class One {
    public static int duplication(int [] arr, int n){
        if (n<0) return -1;
        for (int i : arr) {
            if (i >= n) return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) return arr[i];
                else swap(arr, i, arr[i]);
            }
        }
        return -1;
    }
    private static void swap(int[] a, int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,1,0,2,5,6};
        System.out.println(duplication(arr, 7));

    }
}
