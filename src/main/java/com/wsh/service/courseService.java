package com.wsh.service;

import com.wsh.entity.Course;
import net.sf.json.JSONObject;

import java.util.List;

public interface CourseService {
    String deleteCourse(JSONObject jsonObject);
    JSONObject createCourse(JSONObject jsonObject);
    JSONObject updateCourse(JSONObject jsonObject);
    List<Course> selectCourse(JSONObject jsonObject);
}
