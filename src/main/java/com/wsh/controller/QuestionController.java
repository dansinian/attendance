package com.wsh.controller;

import com.wsh.service.QuestionService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/deleteQuestion")
    @ResponseBody
    public JSONObject deleteQuestion(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return questionService.deleteQuestion(jsonObject);
    }

    @RequestMapping("/createQuestion")
    @ResponseBody
    public JSONObject createQuestion(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = questionService.createQuestion(jsonObject);
        return returnJson;
    }

    @RequestMapping("/updateQuestion")
    @ResponseBody
    public JSONObject updateQuestion(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = questionService.updateQuestion(jsonObject);
        return returnJson;
    }

    @RequestMapping("/selectQuestion")
    @ResponseBody
    public JSONObject selectQuestion(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        if (!"".equals(jsonData)){
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return questionService.selectQuestion(jsonObject);
        } else {
            return questionService.selectAllQuestion();
        }
    }

    @RequestMapping("/questionDetail")
    @ResponseBody
    public JSONObject questionDetail(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return questionService.questionDetail(jsonObject);
    }

    @RequestMapping("/recommendQuestion")
    @ResponseBody
    public JSONObject recommendQuestion(HttpServletRequest request){
        return questionService.recommendQuestion();
    }

    @RequestMapping("/adminList")
    @ResponseBody
    public JSONObject adminList(){
        return questionService.adminList();
    }

}
