package com.wsh.service;


import com.wsh.entity.CourseArrangement;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public interface course_arragementService {
    JSONObject deleteArrangement(JSONObject jsonObject);
    JSONObject createArrangement(JSONObject jsonObject);
    JSONObject updateArrangement(JSONObject jsonObject);
    JSONObject selectArrangement(JSONObject jsonObject);
    JSONArray selectVacationCourse(String startTime, String endTime);

    JSONObject selectAllArragement();
}
