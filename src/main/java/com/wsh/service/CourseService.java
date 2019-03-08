package com.wsh.service;

import net.sf.json.JSONObject;

public interface CourseService {
    JSONObject getCourse();

    JSONObject createCourse(JSONObject jsonObject);

    String deleteCourse(JSONObject jsonObject);

    JSONObject selectCourse(JSONObject jsonObject);
}
