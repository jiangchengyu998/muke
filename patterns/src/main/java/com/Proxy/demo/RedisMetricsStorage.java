package com.Proxy.demo;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.util.*;

public class RedisMetricsStorage implements MetricsStorage {
    //...省略属性和构造函数等...
    Jedis jedis = null;

    public RedisMetricsStorage() {
        this.jedis = new Jedis("localhost", 6379);

    }
    public RedisMetricsStorage(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        //...
        Gson gson = new Gson();
        long currentTimeMillis = System.currentTimeMillis();
        jedis.zadd(requestInfo.getApiName(), currentTimeMillis, gson.toJson(requestInfo));
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
        //...
        return new ArrayList<RequestInfo>();
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
        //...
        HashMap<String, List<RequestInfo>> stringListHashMap = new HashMap<>();
        // 从数据库中按照范围查询这些请求
        Set<String> registers = jedis.zrangeByScore("register", startTimestamp, endTimestamp);
        List<RequestInfo> requestInfos =new ArrayList<>();
        for (String register : registers) {
            RequestInfo requestInfo = JSON.parseObject(register, RequestInfo.class);
            requestInfos.add(requestInfo);
        }
        stringListHashMap.put("register", requestInfos);

        Set<String> logins = jedis.zrangeByScore("login", startTimestamp, endTimestamp);
        List<RequestInfo> requestInfoList =new ArrayList<>();
        for (String login : logins) {
            RequestInfo requestInfo = JSON.parseObject(login, RequestInfo.class);
            requestInfoList.add(requestInfo);
        }
        stringListHashMap.put("login", requestInfoList);

        return stringListHashMap;
    }
}
