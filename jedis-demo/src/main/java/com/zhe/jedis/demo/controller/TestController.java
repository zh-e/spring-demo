package com.zhe.jedis.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jedis")
public class TestController {

    @Resource
    private JedisPool jedisPool;

    @GetMapping("/test")
    public String get() {

        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get("tt");
        }

    }


}
