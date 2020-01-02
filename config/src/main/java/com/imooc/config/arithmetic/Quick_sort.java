package com.imooc.config.arithmetic;


/**
 * @ClassName Quick_sort
 * @Description: 快速排序实现
 * @Author jiangchengyu
 * @Date 2020/1/2
 * @Version V1.0
 **/
public class Quick_sort {

    public static void main(String[] args) {
        int[] a = {6, 11, 3, 9, 8,1,2,2,2,2,};
        quick_sort(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println(quick_find_i_c(a, 0, a.length - 1, 7));
    }

    // 快速排序，A是数组，n表示数组大小
    private static void quick_sort(int [] A, int n){
        quick_sort_c(A, 0, n-1);
    }
    // 快速排序递归函数，p,r是下标
    private static void quick_sort_c(int[] A, int p, int r) {
        System.out.println(p+"===="+r);
        if (p >= r) return;

        int q = partition(A, p, r);
        System.out.println(q);
        quick_sort_c(A, p, q-1);
        quick_sort_c(A, q + 1, r);
    }

    // 获取分区点
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j=p; j < r; j++){
            if (a[j] < pivot){
                swap(a,i, j);
                i++;
            }
        }
        swap(a,i, r);
        return i;
    }

    // 交换 i, j
    private static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 查找数组中 k 大的数字，p,r是下标
    private static int quick_find_i_c(int[] a, int p, int r, int k) {
        int q = partition(a, p, r );
        if (q + 1 == k){
            return a[q];
        }
        if (k > q + 1) {
            return quick_find_i_c(a, q + 1, r,k);
        } else {
            return quick_find_i_c(a, p, q - 1,k);
        }
    }
}
