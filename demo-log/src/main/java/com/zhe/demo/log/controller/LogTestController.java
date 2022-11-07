package com.zhe.demo.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    @GetMapping("/log/test")
    public String test() {

        log.debug("===debug===");
        log.info("===info===");
        log.warn("===warn===");
        log.error("===error===");

        return "success";
    }


}
