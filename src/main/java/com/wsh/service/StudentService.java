package com.wsh.service;

import net.sf.json.JSONObject;

import java.text.ParseException;

public interface StudentService {
    JSONObject deleteStudent(JSONObject jsonObject);
    JSONObject createStudent(JSONObject jsonObject);
    JSONObject updateStudent(JSONObject jsonObject);
    JSONObject selectStudent(JSONObject jsonObject);
    JSONObject selectAllStudent();
}
