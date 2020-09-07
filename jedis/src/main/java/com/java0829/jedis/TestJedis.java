package com.java0829.jedis;


import com.alibaba.fastjson.JSON;
import io.rebloom.client.Client;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestJedis {

    public static void main(String[] args) {
//        Client client = new Client("localhost", 6379);
//        client.add("simpleBloom", "Mark");

        Jedis jedis = new Jedis("localhost", 6379);
        // 从数据库中按照范围查询这些请求
        Set<String> registers = jedis.zrangeByScore("register", 1599486044913L, 1599486044956L);
        List<RequestInfo> requestInfos =new ArrayList<>();
        for (String register : registers) {
            RequestInfo requestInfo = JSON.parseObject(register, RequestInfo.class);
            System.out.println(requestInfo);
        }

    }

}
