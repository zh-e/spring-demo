package com.zhe.demo.server.client;

import com.zhe.demo.server.fallback.HelloFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangzhe
 */
@FeignClient(value = "demo-server", fallback = HelloFeignFallback.class)
public interface HelloFeign {

	@GetMapping("/hi")
	String feignGet(@RequestParam String getStr);

}
