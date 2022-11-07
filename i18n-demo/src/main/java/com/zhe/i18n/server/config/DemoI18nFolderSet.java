package com.zhe.i18n.server.config;

import com.zhe.i18n.common.config.I18nFolderSet;
import org.springframework.stereotype.Component;

@Component
public class DemoI18nFolderSet implements I18nFolderSet {
    @Override
    public String i18nFolder() {
        return "i18n/demo/messages";
    }
}
