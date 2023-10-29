package com.demo1.service;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.common.utils.UUIDUtil;
import com.demo1.dao.ProjectEntityMapper;
import com.demo1.dao.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;

    /**
     * 查询项目
     * @param projectEntity
     * @return
     */
    public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity){
        List<ProjectEntity> result = projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }

    /**
     * 创建项目
     * @param projectEntity
     * @return
     */
    public int addProjectInfo(ProjectEntity projectEntity){
        projectEntity.setId(UUIDUtil.getOneUUID());
        int projectResult = projectEntityMapper.insert(projectEntity);
        if (projectResult != 0){
            return 3; //数字3代表项目存在
        }
        else
            return projectResult;
    }

    /**
     * 修改项目
     * @param projectEntity
     * @return
     */
    public int modifyProjectInfo(ProjectEntity projectEntity){
        int projectResult = projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
        return projectResult;
    }

    /**
     * 删除项目
     * @param projectEntity
     * @return
     */
    public int deleteProjectById(ProjectEntity projectEntity){
        int projectResult = projectEntityMapper.deleteProjectById(projectEntity);
        return projectResult;
    }
}
