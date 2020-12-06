package com.offer.p2;

public class Two {
    public static int getDuplication(int[] arr, int length){

        if (arr.length <=0 ||length <=0 ) return -1;
        int start = 1;
        int end = length - 1;
        // 把数组分为两半
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(arr, length, start, middle);
            if (end == start) {
                if (count > 1)
                    return start;
                 else
                    break;
            }
            if (count > (middle - start +1))
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }

    private static int countRange(int[] arr, int length, int start, int end) {
        if (arr.length <= 0) return 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] >= start && arr[i] <=end)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,6,7};
        System.out.println(getDuplication(arr, 8));
    }
}
