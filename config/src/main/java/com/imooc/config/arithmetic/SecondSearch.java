package com.imooc.config.arithmetic;

/**
 * @ClassName SecondSearch
 * @Description: 二分查找法的几个变种
 * @Author jiangchengyu
 * @Date 2020/1/6
 * @Version V1.0
 **/
public class SecondSearch {

//    public static void main(String[] args) {
//        int[] a = {2,3,4,6,6,6,7,7,7,7,7,8,9,10};
//        System.out.println(bsearch1(a, a.length, 7));
//        System.out.println(bsearch2(a, a.length, 7));
//        System.out.println(bsearch3(a, a.length, 2));
//        System.out.println(bsearch4(a, a.length, 7));
//    }

    /**
     * 查找第一个等于给定值得元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                if (a[mid-1]<value || (mid ==0)){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                if (a[mid+1]>value){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int bsearch3(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);   // 也就是中间值等于最小值加上最大值-最小值的差除以2
            if (a[mid] >= value) {
                if ((mid == 0) || a[mid-1] < value){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int bsearch4(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);   // 也就是中间值等于最小值加上最大值-最小值的差除以2
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((a[mid + 1] > value) || mid == n - 1) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
