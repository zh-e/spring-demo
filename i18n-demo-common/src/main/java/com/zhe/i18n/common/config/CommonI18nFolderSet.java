package com.zhe.i18n.common.config;

import org.springframework.stereotype.Component;

@Component
public class CommonI18nFolderSet implements I18nFolderSet{
    @Override
    public String i18nFolder() {
        return "i18n/common/messages";
    }
}
