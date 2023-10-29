package com.demo1;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.controller.QuestionController;
import com.demo1.dao.entity.QuestionEntity;


import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.apache.log4j.Logger;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoQuestionTests {

    Logger log = Logger.getLogger(DemoApplicationTests.class);

    @Resource
    private QuestionController questionController;

    @Test
    @Order(1)
    public void A_testQuery(){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("680cf8c2ee41430ab647a77dafc2fc5c");
        QuestionEntity questionEntity1 = new QuestionEntity();
        questionEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = questionController.queryQuestionList(questionEntity);
        HttpResponseEntity httpResponseEntity1 = questionController.queryQuestionList(questionEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(2)
    public void B_testInsert(){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("t_e_s_t");
        questionEntity.setQuestionnaireId("tteesstt");
        questionEntity.setQuestionNum(0);
        questionEntity.setQuestionTitle("tteesstt");
        questionEntity.setQuestionType("1");
        questionEntity.setMustAnswer("1");
        HttpResponseEntity httpResponseEntity = questionController.addQuestionInfo(questionEntity);
        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
    }

    @Test
    @Order(3)
    public void C_testUpdate(){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("tteesstt");
        questionEntity.setQuestionTitle("t_e_s_t");
        QuestionEntity questionEntity1 = new QuestionEntity();
        questionEntity1.setQuestionTitle("t_e_s_t");

        HttpResponseEntity httpResponseEntity = questionController.modifyQuestionInfo(questionEntity);
        HttpResponseEntity httpResponseEntity1 = questionController.modifyQuestionInfo(questionEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(4)
    public void D_testDelete(){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("tteesstt");
        QuestionEntity questionEntity1 = new QuestionEntity();
        questionEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = questionController.deleteQuestionById(questionEntity);
        HttpResponseEntity httpResponseEntity1 = questionController.deleteQuestionById(questionEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }
}
