package com.zhe.jedis.demo.service;

import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class RedisReentrantLock {

    private final JedisPool jedisPool;

    private final String Key;

    private static String LOCK_SCRIPT_SHA;

    private static String UNLOCK_SCRIPT_SHA;

    public RedisReentrantLock(JedisPool jedisPool, String key) {
        this.jedisPool = jedisPool;
        this.Key = key;
    }

    public boolean lock(int lockExpiryTime, int acquireTimeout) throws IOException {
        if (!StringUtils.hasLength(LOCK_SCRIPT_SHA)) {
            loadLockScript();
        }
        String threadId = String.valueOf(Thread.currentThread().getId());
        try (Jedis jedis = jedisPool.getResource()) {
            long end = System.currentTimeMillis() + acquireTimeout * 1000L;
            while (System.currentTimeMillis() < end) {
                Object obj = jedis.evalsha(LOCK_SCRIPT_SHA, Collections.singletonList(Key), Arrays.asList(threadId, String.valueOf(lockExpiryTime * 1000L)));
                if (obj == null) {
                    return true;
                }
            }
            return false;
        }
    }

    public void unlock() throws IOException {
        if (!StringUtils.hasLength(UNLOCK_SCRIPT_SHA)) {
            loadUnlockScript();
        }
        String threadId = String.valueOf(Thread.currentThread().getId());
        try (Jedis jedis = jedisPool.getResource()) {
            Object obj = jedis.evalsha(UNLOCK_SCRIPT_SHA, Collections.singletonList(Key), Collections.singletonList(threadId));
            if (obj == null) {
                jedis.del(Key);
            }
        }
    }

    public void loadLockScript() throws IOException {
        try (InputStream is = getClass().getResourceAsStream("/lua/redis-reentrant-lock.lua")) {
            if (is == null) {
                throw new RuntimeException("文件不存在");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String script = reader.lines().collect(Collectors.joining(System.lineSeparator()));
                try (Jedis jedis = jedisPool.getResource()) {
                    LOCK_SCRIPT_SHA = jedis.scriptLoad(script);
                }
            }
        }
    }

    public void loadUnlockScript() throws IOException {
        try (InputStream is = getClass().getResourceAsStream("/lua/redis-reentrant-unlock.lua")) {
            if (is == null) {
                throw new RuntimeException("文件不存在");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String script = reader.lines().collect(Collectors.joining(System.lineSeparator()));
                try (Jedis jedis = jedisPool.getResource()) {
                    UNLOCK_SCRIPT_SHA = jedis.scriptLoad(script);
                }
            }
        }
    }

}
