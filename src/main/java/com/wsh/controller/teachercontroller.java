package com.wsh.controller;

import com.wsh.entity.Teacher;
import com.wsh.service.teacherService;
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
@RequestMapping("/teacher")
public class teachercontroller {
    @Autowired
    private teacherService teacherService;


    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public JSONObject deleteTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return teacherService.deleteTeacher(jsonObject);
    }

    @RequestMapping("/createTeacher")
    @ResponseBody
    public JSONObject createTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return teacherService.createTeacher(jsonObject);
    }

    @RequestMapping("/updateTeacher")
    @ResponseBody
    public JSONObject updateTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return teacherService.updateTeacher(jsonObject);
    }

    @RequestMapping("/selectTeacher")
    @ResponseBody
    public JSONObject selectTeacher(HttpServletRequest request, HttpServletResponse response){
        String jsonData = request.getParameter("data");
        if ("".equals(jsonData)){
            return teacherService.selectAllTercher();
        } else {
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            return teacherService.selectTeacher(jsonObject);
        }
    }


}
