package com.demo1.service;

import com.demo1.common.utils.UUIDUtil;
import com.demo1.dao.PaperAnswerEntityMapper;
import com.demo1.dao.entity.PaperAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperAnswerService {

    @Autowired
    private PaperAnswerEntityMapper paperAnswerEntityMapper;

    /**
     * 查询答卷选项
     * @param paperAnswer
     * @return
     */
    public List<PaperAnswer> queryPaperAnswerList(PaperAnswer paperAnswer){
        List<PaperAnswer> result = paperAnswerEntityMapper.queryPaperAnswerList(paperAnswer);
        return result;
    }

    /**
     * 创建答卷选项
     * @param paperAnswer
     * @return
     */
    public int insert(PaperAnswer paperAnswer){
        paperAnswer.setId(UUIDUtil.getOneUUID());
        int result = paperAnswerEntityMapper.insert(paperAnswer);
        if (result != 0)
            return 3;
        else
            return result;
    }

    /**
     * 修改答卷选项
     * @param paperAnswer
     * @return
     */
    public int updateByPrimaryKeySelective(PaperAnswer paperAnswer){
        int result = paperAnswerEntityMapper.updateByPrimaryKeySelective(paperAnswer);
        return result;
    }

    /**
     * 删除答卷选项
     * @param paperAnswer
     * @return
     */
    public int deletePaperAnswerById(PaperAnswer paperAnswer){
        int result = paperAnswerEntityMapper.deletePaperAnswerById(paperAnswer);
        return result;
    }
}
