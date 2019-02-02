package com.wsh.service;

import com.wsh.entity.Course;
import net.sf.json.JSONObject;

import java.util.List;

public interface courseService {
    String deleteCourse(JSONObject jsonObject);
    JSONObject createCourse(JSONObject jsonObject);
    JSONObject updateCourse(JSONObject jsonObject);
    JSONObject selectCourse(JSONObject jsonObject);
    JSONObject selectCourseByTeacher(JSONObject jsonObject);
    JSONObject selectAllCourse();
}
