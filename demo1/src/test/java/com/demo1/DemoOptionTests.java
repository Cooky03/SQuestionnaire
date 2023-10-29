package com.demo1;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.controller.OptionController;
import com.demo1.dao.entity.OptionEntity;


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
public class DemoOptionTests {

    Logger log = Logger.getLogger(DemoApplicationTests.class);

    @Resource
    private OptionController optionController;

    @Test
    @Order(1)
    public void A_testQuery(){
        OptionEntity optionEntity = new OptionEntity();
        optionEntity.setQuestionId("3");
        optionEntity.setQuestionnaireId("22c6da2f8809497ab333c8b70929ed6e");
        OptionEntity optionEntity1 = new OptionEntity();
        optionEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = optionController.queryOptionList(optionEntity);
        HttpResponseEntity httpResponseEntity1 = optionController.queryOptionList(optionEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(2)
    public void B_testInsert(){
        OptionEntity optionEntity = new OptionEntity();
        optionEntity.setId("t_e_s_t");
        optionEntity.setOptionOrder("0");
        optionEntity.setOptionText("tteesstt");
        optionEntity.setLeftTitle("tteesstt");
        optionEntity.setFraction("1");
        optionEntity.setQuestionnaireId("1");
        optionEntity.setQuestionnaireId("1");
        HttpResponseEntity httpResponseEntity = optionController.addOptionInfo(optionEntity);
        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
    }

    @Test
    @Order(3)
    public void C_testUpdate(){
        OptionEntity optionEntity = new OptionEntity();
        optionEntity.setId("tteesstt");
        optionEntity.setOptionText("t_e_s_t");
        OptionEntity optionEntity1 = new OptionEntity();
        optionEntity1.setOptionText("t_e_s_t");

        HttpResponseEntity httpResponseEntity = optionController.modifyOptionInfo(optionEntity);
        HttpResponseEntity httpResponseEntity1 = optionController.modifyOptionInfo(optionEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(4)
    public void D_testDelete(){
        OptionEntity optionEntity = new OptionEntity();
        optionEntity.setId("tteesstt");
        OptionEntity optionEntity1 = new OptionEntity();
        optionEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = optionController.deleteOptionById(optionEntity);
        HttpResponseEntity httpResponseEntity1 = optionController.deleteOptionById(optionEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }
}
