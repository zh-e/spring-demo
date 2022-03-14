package com.zhe.i18n.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class HelloUtil {

    @Autowired
    private MessageSource messageSource;

    public String get() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.test", null, locale);
    }

}
