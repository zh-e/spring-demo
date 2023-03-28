package com.zhe.jedis.demo.service;


import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.Callable;

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

    public void withLockExec(String key, int expire, int acquireTimeout, Runnable runnable) throws IOException {
        RedisReentrantLock lock = new RedisReentrantLock(jedisPool, key);
        if (!lock.lock(expire, acquireTimeout)) {
            throw new RuntimeException(String.format("key: %s, 未争抢到锁", key));
        }
        try {
            runnable.run();
        } finally {
            lock.unlock();
        }
    }

    public <T>T withLockExec(String key, int expire, int acquireTimeout, Callable<T> callable) throws Exception {
        RedisReentrantLock lock = new RedisReentrantLock(jedisPool, key);
        if (!lock.lock(expire, acquireTimeout)) {
            throw new RuntimeException(String.format("key: %s, 未争抢到锁", key));
        }
        try {
            return callable.call();
        } finally {
            lock.unlock();
        }
    }

}
