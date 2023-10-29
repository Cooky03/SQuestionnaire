package com.demo1;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.controller.ProjectController;
import com.demo1.dao.entity.ProjectEntity;


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
public class DemoProjectTests {

    Logger log = Logger.getLogger(DemoApplicationTests.class);

    @Resource
    private ProjectController projectController;

    @Test
    @Order(1)
    public void A_testQuery(){
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
    public void B_testInsert(){
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
    public void C_testUpdate(){
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
    public void D_testDelete(){
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
//    //@Test
//    public void queryProjectList() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
//        //调用userMapper的方法
//        ProjectEntity projectEntity = new ProjectEntity();
//        List<ProjectEntity> list = projectEntityMapper.queryProjectList(projectEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
//            System.out.println(list);
//            // 记录info级别的信息
//            log.info(">>queryProjectList用户列表查询测试成功");
//        }
//    }
//
//    //@Test
//    public void insert() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
//        //调用userMapper的方法
//        ProjectEntity projectEntity = new ProjectEntity();
//        projectEntity.setId(UUIDUtil.getOneUUID());
//        projectEntity.setProjectName("helloworld");
//        int i = projectEntityMapper.insert(projectEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>insert用户插入测试成功");
//        }
//    }
//
//    //@Test
//    public void updateByPrimaryKeySelective() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        ProjectEntityMapper ProjectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
//        //调用userMapper的方法
//        ProjectEntity projectEntity = new ProjectEntity();
//        projectEntity.setId(UUIDUtil.getOneUUID());
//        projectEntity.setProjectName("RB-19");
//        projectEntity.setCreatedBy("redbull");
//        int i = ProjectEntityMapper.updateByPrimaryKeySelective(projectEntity);
//        if (i==0) {
//
//        } else {
//            System.out.println();
//            log.info(">>modifyProjectInfo项目列表测试成功");
//        }
//    }
//
//    //@Test
//    public void deleteProjectById() throws Exception {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
//        //调用userMapper的方法
//        ProjectEntity projectEntity = new ProjectEntity();
//        projectEntity.setId("283dcf241cf245aea824dc10bbb3d680");
//        int i = projectEntityMapper.deleteProjectById(projectEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>deleteProjectById用户插入测试成功");
//        }
//    }
//


}
