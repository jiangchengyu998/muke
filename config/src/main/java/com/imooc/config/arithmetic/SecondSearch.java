package com.imooc.config.arithmetic;

/**
 * @ClassName SecondSearch
 * @Description: TODO
 * @Author jiangchengyu
 * @Date 2020/1/6
 * @Version V1.0
 **/
public class SecondSearch {

//    public static void main(String[] args) {
//        int[] a = {2,3,4,6,6,6,7,7,7,7,7,8,9,10};
//        System.out.println(bsearch(a, a.length, 7));
//    }

    private static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                if (a[mid-1]<value){
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

}
