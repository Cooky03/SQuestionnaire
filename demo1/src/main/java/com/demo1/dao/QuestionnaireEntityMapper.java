package com.demo1.dao;

import com.demo1.dao.entity.ProjectEntity;
import com.demo1.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface QuestionnaireEntityMapper {

    /**
     * 查询问卷
     * @param projectEntity
     * @return
     */
    List<QuestionnaireEntity> queryQuestionnaireList(ProjectEntity projectEntity);

    /**
     * 根据ID查找问卷
     * @param questionnaireEntity
     * @return
     */
    List<QuestionnaireEntity> findQuestionnaireById(QuestionnaireEntity questionnaireEntity);

    /**
     * 创建问卷
     * @param questionnaireEntity
     * @return
     */
    int insert(QuestionnaireEntity questionnaireEntity);

    /**
     * 修改问卷信息
     * @param questionnaireEntity
     * @return
     */
    int updateByPrimaryKeSelective(QuestionnaireEntity questionnaireEntity);

    /**
     * 删除问卷
     * @param questionnaireEntity
     * @return
     */
    int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity);

}
