package com.zhe.mybatis.demo;

import com.zhe.mybatis.demo.mapper.AppUserDAO;
import com.zhe.mybatis.demo.model.AppUserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapper {

    @Autowired
    private AppUserDAO appUserDAO;

    @Test
    public void test() {
        List<AppUserModel> models = appUserDAO.findAll();
        System.out.println(models.toString());
    }


}
