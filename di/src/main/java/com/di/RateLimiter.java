package com.di;


import redis.clients.jedis.Jedis;

public class RateLimiter {
    private RedisCounter redisCounter;
    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }
    public void test() {
        Jedis jedis = new Jedis(redisCounter.getIpAddress(), Integer.parseInt(redisCounter.getPort()));
        jedis.set("a", "ffff");
        System.out.println("Hello World!" + jedis.get("a"));
    }
    //...
}


