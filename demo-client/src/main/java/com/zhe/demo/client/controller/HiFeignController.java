package com.zhe.demo.client.controller;

import com.zhe.demo.server.client.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangzhe
 */
@RestController
@RequestMapping("/hi")
public class HiFeignController {

	@Autowired
	private HelloFeign helloFeign;

	@GetMapping("/get")
	public String feignGet(@RequestParam String getStr) {
		return helloFeign.feignGet(getStr);
	}

}
