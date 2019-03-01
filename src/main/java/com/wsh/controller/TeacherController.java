package com.wsh.controller;

import com.wsh.service.TeacherService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public JSONObject deleteTeacher(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return teacherService.deleteTeacher(jsonObject);
    }

    @RequestMapping("/createTeacher")
    @ResponseBody
    public JSONObject createTeacher(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return teacherService.createTeacher(jsonObject);
    }

    @RequestMapping("/updateTeacher")
    @ResponseBody
    public JSONObject updateTeacher(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return teacherService.updateTeacher(jsonObject);
    }

    @RequestMapping("/selectTeacher")
    @ResponseBody
    public JSONObject selectTeacher(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        if ("".equals(jsonData)){
            return teacherService.selectAllTercher();
        } else {
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return teacherService.selectTeacher(jsonObject);
        }
    }
}
