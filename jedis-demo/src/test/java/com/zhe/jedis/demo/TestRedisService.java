package com.zhe.jedis.demo;

import com.zhe.jedis.demo.service.RedisService;
import com.zhe.jedis.demo.service.RedisSubscribeDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestRedisService {

    @Resource
    private RedisService redisService;

    @Test
    public void testSet() {
        boolean res = redisService.set("test", "1", 100);
        Assertions.assertEquals(res, true);
    }

    @Test
    public void testLock() throws Exception {
        redisService.withLockExec("test", 100, 100, () -> {
            System.out.println("111");
        });

        redisService.withLockExec("test", 100, 100, () -> "111");
    }

    @Test
    public void testSetNx() {

        boolean res = redisService.setNx("testNx", "1", 10);
        Assertions.assertEquals(res, true);
        res = redisService.setNx("testNx", "1", 10);
        Assertions.assertEquals(res, false);
    }

    @Test
    public void testSubscribe() {
        new Thread(() -> {
            redisService.subscribe(new RedisSubscribeDemo(), "test-subscribe");
        }).start();

        redisService.publish("test-subscribe", "test1");
        redisService.publish("test-subscribe", "test2");
        redisService.publish("test-subscribe", "test3");

    }


}
