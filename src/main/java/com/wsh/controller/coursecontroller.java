package com.wsh.controller;

import com.wsh.entity.Course;
import com.wsh.service.CourseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/course")
public class Coursecontroller {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public JSONObject deleteCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject retrunJson = new JSONObject();
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        String returnString = courseService.deleteCourse(jsonObject);
        if ("删除成功".equals(returnString)){
            retrunJson.put("status","200");
        }else {
            retrunJson.put("status","500");
        }
        retrunJson.put("msg",returnString);
        return retrunJson;
    }

    @RequestMapping("/createCourse")
    @ResponseBody
    public JSONObject createCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject retrunJson = courseService.createCourse(jsonObject);
        return retrunJson;
    }

    @RequestMapping("/updateCourse")
    @ResponseBody
    public JSONObject updateCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return courseService.updateCourse(jsonObject);
    }

    @RequestMapping("/selectCourse")
    @ResponseBody
    public JSONObject selectCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData =request.getParameter("data");
        if (!"".equals(jsonData)){
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return courseService.selectCourse(jsonObject);
        }else {
            return courseService.selectAllCourse();
        }
    }

    @RequestMapping("/selectCourseByTeacher")
    @ResponseBody
    public JSONObject selectCourseByTeacher(HttpServletRequest request, HttpServletResponse response){
        JSONObject returnJson = new JSONObject();
        String stringData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(stringData);
        JSONObject jsonData = courseService.selectCourseByTeacher(jsonObject);
        if ("".equals(jsonData.getString("Class"))){
            returnJson.put("data","");
            returnJson.put("status","500");
            returnJson.put("msg","没有查到数据");
        }else {
            returnJson.put("data",jsonData);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }
        return returnJson;
    }


}
