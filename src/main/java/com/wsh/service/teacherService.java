package com.wsh.service;

import com.wsh.entity.Teacher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.List;

public interface TeacherService {
    JSONObject deleteTeacher(JSONObject jsonObject);
    JSONObject createTeacher(JSONObject jsonObject);
    JSONObject updateTeacher(JSONObject jsonObject);
    JSONObject selectTeacher(JSONObject jsonObject);

    JSONObject selectAllTercher();
}
