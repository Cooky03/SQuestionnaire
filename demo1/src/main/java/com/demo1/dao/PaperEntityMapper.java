package com.demo1.dao;

import com.demo1.dao.entity.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PaperEntityMapper {
    /**
     * 查找答卷
     * @param paper
     * @return
     */
    List<Paper> findByQuestionnaireId(Paper paper);

    /**
     * 增加答卷
     * @param paper
     * @return
     */
    int insert(Paper paper);

    /**
     * 修改答卷信息
     * @param paper
     * @return
     */
    int updateByPrimaryKeySelective(Paper paper);

    /**
     * 删除答卷
     * @param paper
     * @return
     */
    int deletePaperById(Paper paper);
}
