package com.zhe.jedis.demo.service;


import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource
    private JedisPool jedisPool;

    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }

    public boolean set(String key, String value, int expire) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.set(key, value, SetParams.setParams().ex(expire)).equals("OK");
        }
    }


}
