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

        return msg;
    }

    @GetMapping("/hello1")
    public String hello1() {
        return helloUtil.get();
    }


}
