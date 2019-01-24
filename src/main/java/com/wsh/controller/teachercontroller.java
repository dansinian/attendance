package com.wsh.controller;

import com.wsh.entity.Teacher;
import com.wsh.service.teacherService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class teachercontroller {
    @Autowired
    private teacherService teacherService;


    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public String deleteTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        String returnString = teacherService.deleteTeacher(jsonObject);
        return returnString;
    }

    @RequestMapping("/createTeacher")
    @ResponseBody
    public String createTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = teacherService.createTeacher(jsonObject);
        return returnJson.toString();
    }

    @RequestMapping("/updateTeacher")
    @ResponseBody
    public String updateTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = teacherService.updateTeacher(jsonObject);
        return returnJson.toString();
    }

    @RequestMapping("/selectTeacher")
    @ResponseBody
    public String selectTeacher(HttpServletRequest request, HttpServletResponse response){
        JSONObject returnJson = new JSONObject();
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        List<Teacher> teachers = teacherService.selectTeacher(jsonObject);
        JSONArray teacherJson=JSONArray.fromObject(teachers);
        if (teachers!=null){
            if (teachers.size()>0){
                returnJson.put("teachers",teacherJson);
                returnJson.put("status","200");
                returnJson.put("msg","");
            }
        }else if (teachers==null||teachers.size()==0){
            returnJson.put("teachers",teacherJson);
            returnJson.put("status","500");
            returnJson.put("msg","没有查到教师信息");
        }else {
            returnJson.put("status","500");
            returnJson.put("msg","查询失败，请稍后重试");
        }
        return returnJson.toString();
    }


}
