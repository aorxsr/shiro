package com.example.config.shiro.config;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
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
		shiroFilterFactoryBean.setLoginUrl("/api/view/comm/login");
		shiroFilterFactoryBean.setSuccessUrl("/api/view/comm/index");
		shiroFilterFactoryBean.setUnauthorizedUrl("/api/view/comm/unauthorized");

		Map<String, String> filterChainDefinitonMap = new LinkedHashMap<>();

		filterChainDefinitonMap.put("/api/view/comm/**", DefaultFilter.anon.name());
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

	@Bean
	public SimpleCookie simpleCookie() {
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		simpleCookie.setHttpOnly(true);
		// 记住我 10 天
		simpleCookie.setMaxAge(60 * 60 * 24 * 10);
		return simpleCookie;
	}

	@Bean
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(simpleCookie());
		cookieRememberMeManager.setCipherKey(Base64.decode("AsfawfsdfaAasdWWW=="));
		return cookieRememberMeManager;
	}

}
