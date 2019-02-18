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
import java.text.ParseException;
import java.util.List;


@Controller
@RequestMapping("/student")
public class Studentcontroller {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/deleteStudent")
        @ResponseBody
        public JSONObject deleteStudent(HttpServletRequest request, HttpServletResponse response){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return studentService.deleteStudent(jsonObject);
        }

        @RequestMapping("/createStudent")
        @ResponseBody
        public JSONObject createStudent(HttpServletRequest request, HttpServletResponse response){
            String jsonData = request.getParameter("data");
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            JSONObject returnJson = studentService.createStudent(jsonObject);
            return returnJson;
        }

        @RequestMapping("/updateStudent")
        @ResponseBody
        public JSONObject updateStudent(HttpServletRequest request, HttpServletResponse response){
            String jsonData = request.getParameter("data");
            JSONObject jsonObject = JSONObject.fromObject(jsonData);
            JSONObject returnJson = studentService.updateStudent(jsonObject);
            return returnJson;
        }

        @RequestMapping("/selectStudent")
        @ResponseBody
        public JSONObject selectStudent(HttpServletRequest request, HttpServletResponse response){
            String jsonData = request.getParameter("data");
            if (!"".equals(jsonData)){
                JSONObject jsonObject = JSONObject.fromObject(jsonData);
                return studentService.selectStudent(jsonObject);
            } else {
                return studentService.selectAllStudent();
            }
        }

    @RequestMapping("/selectStudentByTeacher")
    @ResponseBody
    public JSONObject selectStudentByTeacher(HttpServletRequest request, HttpServletResponse response){
        String jsonData =request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return studentService.selectByTeacher(jsonObject);
    }
    @RequestMapping("/report")
    @ResponseBody
    public JSONObject report(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String jsonData =request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return studentService.report(jsonObject);
    }

    @RequestMapping("/selectReportStudent")
    @ResponseBody
    public JSONObject selectReportStudent(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String jsonData =request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return studentService.selectReportStudent(jsonObject);
    }

    @RequestMapping("/selectWeekReport")
    @ResponseBody
    public JSONObject selectWeekReport(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return studentService.selectWeekReport(jsonObject);
    }

}
