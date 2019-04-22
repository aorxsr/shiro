package com.example.config.shiro.thymeleaf;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 16:13
 */
@Configuration
public class Config {

	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}

}
