package com.zhe.study.demo.server.dao;

import com.zhe.study.demo.server.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * @author zhangzhe
 */
public interface UserDAO extends Repository<UserModel, Long> {

	UserModel findById(Long id);

	@Query(value = "select * from t_user where id = ?1", nativeQuery = true)
	UserModel findaaa(Long id);

}
