package com.wsh.service;

import com.wsh.entity.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public interface studentService {
    JSONObject deleteStudent(JSONObject jsonObject);
    JSONObject createStudent(JSONObject jsonObject);
    JSONObject updateStudent(JSONObject jsonObject);
    JSONObject selectStudent(JSONObject jsonObject);

    JSONObject selectAllStudent();
}
