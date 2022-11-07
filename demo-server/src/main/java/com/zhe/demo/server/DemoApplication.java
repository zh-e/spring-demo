package com.zhe.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author zhangzhe
 */
//@EnableFeignClients
//@EnableEurekaClient
//@EnableDiscoveryClient
@EnableJpaRepositories
//@EntityScan
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
