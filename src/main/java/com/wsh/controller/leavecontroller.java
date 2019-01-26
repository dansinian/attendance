package com.wsh.controller;


import com.wsh.entity.Leave;
import com.wsh.service.LeaveService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class Leavecontroller {
    @Autowired
    private LeaveService leaveService;


    @RequestMapping("/deleteLeave")
    @ResponseBody
    public String deleteLeave(HttpServletRequest request, HttpServletResponse response){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        String returnString = leaveService.deleteLeave(jsonObject);
        return returnString;
    }

    @RequestMapping("/createLeave")
    @ResponseBody
    public String createLeave(HttpServletRequest request, HttpServletResponse response){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = leaveService.createLeave(jsonObject);
        return returnJson.toString();
    }

    @RequestMapping("/updateLeave")
    @ResponseBody
    public String updateLeave(HttpServletRequest request, HttpServletResponse response){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = leaveService.updateLeave(jsonObject);
        return returnJson.toString();
    }

    @RequestMapping("/selectLeave")
    @ResponseBody
    public String selectLeave(HttpServletRequest request, HttpServletResponse response){
        JSONObject returnJson = new JSONObject();
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        List<Leave> leaves = leaveService.selectLeave(jsonObject);
        JSONArray leaveJson= JSONArray.fromObject(leaves);
        if (leaves!=null){
            if (leaves.size()>0){
                returnJson.put("leaves",leaveJson);
                returnJson.put("status","200");
                returnJson.put("msg","");
            }
        }else if (leaves==null||leaves.size()==0){
            returnJson.put("leaves",leaveJson);
            returnJson.put("status","500");
            returnJson.put("msg","没有查到请假信息");
        }else {
            returnJson.put("status","500");
            returnJson.put("msg","查询失败，请稍后重试");
        }
        return returnJson.toString();
    }
}
