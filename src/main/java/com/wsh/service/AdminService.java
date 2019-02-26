package com.wsh.service;

import net.sf.json.JSONObject;

public interface AdminService {
    JSONObject loginAdmin(JSONObject jsonObject) throws Exception;

    JSONObject updatePass(JSONObject jsonObject);
}
