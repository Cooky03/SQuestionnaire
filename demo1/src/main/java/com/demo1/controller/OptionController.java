package com.demo1.controller;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.dao.entity.OptionEntity;
import com.demo1.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class OptionController {
    
    @Autowired
    private OptionService optionService;

    /**
     * 查询选项
     * @param optionEntity
     * @return
     */
    @RequestMapping(value = "/queryOptionList", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity queryOptionList(@RequestBody OptionEntity optionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<OptionEntity> hasOption = optionService.queryOptionList(optionEntity);
            if (CollectionUtils.isEmpty(hasOption)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("无选项信息");
            }else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasOption);
                httpResponseEntity.setMessage("查询成功");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 增加选项
     * @param optionEntity
     * @return
     */
    @RequestMapping(value = "/addOptionInfo", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addOptionInfo(@RequestBody OptionEntity optionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = optionService.insert(optionEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("新增选项成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("新增选项失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 修改选项
     * @param optionEntity
     * @return
     */
    @RequestMapping(value = "/modifyOptionInfo", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity modifyOptionInfo(@RequestBody OptionEntity optionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = optionService.updateByPrimaryKeySelective(optionEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 删除选项
     * @param optionEntity
     * @return
     */
    @RequestMapping(value = "/deleteOptionById", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity deleteOptionById(@RequestBody OptionEntity optionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = optionService.deleteOptionById(optionEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}
