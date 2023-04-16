package com.zhe.mybatis.demo.mapper;

import com.zhe.mybatis.demo.model.AppUserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AppUserDAO {

    /**
     * @return
     */
    List<AppUserModel> findAll();

    /**
     * 根据id更新
     *
     * @param id id
     * @return
     */
    @Update("update app_user set sex = #{sex} where id = #{id}")
    int update(Long id, String sex);


}
