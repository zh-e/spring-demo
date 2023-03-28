package com.zhe.jedis.demo;

import com.zhe.jedis.demo.service.RedisService;
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

}
