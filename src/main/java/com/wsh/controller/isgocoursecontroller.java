package com.wsh.controller;


import com.wsh.entity.Isgocourse;
import com.wsh.service.GocourseService;
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
@RequestMapping("/goCourse")
public class Isgocoursecontroller {
    @Autowired
    private GocourseService gocourseService;


    @RequestMapping("/deletegocourse")
    @ResponseBody
    public String deleteIsgocourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        String returnString = gocourseService.deleteGocourse(jsonObject);
        return returnString;
    }

    @RequestMapping("/creategocourse")
    @ResponseBody
    public JSONObject createIsgocourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = gocourseService.createGocourse(jsonObject);
        return returnJson;
    }

    @RequestMapping("/updategocourse")
    @ResponseBody
    public String updateIsgocourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = gocourseService.updateGocourse(jsonObject);
        return returnJson.toString();
    }

    @RequestMapping("/selectgocourse")
    @ResponseBody
    public JSONObject selectIsgocourse(HttpServletRequest request, HttpServletResponse response){
        JSONObject returnJson = new JSONObject();
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        List<Isgocourse> isgocourses = gocourseService.selectGocourse(jsonObject);
        if (isgocourses.size()>0){
            returnJson.put("isgocourses",isgocourses);
            returnJson.put("status","200");
            returnJson.put("msg","");
        } else {
        returnJson.put("isgocourses","");
        returnJson.put("status","500");
        returnJson.put("msg","没有查到旷课信息");
        }
        return returnJson;
    }

    @RequestMapping("/createAllStudent")
    @ResponseBody
    public JSONObject createAllStudent(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return gocourseService.createAllStudent(jsonObject);
    }

}
