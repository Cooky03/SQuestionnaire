package com.demo1.service;

import com.demo1.common.utils.UUIDUtil;
import com.demo1.dao.OptionEntityMapper;
import com.demo1.dao.entity.OptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionEntityMapper optionEntityMapper;

    /**
     * 查询选项
     * @param optionEntity
     * @return
     */
    public List<OptionEntity> queryOptionList(OptionEntity optionEntity){
        List<OptionEntity> result = optionEntityMapper.queryOptionList(optionEntity);
        return result;
    }

    /**
     * 创建选项
     * @param optionEntity
     * @return
     */
    public int insert(OptionEntity optionEntity){
        optionEntity.setId(UUIDUtil.getOneUUID());
        int result = optionEntityMapper.insert(optionEntity);
        if (result != 0)
            return 3;
        else
            return result;
    }

    /**
     * 修改选项
     * @param optionEntity
     * @return
     */
    public int updateByPrimaryKeySelective(OptionEntity optionEntity){
        int result = optionEntityMapper.updateByPrimaryKeySelective(optionEntity);
        return result;
    }

    /**
     * 删除选项
     * @param optionEntity
     * @return
     */
    public int deleteOptionById(OptionEntity optionEntity){
        int result = optionEntityMapper.deleteOptionById(optionEntity);
        return result;
    }
}
