package com.demo1;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.common.utils.UUIDUtil;
import com.demo1.controller.QuestionnaireController;
import com.demo1.dao.QuestionnaireEntityMapper;
import com.demo1.dao.entity.ProjectEntity;
import com.demo1.dao.entity.QuestionnaireEntity;
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
public class DemoQuestionnaireTests {

    @Resource
    private QuestionnaireController questionnaireController;

    Logger log = Logger.getLogger(DemoApplicationTests.class);


    @Test
    @Order(1)
    public void A_testQuery() {
        ProjectEntity projectEntity = new ProjectEntity();
        ProjectEntity projectEntity1 = new ProjectEntity();
        projectEntity.setId("1");
        projectEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = questionnaireController.queryQuestionnaireList(projectEntity);
        HttpResponseEntity httpResponseEntity1 = questionnaireController.queryQuestionnaireList(projectEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(2)
    public void B_testInsert() {
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        questionnaireEntity.setId("t_e_s_t");
        questionnaireEntity.setQuestionnaireTitle("tteesstt");
        questionnaireEntity.setCreatedBy("admin");
        questionnaireEntity.setQuestionnaireDescription("tteesstt");
        questionnaireEntity.setStatus("1");
        questionnaireEntity.setQuestionnaireType("test");
        HttpResponseEntity httpResponseEntity = questionnaireController.addQuestionnaireInfo(questionnaireEntity);
        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
    }

//    @Test
//    @Order(3)
//    public void C_testUpdate() {
//        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
//        questionnaireEntity.setId("tteesstt");
//        questionnaireEntity.setQuestionnaireTitle("t_e_s_t");
//        QuestionnaireEntity questionnaireEntity1 = new QuestionnaireEntity();
//        questionnaireEntity1.setQuestionnaireTitle("t_e_s_t");
//
//        HttpResponseEntity httpResponseEntity = questionnaireController.modifyQuestionnaireInfo(questionnaireEntity);
//        HttpResponseEntity httpResponseEntity1 = questionnaireController.modifyQuestionnaireInfo(questionnaireEntity1);
//
//        log.info("---结果---");
//        log.info(httpResponseEntity.getMessage().toString());
//        log.info(httpResponseEntity1.getMessage().toString());
//    }

    @Test
    @Order(4)
    public void D_testDelete() {
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        questionnaireEntity.setId("tteesstt");
        QuestionnaireEntity questionnaireEntity1 = new QuestionnaireEntity();
        questionnaireEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = questionnaireController.deleteQuestionnaireById(questionnaireEntity);
        HttpResponseEntity httpResponseEntity1 = questionnaireController.deleteQuestionnaireById(questionnaireEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(5)
    public void E_testFind(){
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        questionnaireEntity.setId("22c6da2f8809497ab333c8b70929ed6e");
        QuestionnaireEntity questionnaireEntity1 = new QuestionnaireEntity();
        questionnaireEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = questionnaireController.findQuestionnaireById(questionnaireEntity);
        HttpResponseEntity httpResponseEntity1 = questionnaireController.findQuestionnaireById(questionnaireEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }
}