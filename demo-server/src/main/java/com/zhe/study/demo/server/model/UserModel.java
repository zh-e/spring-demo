package com.zhe.study.demo.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author zhangzhe
 */
@Getter
@Setter
@Entity
@Table(name = "t_user")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

}
