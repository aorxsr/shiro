package com.example.config.controller;

import com.example.config.shiro.entity.User;
import com.example.config.utils.RestUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 18:15
 */
@RestController
@RequestMapping(value = "/api/user/login")
public class UserController {

	@PostMapping(value = "/userLogin")
	public RestUtil userLogin(@RequestBody User user) {
		System.out.println(user);
		return new RestUtil(user);
	}

}
