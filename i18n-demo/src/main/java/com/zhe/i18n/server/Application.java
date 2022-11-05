package com.zhe.i18n.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@ComponentScan(basePackages = "com.zhe.i18n")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args)
                .getBean(DispatcherServlet.class)
                //设置将 LocaleContext 和 RequestAttributes 公开为子线程可继承
                .setThreadContextInheritable(true);
    }

}
