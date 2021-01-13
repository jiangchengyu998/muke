package com.offer.p2;

public class Ten {

//    public static void main(String[] args) throws Exception {
//        int[] ages = {5, 6, 7, 8, 9, 7, 7, 5, 3, 2,0, 1, 6, 6, 4, 2, 2, 4, 4, 6, 6, 6, 6, 6, 8, 7, 6, 1};
//        sortAges(ages, ages.length);
//        for (int anInt : ages) {
//            System.out.println(anInt);
//        }
//    }

    public static void main(String[] args) {
//        int[] a = {1,0,1,1,1};
//        int[] a = {1,1,1,0,1};
        int[] a = {3,4,5,0,1,2};
        int min = min(a, a.length);
        System.out.println(min);
    }

    public static int min(int[] numbers, int length){
        if (numbers == null || length<=0) return -1;
        int index1 = 0;
        int index2 = length - 1;
        int indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;

            if (numbers[index1] == numbers[index2] && numbers[index1] == numbers[indexMid]) {
                return minInOrder(numbers, index1, index2);
            }

            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }

    public static int minInOrder(int[] numbers, int index1, int index2){
        int result = numbers[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            // 説明是第二个数组的
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }

    public static void sortAges(int[] ages, int length) throws Exception {
        if (ages == null || length <= 0) return;
        final int oldAges = 9;
        int[] timesOfAge = new int[oldAges + 1];

        for (int age : ages) {
            if (age < 0 || age > oldAges) throw new Exception("age out of range");
            ++timesOfAge[age];
        }

        int index = 0;
        for (int i = 0; i <= oldAges; i++) {
            // 这段代码的作用就是说，年是i的有多少个人
            for (int j = 0; j < timesOfAge[i]; j++) {
                // 每个i就是一个年龄值，在这里面的值都是一样的，年龄相同
                ages[index] = i;
                index++;
            }
        }

    }

}
