package com.zhe.mybatis.demo.mapper;

import com.zhe.mybatis.demo.model.AppUserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AppUserMapper {

    List<AppUserModel> findAll();

    @Update("update app_user set sex = 'f' where id = 1")
    int update();


}
