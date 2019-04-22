package com.example.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 14:45
 */
@Configuration
public class DruidConfiguration {

	@Value("${druid.username}")
	String druidUsername;

	@Value("${druid.password}")
	String druidPassword;

	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/api/druid/*");
		servletRegistrationBean.addInitParameter("loginUsername", druidUsername);
		servletRegistrationBean.addInitParameter("loginPassword", druidPassword);
		//是否能够重置数据
		servletRegistrationBean.addInitParameter("resetEnable","true");
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean statFilter(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new WebStatFilter());
		//添加过滤规则
		filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

}
