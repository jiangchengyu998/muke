package com.imooc.config.arithmetic;


/**
 * @ClassName Quick_sort
 * @Description: 快速排序实现
 * 快排的思想是这样的：
 * 如果要排序数组中下标从p到r之间的一组数据我们选择p到r之间的任意一个数据作为pivot（区分点）
 * 我们遍历p到r之间的数据，将小于pivot的放到左边，大于pivot的放到右边，将pivot放到中间。
 * 经过这一步骤之后，数组p到r之间的数据就分为三个部分，前面的p到q-1之间都是小于pivot的，中间是pivot，后面的q+1到r之间是大于pivot的.
 * 根据分治、递归的处理思想，我们可以用递归排序从下标p到q-1之间的数据和q+1到r之间的数据，直到区间缩小为1，就说明所有的数据都是有序的了。
 * 是一个不稳定的算法（排序之后相同的数会改变位置）
 * @Author jiangchengyu
 * @Date 2020/1/2
 * @Version V1.0
 **/
public class Quick_sort {

    public static void main(String[] args) {
        int[] a = {6, 11, 3, 9, 8,1,2,2,2,2};
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
//        System.out.println(p+"===="+r);
        if (p >= r) return;

        int q = partition(A, p, r);
//        System.out.println(q);
        quick_sort_c(A, p, q-1);
        quick_sort_c(A, q + 1, r);
    }

    // 获取分区点
    /**
     * 这里的处理有点类似选择排序，我们通过游标i把a[p...r-1]分成两部分。
     * a[p...i-1]的元素都是小于pivot的，我们暂时叫他“已处理区间”，a[i...r-1]是未处理区间。
     * 我们每次都从未处理的区间a[i...r-1]中去一个元素a[j],与pivot对比，，如果小于pivot，则将其加入到已处理区间的尾部，也就是a[i].
     * 只需要将a[i]与a[j]交换，就可以在O(1)的时间复杂度内将a[j]放到下标为i的位置。
     * @param a 数组
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p; // i 的位置就是大于pivot值得位置，j是每个元素的位置
        // 遍历每一个数据
        for (int j=p; j < r; j++){
            // 如果a[j]小于区分点的值, 就把区分点和a[j]互换位置
            if (a[j] < pivot){
                swap(a, i, j);
                i++;
            }
        }
        // 最后i就是区分点的下标。
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
