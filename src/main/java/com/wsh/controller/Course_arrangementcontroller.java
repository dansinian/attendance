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
    public JSONObject deleteArrangement(HttpServletRequest request)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return course_arragementService.deleteArrangement(jsonObject);
    }

    @RequestMapping("/createArrangement")
    @ResponseBody
    public JSONObject createArrangement(HttpServletRequest request)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return course_arragementService.createArrangement(jsonObject);
    }

    @RequestMapping("/updateArrangement")
    @ResponseBody
    public JSONObject updateArrangement(HttpServletRequest request)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return course_arragementService.updateArrangement(jsonObject);
    }

    @RequestMapping("/selectArrangement")
    @ResponseBody
    public JSONObject selectArrangement(HttpServletRequest request)throws Exception{
        String jsonData = request.getParameter("data");
        if (!"".equals(jsonData)){
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return course_arragementService.selectArrangement(jsonObject);
        }else {
            return course_arragementService.selectAllArragement();
        }
    }
}
