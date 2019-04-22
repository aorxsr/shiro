package com.example.config.shiro.service;

import com.example.config.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 14:21
 */
@Repository
public interface UserService extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);

}
