package com.demo1.controller;

import com.demo1.beans.HttpResponseEntity;
import com.demo1.dao.entity.QuestionnaireEntity;
import com.demo1.service.QuestionnaireService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/q")
public class ToPaperController {

    @Autowired
    private QuestionnaireService questionnaireService;

    private String qid = "test";

    @GetMapping("/{questionnaireId}")
    public ModelAndView page(@PathVariable String questionnaireId){
        qid = questionnaireId;
        ModelAndView modelAndView = new ModelAndView("redirect:/pages/answerSheet/index.html");
        modelAndView.addObject("questionnaireId", questionnaireId);
        return modelAndView;
    }

    @RequestMapping(value = "/getQuestionnaireId", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String getQid(){
        return qid;
    }
}
