package com.example.config.shiro.config;

import com.example.config.shiro.entity.User;
import com.example.config.shiro.entity.UserRole;
import com.example.config.shiro.service.UserRoleService;
import com.example.config.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 先认证 后授权
 * 先执行下面的 后执行上面的
 *
 * @Author: aorxsr
 * @Date: 2019/4/22 15:29
 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println(principals.toString());
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		List<UserRole> roleList = userRoleService.findAllByUserId(username);

		roleList.forEach( s -> {
			info.addRole(s.getRoleId());
		});

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println(authenticationToken.toString());
		String username = (String) authenticationToken.getPrincipal();
		String password = (String) authenticationToken.getCredentials();
		User user = userService.findByUsernameAndPassword(username, password);
		if (null == user) {
			return null;
		} else {
			return new SimpleAuthenticationInfo(username, password, "customRealm");
		}
	}
}
