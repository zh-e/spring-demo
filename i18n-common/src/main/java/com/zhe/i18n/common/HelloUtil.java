package com.zhe.i18n.common;

import org.springframework.stereotype.Service;

@Service
public class HelloUtil {

    public String get() {
        return I18nMessageUtil.getMessage("hello.test");
    }

}
