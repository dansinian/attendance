package com.wsh.service;


import com.wsh.entity.CourseArrangement;
import net.sf.json.JSONObject;

import java.util.List;

public interface course_arragementService {
    String deleteArrangement(JSONObject jsonObject);
    JSONObject createArrangement(JSONObject jsonObject);
    JSONObject updateArrangement(JSONObject jsonObject);
    List<CourseArrangement> selectArrangement(JSONObject jsonObject);
}
