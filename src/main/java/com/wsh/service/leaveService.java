package com.wsh.service;

import net.sf.json.JSONObject;

public interface LeaveService {
    JSONObject deleteLeave(JSONObject jsonObject);
    JSONObject createLeave(JSONObject jsonObject);
    JSONObject updateLeave(JSONObject jsonObject);
    JSONObject selectLeave(JSONObject jsonObject);

    JSONObject selectAllLeave();
}
