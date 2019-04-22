package com.example.config.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 15:38
 */
@Configuration
public class ShiroConfig {


	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/index");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

		Map<String, String> filterChainDefinitonMap = new LinkedHashMap<>();

		filterChainDefinitonMap.put("/druid/**", DefaultFilter.anon.name());
		filterChainDefinitonMap.put("/statics/**", DefaultFilter.anon.name());
		filterChainDefinitonMap.put("/api/user/login/**", DefaultFilter.anon.name());

		filterChainDefinitonMap.put("/logout","logout");
		filterChainDefinitonMap.put("/**", DefaultFilter.authc.name());

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitonMap);

		return shiroFilterFactoryBean;
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(customRealm());
		return securityManager;
	}

	@Bean
	public CustomRealm customRealm() {
		return new CustomRealm();
	}

}
