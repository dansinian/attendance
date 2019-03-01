package com.wsh.controller;

import com.wsh.service.CommentReplyService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/commentReply")
public class CommentReplyController {
    @Autowired
    private CommentReplyService replyService;

    @RequestMapping("/deleteCommentReply")
    @ResponseBody
    public JSONObject deleteCommentReoly(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return replyService.deleteConmmentReply(jsonObject);
    }

    @RequestMapping("/createCommentReply")
    @ResponseBody
    public JSONObject createCommentReply(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = replyService.createConmmentReply(jsonObject);
        return returnJson;
    }

    @RequestMapping("/selectCommentReply")
    @ResponseBody
    public JSONObject selectCommentReply(HttpServletRequest request){
        String jsonData = request.getParameter("data");
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return replyService.selectConmmentReply(jsonObject);
    }

    @RequestMapping("/selectReplyed")
    @ResponseBody
    public JSONObject selectReplyed(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return replyService.selectReplyed(jsonObject);
    }
}
