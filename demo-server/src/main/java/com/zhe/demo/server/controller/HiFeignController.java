package com.zhe.demo.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhe
 */
@RestController
public class HiFeignController {

	@GetMapping("/hi")
	public String feignGet(@RequestParam String getStr) {
		return "hi " + getStr;
	}

}
