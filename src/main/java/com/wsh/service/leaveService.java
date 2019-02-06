package com.wsh.service;

import net.sf.json.JSONObject;

public interface LeaveService {
    JSONObject deleteLeave(JSONObject jsonObject);
    JSONObject createLeave(JSONObject jsonObject) throws Exception;
    JSONObject updateLeave(JSONObject jsonObject) throws Exception;
    JSONObject selectLeave(JSONObject jsonObject);

    JSONObject selectAllLeave();

    JSONObject callTeacher(JSONObject jsonObject);
}
