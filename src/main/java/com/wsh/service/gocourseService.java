package com.wsh.service;


import com.wsh.entity.Isgocourse;
import net.sf.json.JSONObject;

import java.util.List;

public interface GocourseService {
    String deleteGocourse(JSONObject jsonObject);
    JSONObject createGocourse(JSONObject jsonObject);
    JSONObject updateGocourse(JSONObject jsonObject);
    List<Isgocourse> selectGocourse(JSONObject jsonObject);

    JSONObject createAllStudent(JSONObject jsonObject);
}
