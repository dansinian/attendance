package com.wsh.service;

import net.sf.json.JSONObject;

public interface CourseService {
    JSONObject selectCourse();

    JSONObject createCourse(JSONObject jsonObject);

    String deleteCourse(JSONObject jsonObject);
}
