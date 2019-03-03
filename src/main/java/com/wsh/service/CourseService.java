package com.wsh.service;

import net.sf.json.JSONObject;

public interface CourseService {
    JSONObject selectCourse(JSONObject jsonObject);

    JSONObject createCourse(JSONObject jsonObject);

    String deleteCourse(JSONObject jsonObject);
}
