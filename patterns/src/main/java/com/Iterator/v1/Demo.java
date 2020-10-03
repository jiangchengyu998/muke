package com.Iterator.v1;


import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");

        java.util.Iterator<String> iterator1 = names.iterator();
        Iterator<String> iterator = new ArrayIterator(names);
        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}

