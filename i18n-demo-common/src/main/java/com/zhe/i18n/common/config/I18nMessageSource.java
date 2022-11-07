package com.zhe.i18n.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component("messageSource")
public class I18nMessageSource extends ResourceBundleMessageSource {

    @Autowired
    private List<I18nFolderSet> folderSets;

    @Override
    public Set<String> getBasenameSet() {
        if (CollectionUtils.isEmpty(folderSets)) {
            return super.getBasenameSet();
        }
        return folderSets.stream().map(I18nFolderSet::i18nFolder).collect(Collectors.toSet());
    }

    @Override
    protected String getDefaultEncoding() {
        return "utf-8";
    }
}
