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
import com.wsh.service.Course_arragementService;

@Controller
@RequestMapping("/arrangement")
/*
* 课程安排函数*/
public class Course_arrangementcontroller {
    @Autowired
    private Course_arragementService course_arragementService;

    @RequestMapping("/deleteArrangement")
    @ResponseBody
    public JSONObject deleteArrangement(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return course_arragementService.deleteArrangement(jsonObject);
    }

    @RequestMapping("/createArrangement")
    @ResponseBody
    public JSONObject createArrangement(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return course_arragementService.createArrangement(jsonObject);
    }

    @RequestMapping("/updateArrangement")
    @ResponseBody
    public JSONObject updateArrangement(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return course_arragementService.updateArrangement(jsonObject);
    }

    @RequestMapping("/selectArrangement")
    @ResponseBody
    public JSONObject selectArrangement(HttpServletRequest request, HttpServletResponse response)throws Exception{
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
        return returnJson;
    }
}
