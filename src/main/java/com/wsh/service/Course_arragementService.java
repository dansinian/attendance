package com.wsh.service;


import com.wsh.entity.CourseArrangement;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.ParseException;
import java.util.List;

public interface Course_arragementService {
    JSONObject deleteArrangement(JSONObject jsonObject);
    JSONObject createArrangement(JSONObject jsonObject) throws ParseException;
    JSONObject updateArrangement(JSONObject jsonObject) throws Exception;
    JSONObject selectArrangement(JSONObject jsonObject);
    JSONObject selectAllArragement();
}
