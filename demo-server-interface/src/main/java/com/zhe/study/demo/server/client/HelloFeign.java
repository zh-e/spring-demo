package com.zhe.study.demo.server.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangzhe
 */
@FeignClient(value = "demo-server")
public interface HelloFeign {

	@GetMapping("/hi")
	String feignGet(@RequestParam String getStr);

}
