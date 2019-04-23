package com.example.config.controller;

import com.example.config.controller.model.LoginModel;
import com.example.config.utils.RestUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	public RestUtil userLogin(@RequestBody LoginModel loginModel) {
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(loginModel.getUsername(), loginModel.getPassword(), loginModel.isRememberMe());
		subject.login(token);

		return new RestUtil(loginModel);
	}

}
