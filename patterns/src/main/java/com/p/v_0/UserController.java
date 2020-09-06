package com.p.v_0;


import com.p.v_1.UserVo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//应用场景：统计下面两个接口(注册和登录）的响应时间和访问次数
public class UserController {

    private Metrics metrics = new Metrics();

    public UserController(Metrics metrics) {
        this.metrics = metrics;
        metrics.startRepeatedReport(10, TimeUnit.SECONDS);
    }

    public void register(UserVo user) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("register", startTimestamp);
        //...
        Random random = new Random();
        try {
            Thread.sleep(100 * random.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register", respTime);
    }

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        //...
        Random random = new Random();
        try {
            Thread.sleep(100 * random.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login", respTime);
        return new UserVo();
    }
}