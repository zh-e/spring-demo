package com.zhe.api.base.controller;

import com.zhe.api.base.bean.BaseResponse;
import com.zhe.api.base.bean.DemoReq;
import com.zhe.api.base.constant.RespCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/get1")
    public BaseResponse<String> get1() {
        LOGGER.info("get1");

        new Thread(() -> {
            LOGGER.info("thread");
        }).start();

        return new BaseResponse<>(RespCodeEnum.SUCCESS, "get1 success");
    }

    @GetMapping("/get2")
    public BaseResponse<String> get2(@RequestParam String name) {
        return new BaseResponse<>(RespCodeEnum.SUCCESS, "get2" + name);
    }

    @GetMapping("/get3/{pathValue}")
    public BaseResponse<String> get3(@PathVariable("pathValue") String value) {
        return new BaseResponse<>(RespCodeEnum.SUCCESS, "get3" + value);
    }

    @PostMapping("/post1")
    public BaseResponse<String> post1() {
        return new BaseResponse<>(RespCodeEnum.SUCCESS, "post1");
    }

    @PostMapping("/post2")
    public BaseResponse<DemoReq> post2(@RequestBody DemoReq demoReq) {
        return new BaseResponse<>(RespCodeEnum.SUCCESS, demoReq);
    }

}
