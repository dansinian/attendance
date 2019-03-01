package com.wsh.service;
import net.sf.json.JSONObject;


public interface StudentService {
    JSONObject deleteStudent(JSONObject jsonObject);
    JSONObject createStudent(JSONObject jsonObject);
    JSONObject updateStudent(JSONObject jsonObject);
    JSONObject selectStudent(JSONObject jsonObject);
    JSONObject selectAllStudent();
}
