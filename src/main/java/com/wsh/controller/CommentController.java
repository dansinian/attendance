package com.wsh.controller;

import com.wsh.service.CommentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/deleteComment")
    @ResponseBody
    public JSONObject deleteComment(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return commentService.deleteConmment(jsonObject);
    }

    @RequestMapping("/createComment")
    @ResponseBody
    public JSONObject createComment(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = commentService.createConmment(jsonObject);
        return returnJson;
    }

    @RequestMapping("/selectComment")
    @ResponseBody
    public JSONObject selectComment(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        if (!"".equals(jsonData)){
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return commentService.selectConmment(jsonObject);
        } else {
            return commentService.selectAllConmment();
        }
    }
}
