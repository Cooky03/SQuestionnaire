package com.demo1;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.controller.*;
import com.demo1.dao.entity.*;


import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;

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
public class DemoApplicationTests {

    @Resource
    private UserController userController;
    @Resource
    private ProjectController projectController;
    @Resource
    private QuestionController questionController;
    @Resource
    private QuestionnaireController questionnaireController;
    @Resource
    private OptionController optionController;
    @Resource
    private PaperController paperController;
    @Resource
    private PaperAnswerController paperAnswerController;

    Logger log = Logger.getLogger(DemoApplicationTests.class);


    @Test
    @Order(1)
    public void A_UserTestQuery() {
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
    public void B_UserTestInsert() {
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
    public void C_UserTestUpdate() {
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
    public void D_UserTestDelete() {
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

    @Test
    @Order(1)
    public void A_ProjectTestQuery(){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("1");
        ProjectEntity projectEntity1 = new ProjectEntity();
        projectEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = projectController.queryProjectList(projectEntity);
        HttpResponseEntity httpResponseEntity1 = projectController.queryProjectList(projectEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(2)
    public void B_ProjectTestInsert(){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("t_e_s_t");
        projectEntity.setProjectName("tteesstt");
        projectEntity.setCreatedBy("admin");
        projectEntity.setProjectContent("tteesstt");
        projectEntity.setLastUpdatedBy("admin");
        projectEntity.setUserId("1");
        HttpResponseEntity httpResponseEntity = projectController.addProjectInfo(projectEntity);
        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
    }

    @Test
    @Order(3)
    public void C_ProjectTestUpdate(){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("tteesstt");
        projectEntity.setProjectName("t_e_s_t");
        ProjectEntity projectEntity1 = new ProjectEntity();
        projectEntity1.setProjectName("t_e_s_t");

        HttpResponseEntity httpResponseEntity = projectController.modifyProjectInfo(projectEntity);
        HttpResponseEntity httpResponseEntity1 = projectController.modifyProjectInfo(projectEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(4)
    public void D_ProjectTestDelete(){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("tteesstt");
        ProjectEntity projectEntity1 = new ProjectEntity();
        projectEntity1.setId("xxx");

        HttpResponseEntity httpResponseEntity = projectController.deleteProjectById(projectEntity);
        HttpResponseEntity httpResponseEntity1 = projectController.deleteProjectById(projectEntity1);

        log.info("---结果---");
        log.info(httpResponseEntity.getMessage().toString());
        log.info(httpResponseEntity1.getMessage().toString());
    }

    @Test
    @Order(1)
    public void A_QuestionnaireTestQuery() {
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
    public void B_QuestionnaireTestInsert() {
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
    public void D_QuestionnaireTestDelete() {
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
    public void E_QuestionnaireTestFind(){
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

    @Test
    @Order(1)
    public void A_QuestionTestQuery(){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("8b4c94c52732456781d8361b8a4aff31");
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
    public void B_QuestionTestInsert(){
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
    public void C_QuestionTestUpdate(){
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
    public void D_QuestionTestDelete(){
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

    @Test
    @Order(1)
    public void A_OptionTestQuery(){
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
    public void B_OptionTestInsert(){
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
    public void C_OptionTestUpdate(){
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
    public void D_OptionTestDelete(){
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

    @Test
    @Order(1)
    public void A_PaperTestQuery(){
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
    public void B_PaperTestInsert(){
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
    public void C_PaperTestUpdate(){
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
    public void D_PaperTestDelete(){
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

    @Test
    @Order(1)
    public void A_PaperAnswerTestQuery(){
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
    public void B_PaperAnswerTestInsert(){
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
    public void C_PaperAnswerTestUpdate(){
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
    public void D_PaperAnswerTestDelete(){
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
//    @Test
//    public void queryUserList() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        List<UserEntity> list = userEntityMapper.queryUserList(userEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
//            System.out.println(list);
//            // 记录info级别的信息
//            log.info(">>queryUserList用户列表查询测试成功");
//        }
//    }
//
//    @Test
//    public void selectUserInfo() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("admin");
//        userEntity.setPassword("123");
//        List<UserEntity> list = userEntityMapper.selectUserInfo(userEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
//            System.out.println(list);
//            // 记录info级别的信息
//            log.info(">>qselectUserInfo用户登录测试成功");
//        }
//    }
//
//    @Test
//    public void insert() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(UUIDUtil.getOneUUID());
//        userEntity.setStatus("1");
//        userEntity.setUsername("LS");
//        userEntity.setPassword("123");
//        int i = userEntityMapper.insert(userEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>insert用户插入测试成功");
//        }
//    }
//
//    @Test
//    public void deleteUserByName() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
//        //调用userMapper的方法
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("aaaaa");
//        int i = userEntityMapper.deleteUserById(userEntity);
//        if(i==0){log.info(">>delete用户删除测试成功");
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//
//        }
//    }


}
