package com.demo1.dao;

import com.demo1.dao.entity.PaperAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PaperAnswerEntityMapper {

    /**
     * 查询答卷选项
     * @param paperAnswer
     * @return
     */
    List<PaperAnswer> queryPaperAnswerList(PaperAnswer paperAnswer);

    /**
     * 增加答卷选项
     * @param paperAnswer
     * @return
     */
    int insert(PaperAnswer paperAnswer);

    /**
     * 修改答卷选项
     * @param paperAnswer
     * @return
     */
    int updateByPrimaryKeySelective(PaperAnswer paperAnswer);

    /**
     * 删除答卷选项
     * @param paperAnswer
     * @return
     */
    int deletePaperAnswerById(PaperAnswer paperAnswer);
}
