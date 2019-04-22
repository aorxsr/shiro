package com.example.config.shiro.service;

import com.example.config.shiro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 16:28
 */
@Repository
public interface RoleService extends JpaRepository<Role, Integer> {
}
