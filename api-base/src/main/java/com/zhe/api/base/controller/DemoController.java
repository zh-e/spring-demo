package com.zhe.api.base.controller;

import com.zhe.api.base.bean.BaseResponse;
import com.zhe.api.base.constant.RespCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/get")
    public BaseResponse<String> get() {
        LOGGER.debug("debug log");
        LOGGER.info("info log");
        LOGGER.error("error log");
        return new BaseResponse<>(RespCodeEnum.SUCCESS, "success");
    }


}
