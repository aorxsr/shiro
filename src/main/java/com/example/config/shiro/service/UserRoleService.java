package com.example.config.shiro.service;

import com.example.config.shiro.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 16:29
 */
@Repository
public interface UserRoleService extends JpaRepository<UserRole, Integer> {

	List<UserRole> findAllByUserId(String userId);

}
