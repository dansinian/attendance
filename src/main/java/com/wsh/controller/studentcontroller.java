package com.wsh.controller;

import com.wsh.entity.Student;
import com.wsh.service.StudentService;
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
@RequestMapping("/student")
public class Studentcontroller {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/deleteStudent")
        @ResponseBody
        public String deleteStudent(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        String returnString = studentService.deleteStudent(jsonObject);
        return returnString;
        }

        @RequestMapping("/createStudent")
        @ResponseBody
        public String createStudent(HttpServletRequest request, HttpServletResponse response)throws Exception{
            String jsonData = request.getParameter("data");
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            JSONObject returnJson = studentService.createStudent(jsonObject);
            return returnJson.toString();
        }

        @RequestMapping("/updateStudent")
        @ResponseBody
        public String updateStudent(HttpServletRequest request, HttpServletResponse response)throws Exception{
            String jsonData = request.getParameter("data");
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            JSONObject returnJson = studentService.updateStudent(jsonObject);
            return returnJson.toString();

        }

        @RequestMapping("/selectStudent")
        @ResponseBody
        public String selectStudent(HttpServletRequest request, HttpServletResponse response)throws Exception{
            JSONObject returnJson = new JSONObject();
            String jsonData = request.getParameter("data");
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            List<Student> teachers = studentService.selectStudent(jsonObject);
            JSONArray courseJson=JSONArray.fromObject(teachers);
            if (teachers!=null){
                if (teachers.size()>0){
                    returnJson.put("courses",courseJson);
                    returnJson.put("status","200");
                    returnJson.put("msg","");
                }
            }else if (teachers==null||teachers.size()==0){
                returnJson.put("courses",courseJson);
                returnJson.put("status","500");
                returnJson.put("msg","没有查到学生信息");
            }else {
                returnJson.put("status","500");
                returnJson.put("msg","查询失败，请稍后重试");
            }
            return returnJson.toString();

        }

}
