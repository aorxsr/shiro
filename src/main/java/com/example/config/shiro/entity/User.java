package com.example.config.shiro.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: aorxsr
 * @Date: 2019/4/22 14:17
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "salt")
	private String salt;

}
