package com.demo1.service;

import com.demo1.common.utils.UUIDUtil;
import com.demo1.dao.QuestionEntityMapper;
import com.demo1.dao.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionEntityMapper questionEntityMapper;

    /**
     * 查询问题
     * @param questionEntity
     * @return
     */
    public List<QuestionEntity> queryQuestionList(QuestionEntity questionEntity){
        List<QuestionEntity> result = questionEntityMapper.queryQuestionList(questionEntity);
        return result;
    }

    /**
     * 创建问题
     * @param questionEntity
     * @return
     */
    public int insert(QuestionEntity questionEntity){
        questionEntity.setId(UUIDUtil.getOneUUID());
        int result = questionEntityMapper.insert(questionEntity);
        if (result != 0)
            return 3;
        else
            return result;
    }

    /**
     * 修改问题
     * @param questionEntity
     * @return
     */
    public int updateByPrimaryKeySelective(QuestionEntity questionEntity){
        int result = questionEntityMapper.updateByPrimaryKeySelective(questionEntity);
        return result;
    }

    /**
     * 删除问题
     * @param questionEntity
     * @return
     */
    public int deleteQuestionById(QuestionEntity questionEntity){
        int result = questionEntityMapper.deleteQuestionById(questionEntity);
        return result;
    }
}
