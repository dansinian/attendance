package com.wsh.controller;


import com.wsh.entity.CourseArrangement;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.wsh.service.course_arragementService;

@Controller
@RequestMapping("/arrangement")
/*
* 课程安排函数*/
public class course_arrangementcontroller {
    @Autowired
    private course_arragementService course_arragementService;

    @RequestMapping("/deleteArrangement")
    @ResponseBody
    public String deleteArrangement(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject retrunJson = new JSONObject();
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        String returnString = course_arragementService.deleteArrangement(jsonObject);
        if ("删除成功".equals(returnString)){
            retrunJson.put("status","200");
        }else {
            retrunJson.put("status","500");
        }
        retrunJson.put("msg",returnString);
        return retrunJson.toString();
    }

    @RequestMapping("/createArrangement")
    @ResponseBody
    public String createArrangement(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject retrunJson = course_arragementService.createArrangement(jsonObject);
        return retrunJson.toString();
    }

    @RequestMapping("/updateArrangement")
    @ResponseBody
    public void updateArrangement(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject retrunJson = course_arragementService.updateArrangement(jsonObject);
        response.getWriter().print(retrunJson);
    }

    @RequestMapping("/selectArrangement")
    @ResponseBody
    public String selectArrangement(HttpServletRequest request, HttpServletResponse response)throws Exception{
        JSONObject returnJson = new JSONObject();
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        List<CourseArrangement> course_arrangements = course_arragementService.selectArrangement(jsonObject);
        JSONArray course_arrangementJson=JSONArray.fromObject(course_arrangements);
        if (course_arrangements!=null){
            if (course_arrangements.size()>0){
                returnJson.put("Arrangements",course_arrangementJson);
                returnJson.put("status","200");
                returnJson.put("msg","");
            }
        }else if (course_arrangements==null || course_arrangements.size()==0){
            returnJson.put("Arrangements",course_arrangementJson);
            returnJson.put("status","500");
            returnJson.put("msg","没有查到课程安排数据");
        }else {
            returnJson.put("Arrangements","");
            returnJson.put("status","500");
            returnJson.put("msg","查询失败，请稍后重试");
        }
        return returnJson.toString();
    }
}
