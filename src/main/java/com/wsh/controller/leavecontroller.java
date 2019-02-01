package com.wsh.controller;


import com.wsh.service.LeaveService;
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
public class Leavecontroller {
    @Autowired
    private LeaveService leaveService;


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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String jsonData = /*request.getParameter("data")*/ "{\"StuId\":\"2511150406\",\"StuName\":\"窦超\",\"applicationTime\":\"20190131\",\"startTime\":\"20190210\",\"endTime\":\"20190220\",\"leaveDay\":\"9\",\"leaveCourseTea\":\"小臭臭\",\"leaveReason\":\"生病了\",\"approvalTea\":\"小臭臭\"}";
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
