package com.imooc.config.arithmetic;

/**
 * 计数排序
 */
public class CountingSort {

//    public static void main(String[] args) {
//        int[] a = {6, 11, 3, 9, 8,1,2,2,2,2,};
//        countingSort(a, a.length);
//        System.out.println("========");
//        for (int i : a) {
//            System.out.println(i);
//        }
//        System.out.println("========");
//
//    }

    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    private static void countingSort(int[] a, int n) {
        if (n <= 1) return;
        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];

        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }
        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}