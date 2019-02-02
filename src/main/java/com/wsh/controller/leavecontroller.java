package com.wsh.controller;


import com.wsh.service.leaveService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/leave")
public class leavecontroller {
    @Autowired
    private leaveService leaveService;


    @RequestMapping("/deleteLeave")
    @ResponseBody
    public JSONObject deleteLeave(HttpServletRequest request, HttpServletResponse response){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return leaveService.deleteLeave(jsonObject);
    }

    @RequestMapping("/createLeave")
    @ResponseBody
    public JSONObject createLeave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonData = request.getParameter("data") ;
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return leaveService.createLeave(jsonObject);
    }

    @RequestMapping("/updateLeave")
    @ResponseBody
    public JSONObject updateLeave(HttpServletRequest request, HttpServletResponse response){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return leaveService.updateLeave(jsonObject);
    }

    @RequestMapping("/selectLeave")
    @ResponseBody
    public JSONObject selectLeave(HttpServletRequest request, HttpServletResponse response){
        String jsonData = /*request.getParameter("data")*/ "\"content\":\"200\"";
        if ("".equals(jsonData) || jsonData == null){
            return leaveService.selectAllLeave();
        }else {
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return leaveService.selectLeave(jsonObject);
        }
    }
}
