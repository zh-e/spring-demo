package com.zhe.api.base.controller;

import com.zhe.api.base.bean.BaseResponse;
import com.zhe.api.base.bean.ValueDemo;
import com.zhe.api.base.constant.RespCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

   @Autowired
   private ValueDemo value;

    @GetMapping("/get")
    public BaseResponse<String> get() {
        return new BaseResponse<>(RespCodeEnum.SUCCESS, value.toString());
    }


}
