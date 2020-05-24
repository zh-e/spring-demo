package com.zhe.dubbo.client.controller;

import com.zhe.dubbo.server.client.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("/name")
    public String getName(@RequestParam String name) {
        return helloService.hello(name);
    }

}
