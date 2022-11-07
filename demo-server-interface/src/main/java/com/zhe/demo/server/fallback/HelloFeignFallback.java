package com.zhe.demo.server.fallback;

import com.zhe.demo.server.client.HelloFeign;
import org.springframework.stereotype.Component;

/**
 * @author zhangzhe
 */
@Component
public class HelloFeignFallback implements HelloFeign {

	@Override
	public String feignGet(String getStr) {
		return "default";
	}
}
