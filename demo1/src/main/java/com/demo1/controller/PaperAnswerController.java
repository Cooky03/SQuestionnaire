package com.demo1.controller;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.dao.entity.PaperAnswer;
import com.demo1.dao.entity.QuestionEntity;
import com.demo1.service.PaperAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class PaperAnswerController {
    @Autowired
    private PaperAnswerService paperAnswerService;

    /**
     * 查询答卷选项
     * @param paperAnswer
     * @return
     */
    @RequestMapping(value = "/queryPaperAnswerList", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity queryPaperAnswerList(@RequestBody PaperAnswer paperAnswer){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<PaperAnswer> hasPaperAnswer = paperAnswerService.queryPaperAnswerList(paperAnswer);
            if (CollectionUtils.isEmpty(hasPaperAnswer)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("无答卷选项信息");
            }else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasPaperAnswer);
                httpResponseEntity.setMessage("查询成功");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 增加答卷选项
     * @param paperAnswer
     * @return
     */
    @RequestMapping(value = "/addPaperAnswerInfo", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addPaperAnswerInfo(@RequestBody PaperAnswer paperAnswer){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = paperAnswerService.insert(paperAnswer);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("新增答卷选项成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("新增答卷选项失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 修改答卷选项
     * @param paperAnswer
     * @return
     */
    @RequestMapping(value = "/modifyPaperAnswerInfo", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity modifyPaperAnswerInfo(@RequestBody PaperAnswer paperAnswer){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = paperAnswerService.updateByPrimaryKeySelective(paperAnswer);
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
     * 删除答卷选项
     * @param paperAnswer
     * @return
     */
    @RequestMapping(value = "/deletePaperAnswerById", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity deletePaperAnswerById(@RequestBody PaperAnswer paperAnswer){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = paperAnswerService.deletePaperAnswerById(paperAnswer);
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
