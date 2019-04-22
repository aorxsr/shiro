package com.example.config.utils;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 18:19
 */
@Builder
@Data
@NoArgsConstructor
public class RestUtil {

	private Integer statusCode;
	private Object body;
	private String message;

	public RestUtil(Object object) {
		this.statusCode = 200;
		this.body = object;
	}

	public RestUtil(Integer statusCode, Object body, String message) {
		this.statusCode = statusCode;
		this.body = body;
		this.message = message;
	}
}
