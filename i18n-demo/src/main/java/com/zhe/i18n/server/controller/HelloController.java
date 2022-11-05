package com.zhe.i18n.server.controller;

import com.zhe.i18n.common.HelloUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HelloUtil helloUtil;

    @GetMapping("/hello")
    public String hello() {
        Locale locale = LocaleContextHolder.getLocale();

        String msg = messageSource.getMessage("current.local", null, locale);
        System.out.println("无参数 本项目 msg:" + msg);

        msg = messageSource.getMessage("hello.arg", new Object[]{11, 22}, locale);
        System.out.println("有参数 本项目 msg:" + msg);


        msg = helloUtil.get();
        System.out.println("有参数 依赖项目 msg:" + msg);

        //todo 子线程获取不到父线程的 LocaleContextHolder
        new Thread(() -> {
            Locale locale1 = LocaleContextHolder.getLocale();
            System.out.println(locale1.getLanguage());
        }).start();

        return "hello success";
    }


}
