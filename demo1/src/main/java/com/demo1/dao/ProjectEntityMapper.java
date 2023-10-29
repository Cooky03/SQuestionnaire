package com.demo1.dao;

import com.demo1.dao.entity.ProjectEntity;
import com.demo1.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectEntityMapper {
    /**
     * 查询项目列表
     */
    List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);


    /**
     * 新建项目
     */
    int insert(ProjectEntity projectEntity);

    /**
     * 修改项目
     */
    int updateByPrimaryKeySelective(ProjectEntity projectEntity);

    /**
     * 删除项目
     */
    int deleteProjectById(ProjectEntity projectEntity);
}
