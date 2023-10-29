package com.demo1;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.controller.PaperAnswerController;
import com.demo1.controller.QuestionController;
import com.demo1.dao.entity.PaperAnswer;


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
public class DemoPaperAnswerTests {

    Logger log = Logger.getLogger(DemoApplicationTests.class);

    @Resource
    private PaperAnswerController paperAnswerController;

    @Test
    @Order(1)
    public void A_testQuery(){
        PaperAnswer paperAnswer = new PaperAnswer();
        paperAnswer.setPaperId("ae8e0d0f33dc4e1cbabfbfccbca6d147");
        PaperAnswer paperAnswer1 = new PaperAnswer();
        paperAnswer1.setPaperId("xxx");

        HttpResponseEntity httpResponseEntity = paperAnswerController.queryPaperAnswerList(paperAnswer);
        HttpResponseEntity httpResponseEntity1 = paperAnswerController.queryPaperAnswerList(paperAnswer1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(2)
    public void B_testInsert(){
        PaperAnswer paperAnswer = new PaperAnswer();
        paperAnswer.setId("t_e_s_t");
        paperAnswer.setPaperId("tteesstt");
        paperAnswer.setQuestionId("test");
        paperAnswer.setAnswer("1");
        HttpResponseEntity httpResponseEntity = paperAnswerController.addPaperAnswerInfo(paperAnswer);
        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
    }

    @Test
    @Order(3)
    public void C_testUpdate(){
        PaperAnswer paperAnswer = new PaperAnswer();
        paperAnswer.setId("tteesstt");
        paperAnswer.setAnswer("2");
        PaperAnswer paperAnswer1 = new PaperAnswer();
        paperAnswer1.setAnswer("2");

        HttpResponseEntity httpResponseEntity = paperAnswerController.modifyPaperAnswerInfo(paperAnswer);
        HttpResponseEntity httpResponseEntity1 = paperAnswerController.modifyPaperAnswerInfo(paperAnswer1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(4)
    public void D_testDelete(){
        PaperAnswer paperAnswer = new PaperAnswer();
        paperAnswer.setId("tteesstt");
        PaperAnswer paperAnswer1 = new PaperAnswer();
        paperAnswer1.setId("xxx");

        HttpResponseEntity httpResponseEntity = paperAnswerController.deletePaperAnswerById(paperAnswer);
        HttpResponseEntity httpResponseEntity1 = paperAnswerController.deletePaperAnswerById(paperAnswer1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }
}
