package com.example.config.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 16:34
 */
@Controller
@RequestMapping(value = "/api/view/comm")
public class IndexController {

	@RequestMapping(value = "/index")
	public String index() {
		return "/index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "/login";
	}

	@RequestMapping(value = "/register")
	public String register() {
		return "/register";
	}

	@RequestMapping(value = "/unauthorized")
	public String unauthorized() {
		return "/unauthorized";
	}

}
