package com.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicIntegerTest {
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
//        System.out.println(atomicInteger.getAndIncrement());
//        System.out.println(atomicInteger.get());
//        boolean b = atomicInteger.compareAndSet(2, 3);
//        System.out.println(b);
//        System.out.println(atomicInteger.get());

        User user = new User("张三", 12);
        atomicReference.set(user);
        User updateUser = new User("lisi", 18);
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get());
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getAge());

    }
}


class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}