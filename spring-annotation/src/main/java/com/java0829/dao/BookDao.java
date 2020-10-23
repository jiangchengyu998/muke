package com.java0829.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// id默认是类型首字母小写
@Repository
public class BookDao {
    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
