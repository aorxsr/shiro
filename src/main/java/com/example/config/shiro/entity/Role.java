package com.example.config.shiro.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 14:17
 */
@Data
@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "role_name")
	private String roleName;

}
