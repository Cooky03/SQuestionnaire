package com.demo1.service;

import com.demo1.common.utils.UUIDUtil;
import com.demo1.dao.PaperEntityMapper;
import com.demo1.dao.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {
    @Autowired
    private PaperEntityMapper paperEntityMapper;

    /**
     * 查询选项
     * @param paper
     * @return
     */
    public List<Paper> findByQuestionnaireId(Paper paper){
        List<Paper> result = paperEntityMapper.findByQuestionnaireId(paper);
        return result;
    }

    /**
     * 创建选项
     * @param paper
     * @return
     */
    public String insert(Paper paper){
        paper.setId(UUIDUtil.getOneUUID());
        int result = paperEntityMapper.insert(paper);
        if (result != 0)
            return paper.getId();
        else
            return "false";
    }

    /**
     * 修改选项
     * @param paper
     * @return
     */
    public int updateByPrimaryKeySelective(Paper paper){
        int result = paperEntityMapper.updateByPrimaryKeySelective(paper);
        return result;
    }

    /**
     * 删除选项
     * @param paper
     * @return
     */
    public int deletePaperById(Paper paper){
        int result = paperEntityMapper.deletePaperById(paper);
        return result;
    }
}
