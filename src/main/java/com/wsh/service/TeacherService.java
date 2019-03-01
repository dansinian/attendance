package com.wsh.service;

import net.sf.json.JSONObject;

public interface TeacherService {
    JSONObject deleteTeacher(JSONObject jsonObject);
    JSONObject createTeacher(JSONObject jsonObject);
    JSONObject updateTeacher(JSONObject jsonObject);
    JSONObject selectTeacher(JSONObject jsonObject);

    JSONObject selectAllTercher();
}
