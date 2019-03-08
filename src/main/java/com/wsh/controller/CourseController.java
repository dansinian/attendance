package com.wsh.controller;

import com.wsh.service.CourseService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public JSONObject deleteCourse(HttpServletRequest request) {
        String jsonData = request.getParameter("data");
        JSONObject retrunJson = new JSONObject();
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        String returnString = courseService.deleteCourse(jsonObject);
        if ("删除成功".equals(returnString)) {
            retrunJson.put("status", "200");
        } else {
            retrunJson.put("status", "500");
        }
        retrunJson.put("msg", returnString);
        return retrunJson;
    }

    @RequestMapping("/createCourse")
    @ResponseBody
    public JSONObject createCourse(HttpServletRequest request) {
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return courseService.createCourse(jsonObject);
    }

    @RequestMapping("/getCourse")
    @ResponseBody
    public JSONObject selectCourse() {
        return courseService.getCourse();

    }

    @RequestMapping("/selectCourse")
    @ResponseBody
    public JSONObject selectCourse(HttpServletRequest request) {
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return courseService.selectCourse(jsonObject);
    }
}
