package com.zhe.i18n.server.controller;

import com.zhe.i18n.common.HelloUtil;
import com.zhe.i18n.common.I18nMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private HelloUtil helloUtil;

    @GetMapping("/hello")
    public String hello() {

        String msg = I18nMessageUtil.getMessage("current.local");
        System.out.println("无参数 本项目 msg:" + msg);

        msg = I18nMessageUtil.getMessage("hello.arg", new Object[]{11, 22});
        System.out.println("有参数 本项目 msg:" + msg);

        msg = I18nMessageUtil.getMessage("hello.arg1", new Object[]{"后", "前"});
        System.out.println("有参数 本项目 顺序 msg:" + msg);


        msg = helloUtil.get();
        System.out.println("有参数 依赖项目 msg:" + msg);

        new Thread(() -> {
            String threadMsg = I18nMessageUtil.getMessage("hello.arg", new Object[]{"子11", "子22"});
            System.out.println("有参数 子线程 msg:" + threadMsg);
        }).start();

        return "hello success";
    }


}
