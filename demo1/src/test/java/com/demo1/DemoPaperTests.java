package com.demo1;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.controller.PaperController;
import com.demo1.controller.QuestionController;
import com.demo1.dao.entity.Paper;


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
public class DemoPaperTests {

    Logger log = Logger.getLogger(DemoApplicationTests.class);

    @Resource
    private PaperController paperController;

    @Test
    @Order(1)
    public void A_testQuery(){
        Paper paper = new Paper();
        paper.setQuestionnaireId("22c6da2f8809497ab333c8b70929ed6e");
        Paper paper1 = new Paper();
        paper1.setQuestionnaireId("xxx");

        HttpResponseEntity httpResponseEntity = paperController.queryPaperList(paper);
        HttpResponseEntity httpResponseEntity1 = paperController.queryPaperList(paper1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(2)
    public void B_testInsert(){
        Paper paper = new Paper();
        paper.setId("t_e_s_t");
        paper.setQuestionnaireId("tteesstt");
        paper.setAnswerSource("test");
        HttpResponseEntity httpResponseEntity = paperController.addPaperInfo(paper);
        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
    }

    @Test
    @Order(3)
    public void C_testUpdate(){
        Paper paper = new Paper();
        paper.setId("tteesstt");
        paper.setAnswerSource("yyy");
        Paper paper1 = new Paper();
        paper1.setAnswerSource("yyy");

        HttpResponseEntity httpResponseEntity = paperController.modifyPaperInfo(paper);
        HttpResponseEntity httpResponseEntity1 = paperController.modifyPaperInfo(paper1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(4)
    public void D_testDelete(){
        Paper paper = new Paper();
        paper.setId("tteesstt");
        Paper paper1 = new Paper();
        paper1.setId("xxx");

        HttpResponseEntity httpResponseEntity = paperController.deletePaperById(paper);
        HttpResponseEntity httpResponseEntity1 = paperController.deletePaperById(paper1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }
}
