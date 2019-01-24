package com.wsh.controller;

import com.wsh.entity.Course;
import com.wsh.service.courseService;
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
@RequestMapping("/course")
public class coursecontroller {
    @Autowired
    private courseService courseService;

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public String deleteCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
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
        return retrunJson.toString();
    }

    @RequestMapping("/createCourse")
    @ResponseBody
    public String createCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject retrunJson = courseService.createCourse(jsonObject);
        return retrunJson.toString();
    }

    @RequestMapping("/updateCourse")
    @ResponseBody
    public void updateCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject retrunJson = courseService.updateCourse(jsonObject);
        response.getWriter().print(retrunJson);
    }

    @RequestMapping("/selectCourse")
    @ResponseBody
    public String selectCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        JSONObject returnJson = new JSONObject();
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        List<Course> courses = courseService.selectCourse(jsonObject);
        JSONArray courseJson=JSONArray.fromObject(courses);
        if (courses!=null){
            if (courses.size()>0){
                returnJson.put("courses",courseJson);
                returnJson.put("status","200");
                returnJson.put("msg","");
            }
        }else if (courses==null || courses.size()==0){
            returnJson.put("courses",courseJson);
            returnJson.put("status","500");
            returnJson.put("msg","没有查到课程数据");
        }else {
            returnJson.put("status","500");
            returnJson.put("msg","查询失败，请稍后重试");
        }
        return returnJson.toString();
    }
}
