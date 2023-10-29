package com.demo1.dao;

import com.demo1.dao.entity.OptionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OptionEntityMapper {
    /**
     * 查看选项
     * @param optionEntity
     * @return
     */
    List<OptionEntity> queryOptionList(OptionEntity optionEntity);

    /**
     * 增加选项
     * @param optionEntity
     * @return
     */
    int insert(OptionEntity optionEntity);

    /**
     * 修改选项信息
     * @param optionEntity
     * @return
     */
    int updateByPrimaryKeySelective(OptionEntity optionEntity);

    /**
     * 删除选项
     * @param optionEntity
     * @return
     */
    int deleteOptionById(OptionEntity optionEntity);
}
