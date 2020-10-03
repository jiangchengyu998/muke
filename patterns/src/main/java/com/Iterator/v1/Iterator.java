package com.Iterator.v1;


// 接口定义方式一
public interface Iterator<E> {
    boolean hasNext();
    void next();
    E currentItem();
}
