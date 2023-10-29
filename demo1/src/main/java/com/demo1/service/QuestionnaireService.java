package com.demo1.service;

import com.demo1.common.utils.UUIDUtil;
import com.demo1.dao.QuestionnaireEntityMapper;
import com.demo1.dao.entity.ProjectEntity;
import com.demo1.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireEntityMapper questionnaireEntityMapper;

    /**
     * 查询问卷
     * @param projectEntity
     * @return
     */
    public List<QuestionnaireEntity> queryQuestionnaireList(ProjectEntity projectEntity){
        List<QuestionnaireEntity> result = questionnaireEntityMapper.queryQuestionnaireList(projectEntity);
        return result;
    }

    /**
     * 根据ID查询问卷
     * @param questionnaireEntity
     * @return
     */
    public List<QuestionnaireEntity> findQuestionnaireById(QuestionnaireEntity questionnaireEntity){
        List<QuestionnaireEntity> result = questionnaireEntityMapper.findQuestionnaireById(questionnaireEntity);
        return result;
    }

    /**
     * 新增问卷
     * @param questionnaireEntity
     * @return
     */
    public int insert(QuestionnaireEntity questionnaireEntity){
        questionnaireEntity.setId(UUIDUtil.getOneUUID());
        int questionnaireResult = questionnaireEntityMapper.insert(questionnaireEntity);
        if (questionnaireResult!=0){
            return 3;
        }else return questionnaireResult;
    }

    /**
     * 修改问卷
     * @param questionnaireEntity
     * @return
     */
    public int updateByPrimaryKeySelective(QuestionnaireEntity questionnaireEntity){
        int questionnaireResult = questionnaireEntityMapper.updateByPrimaryKeSelective(questionnaireEntity);
        return questionnaireResult;
    }

    /**
     * 删除问卷
     * @param questionnaireEntity
     * @return
     */
    public int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity){
        int questionnaireResult = questionnaireEntityMapper.deleteQuestionnaireById(questionnaireEntity);
        return questionnaireResult;
    }
}
