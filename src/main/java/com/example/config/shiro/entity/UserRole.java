package com.example.config.shiro.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 14:20
 */
@Data
@Entity
@Table(name = "user_role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "role_id")
	private String roleId;

	@Column(name = "user_id")
	private String userId;

}
