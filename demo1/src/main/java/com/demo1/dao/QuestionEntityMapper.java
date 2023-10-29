package com.demo1.dao;

import com.demo1.dao.entity.QuestionEntity;
import com.demo1.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionEntityMapper {

    /**
     * 查询问题
     * @param questionEntity
     * @return
     */
    List<QuestionEntity> queryQuestionList(QuestionEntity questionEntity);

    /**
     * 新增问题
     * @param questionEntity
     * @return
     */
    int insert(QuestionEntity questionEntity);

    /**
     * 修改问题
     * @param questionEntity
     * @return
     */
    int updateByPrimaryKeySelective(QuestionEntity questionEntity);

    /**
     * 删除问题
     * @param questionEntity
     * @return
     */
    int deleteQuestionById(QuestionEntity questionEntity);
}
