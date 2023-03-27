package com.zhe.jedis.demo.service;

import org.springframework.data.redis.core.script.DefaultRedisScript;
import redis.clients.jedis.Jedis;

public class RedisReentrantLock {

    private final Jedis jedis;

    private final String Key;

    public RedisReentrantLock(Jedis jedis, String key) {
        this.jedis = jedis;
        this.Key = key;
    }



}
