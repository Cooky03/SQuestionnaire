package com.demo1.controller;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.dao.entity.ProjectEntity;
import com.demo1.dao.entity.QuestionnaireEntity;
import com.demo1.dao.entity.UserEntity;
import com.demo1.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    /**
     * 查询问卷
     * @param projectEntity
     * @return
     */
    @RequestMapping(value = "/queryQuestionnaireList", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity queryQuestionnaireList(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<QuestionnaireEntity> hasQuestionnaire = questionnaireService.queryQuestionnaireList(projectEntity);
            if (CollectionUtils.isEmpty(hasQuestionnaire)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("无问卷信息");
            }else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasQuestionnaire);
                httpResponseEntity.setMessage("查询成功");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 根据ID查询问卷
     * @param questionnaireEntity
     * @return
     */
    @RequestMapping(value = "/findQuestionnaireById", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity findQuestionnaireById(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<QuestionnaireEntity> hasQuestionnaire = questionnaireService.findQuestionnaireById(questionnaireEntity);
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(hasQuestionnaire);
            httpResponseEntity.setMessage("查询成功");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 新增问卷
     * @param questionnaireEntity
     * @return
     */
    @RequestMapping(value = "/addQuestionnaireInfo", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addQuestionnaireInfo(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionnaireService.insert(questionnaireEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(questionnaireEntity.getId());
                httpResponseEntity.setMessage("新增问卷成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("新增问卷失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 修改问卷信息
     * @param questionnaireEntity
     * @return
     */
    @RequestMapping(value = "/modifyQuestionnaireInfo", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity modifyQuestionnaireInfo(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionnaireService.updateByPrimaryKeySelective(questionnaireEntity);
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
     * 删除问卷
     * @param questionnaireEntity
     * @return
     */
    @RequestMapping(value = "/deleteQuestionnaireById", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity deleteQuestionnaireById(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionnaireService.deleteQuestionnaireById(questionnaireEntity);
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
