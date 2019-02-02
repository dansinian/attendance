package com.wsh.controller;


import com.wsh.entity.Isgocourse;
import com.wsh.service.gocourseService;
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
public class isgocoursecontroller {
    @Autowired
    private gocourseService gocourseService;


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
    public String createIsgocourse(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = gocourseService.createGocourse(jsonObject);
        return returnJson.toString();
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
    public String selectIsgocourse(HttpServletRequest request, HttpServletResponse response){
        JSONObject returnJson = new JSONObject();
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        List<Isgocourse> isgocourses = gocourseService.selectGocourse(jsonObject);
        JSONArray isgocourseJson=JSONArray.fromObject(isgocourses);
        if (isgocourses!=null){
            if (isgocourses.size()>0){
                returnJson.put("isgocourses",isgocourseJson);
                returnJson.put("status","200");
                returnJson.put("msg","");
            }
        }else if (isgocourses==null||isgocourses.size()==0){
            returnJson.put("isgocourses",isgocourseJson);
            returnJson.put("status","500");
            returnJson.put("msg","没有查到旷课信息");
        }else {
            returnJson.put("status","500");
            returnJson.put("msg","查询失败，请稍后重试");
        }
        return returnJson.toString();
    }

}
