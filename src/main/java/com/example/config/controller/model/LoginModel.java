package com.example.config.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: aorxsr
 * @Date: 2019/4/23 11:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginModel {

	private String username;
	private String password;
	private boolean rememberMe;

}
