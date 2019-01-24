package com.wsh.service;

import com.wsh.entity.Student;
import net.sf.json.JSONObject;

import java.util.List;

public interface studentService {
    String deleteStudent(JSONObject jsonObject);
    JSONObject createStudent(JSONObject jsonObject);
    JSONObject updateStudent(JSONObject jsonObject);
    List<Student> selectStudent(JSONObject jsonObject);

}
