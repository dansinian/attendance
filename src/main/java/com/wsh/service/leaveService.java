package com.wsh.service;

import com.wsh.entity.Leave;
import net.sf.json.JSONObject;

import java.util.List;

public interface LeaveService {
    String deleteLeave(JSONObject jsonObject);
    JSONObject createLeave(JSONObject jsonObject);
    JSONObject updateLeave(JSONObject jsonObject);
    List<Leave> selectLeave(JSONObject jsonObject);
}
