package com.zhe.i18n.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;

@Component("messageSource")
public class MessageResourceExtension extends ResourceBundleMessageSource {

    @Value("${spring.messages.baseFolder:i18n}")
    private String baseFolder;

    @Value("${spring.messages.basename:message}")
    private String baseName;

    @PostConstruct
    public void init() {
        if (StringUtils.hasLength(baseFolder)) {
            this.setBasenames(getAllBaseNames(baseFolder));
        }

        ResourceBundleMessageSource parent = new ResourceBundleMessageSource();
        if (baseName.indexOf(",") > 0) {
            parent.setBasenames(baseName.split(","));
        } else {
            parent.setBasenames(baseName);
        }
        parent.setDefaultEncoding("UTF-8");
        this.setParentMessageSource(parent);

    }

    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        servlerre

        return null;
    }

    private String[] getAllBaseNames(final String folderName) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(folderName);
        if (null == url) {
            throw new RuntimeException("无法获取资源文件路径");
        }

        List<String> baseNames = new ArrayList<>();

        String jarPath = url.getFile().substring(url.getFile().indexOf(":") + 2, url.getFile().indexOf("!"));
        try (JarFile jarFile = new JarFile(new File(jarPath));) {
            List<String> baseJars = jarFile.stream().map(ZipEntry::toString).filter(jar -> jar.endsWith(folderName + "/")).collect(Collectors.toList());
            if (baseJars.isEmpty()) {
                return new String[0];
            }

            baseNames = jarFile.stream().map(ZipEntry::toString).filter(jar -> baseJars.stream().anyMatch(jar::startsWith)).filter(jar -> jar.endsWith(".properties")).map(jar -> jar.substring(jar.indexOf(folderName))).map(this::getI18nFileName).distinct().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return baseNames.toArray(new String[0]);
    }

    private String getI18nFileName(String fileName) {
        fileName = fileName.replace(".properties", "");
        for (int i = 0; i < 2; i++) {
            int index = fileName.lastIndexOf("_");
            if (index != -1) {
                fileName = fileName.substring(0, index);
            }
        }
        return fileName.replace("\\", "/");
    }

}
