package com.wsh.service;

import com.wsh.entity.Course;
import net.sf.json.JSONObject;

import java.text.ParseException;
import java.util.List;

public interface CourseService {
    String deleteCourse(JSONObject jsonObject);
    JSONObject createCourse(JSONObject jsonObject) throws ParseException;
    JSONObject updateCourse(JSONObject jsonObject);
    JSONObject selectCourse(JSONObject jsonObject);
    JSONObject selectCourseByTeacher(JSONObject jsonObject);
    JSONObject selectAllCourse();
/*
    JSONObject selectByAdmin(JSONObject jsonObject);
*/
}
