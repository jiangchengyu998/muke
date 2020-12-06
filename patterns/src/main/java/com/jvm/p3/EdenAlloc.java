package com.jvm.p3;

public class EdenAlloc {
    public static final int _1M = 1024 * 1024;
    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[ _1M / 4];

        allocation2 = new byte[4 * _1M];
        allocation3 = new byte[4 * _1M];
        allocation3 = null;
        allocation3 = new byte[4 * _1M];
    }

    /**
     * VM 参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        testAllocation();

    }
}
