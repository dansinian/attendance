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
import java.util.List;

@Controller
@RequestMapping("/course")
public class Coursecontroller {
    @Autowired
    private CourseService courseService;

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
    public JSONObject selectCourse(HttpServletRequest request, HttpServletResponse response)throws Exception{ //具体查询或者全部查询 参数data为null或"" 是全部查询
        String jsonData =request.getParameter("data");
        if (!"".equals(jsonData) && jsonData!=null){
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return courseService.selectCourse(jsonObject);
        }else {
            return courseService.selectAllCourse();
        }
    }

    @RequestMapping("/selectCourseByTeacher")
    @ResponseBody
    public JSONObject selectCourseByTeacher(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonData = new JSONObject();
        String stringData = /*request.getParameter("data");*/ " {\"teacherId\":\"2511150329\",\"password\":\"123456\",\"type\":\"teacher\"}";
        JSONObject jsonObject = JSONObject.fromObject(stringData);
        String teacherId =  jsonObject.getString("teacherId");
        if (teacherId !=null && !"".equals(teacherId)){
            JSONObject returnJson = courseService.selectCourseByTeacher(jsonObject);
            jsonData.put("data",returnJson);
            jsonData.put("status","200");
            jsonData.put("msg","");
        } else {
            jsonData.put("data",null);
            jsonData.put("msg","teacherId为空,无法查询");
            jsonData.put("status","500");
        }
        return jsonData;
    }
}
