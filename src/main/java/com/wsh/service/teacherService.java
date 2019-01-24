package com.wsh.service;

import com.wsh.entity.Teacher;
import net.sf.json.JSONObject;

import java.util.List;

public interface teacherService {
    String deleteTeacher(JSONObject jsonObject);
    JSONObject createTeacher(JSONObject jsonObject);
    JSONObject updateTeacher(JSONObject jsonObject);
    List<Teacher> selectTeacher(JSONObject jsonObject);
}
