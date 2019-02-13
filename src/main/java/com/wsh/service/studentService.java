package com.wsh.service;

import com.wsh.entity.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.ParseException;
import java.util.List;

public interface StudentService {
    JSONObject deleteStudent(JSONObject jsonObject);
    JSONObject createStudent(JSONObject jsonObject);
    JSONObject updateStudent(JSONObject jsonObject);
    JSONObject selectStudent(JSONObject jsonObject);
    JSONObject selectAllStudent();
    JSONObject selectByTeacher(JSONObject jsonObject) throws ParseException;
    JSONObject report(JSONObject jsonObject) throws ParseException;
    JSONObject selectReportStudent(JSONObject jsonObject) throws ParseException;
}
