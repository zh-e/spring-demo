package com.zhe.study.demo.server.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author zhangzhe
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("/get")
	public String get(@RequestParam String getStr) {
		return getStr;
	}

	@PostMapping("/post")
	public String post(@RequestParam String postStr) {
		return postStr;
	}

}
