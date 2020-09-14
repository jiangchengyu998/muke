package com.Proxy.cglib;

import com.Proxy.demo.UserVo;

import java.util.Random;

public class UserController{

    public UserVo login(String telephone, String password) {
        // ... 省略login逻辑...
        System.out.println("login");
        Random random = new Random();
        try {
            Thread.sleep(100 * random.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //...返回UserVo数据...
        return new UserVo(telephone, password);
    }

    public UserVo register(String telephone, String password) {
        // ... 省略register逻辑...
        System.out.println("register");
        Random random = new Random();
        try {
            Thread.sleep(100 * random.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //...返回UserVo数据...
        return new UserVo(telephone, password);
    }
}