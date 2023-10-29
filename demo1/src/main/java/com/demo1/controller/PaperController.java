package com.demo1.controller;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.dao.entity.Paper;
import com.demo1.dao.entity.QuestionnaireEntity;
import com.demo1.service.PaperService;
import com.demo1.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;
    @Autowired
    private QuestionnaireService questionnaireService;

    /**
     * 查询答卷
     *
     * @param paper
     * @return
     */
    @RequestMapping(value = "/admin/queryPaperList", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryPaperList(@RequestBody Paper paper) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<Paper> hasPaper = paperService.findByQuestionnaireId(paper);
            if (CollectionUtils.isEmpty(hasPaper)) {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("无答卷信息");
            } else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasPaper);
                httpResponseEntity.setMessage("查询成功");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 增加答卷
     *
     * @param paper
     * @return
     */
    @RequestMapping(value = "/admin/addPaperInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addPaperInfo(@RequestBody Paper paper) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            String result = paperService.insert(paper);
            if (result != "false") {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("新增答卷成功");
            } else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("新增答卷失败");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 修改答卷
     *
     * @param paper
     * @return
     */
    @RequestMapping(value = "/admin/modifyPaperInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyPaperInfo(@RequestBody Paper paper) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = paperService.updateByPrimaryKeySelective(paper);
            if (result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            } else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 删除答卷
     *
     * @param paper
     * @return
     */
    @RequestMapping(value = "/admin/deletePaperById", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deletePaperById(@RequestBody Paper paper) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = paperService.deletePaperById(paper);
            if (result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            } else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}
