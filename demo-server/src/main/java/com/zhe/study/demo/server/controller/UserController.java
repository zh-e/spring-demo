package com.zhe.study.demo.server.controller;

import com.zhe.study.demo.server.bean.User;
import com.zhe.study.demo.server.dao.UserDAO;
import com.zhe.study.demo.server.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhe
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@GetMapping("/getById")
	public User get(@RequestParam Long id) {
		UserModel model = userDAO.findaaa(id);
		return new User(model.getId(), model.getName());
	}

}
