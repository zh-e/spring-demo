package com.zhe.i18n.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class I18nMessageUtil {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        I18nMessageUtil.messageSource = messageSource;
    }

    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String code, @Nullable Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
