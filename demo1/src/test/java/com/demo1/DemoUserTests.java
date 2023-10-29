package com.demo1;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.common.utils.UUIDUtil;
import com.demo1.controller.UserController;
import com.demo1.dao.UserEntityMapper;
import com.demo1.dao.entity.UserEntity;
import com.demo1.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;


import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoUserTests {

    @Resource
    private UserController userController;

    Logger log = Logger.getLogger(DemoApplicationTests.class);


    @Test
    @Order(1)
    public void A_testQuery() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = userController.queryUserList(userEntity);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
    }

    @Test
    @Order(2)
    public void B_testInsert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId("t_e_s_t");
        userEntity.setUsername("tteesstt");
        userEntity.setCreatedBy("admin");
        userEntity.setPassword("tteesstt");
        userEntity.setLastUpdatedBy("admin");
        userEntity.setStatus("1");
        HttpResponseEntity httpResponseEntity = userController.addUser(userEntity);
        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
    }

    @Test
    @Order(3)
    public void C_testUpdate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId("tteesstt");
        userEntity.setUsername("t_e_s_t");
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUsername("t_e_s_t");

        HttpResponseEntity httpResponseEntity = userController.modifyUser(userEntity);
        HttpResponseEntity httpResponseEntity1 = userController.modifyUser(userEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(4)
    public void D_testDelete() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId("tteesstt");
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = userController.deleteUser(userEntity);
        HttpResponseEntity httpResponseEntity1 = userController.deleteUser(userEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }
}