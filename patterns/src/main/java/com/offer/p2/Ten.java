package com.offer.p2;

public class Ten {

    public static void main(String[] args) throws Exception {
        int[] ages = {5, 6, 7, 8, 9, 7, 7, 5, 3, 2,0, 1, 6, 6, 4, 2, 2, 4, 4, 6, 6, 6, 6, 6, 8, 7, 6, 1};
        sortAges(ages, ages.length);
        for (int anInt : ages) {
            System.out.println(anInt);
        }
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
