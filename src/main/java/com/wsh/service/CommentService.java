package com.wsh.service;

import net.sf.json.JSONObject;

public interface CommentService {
    JSONObject deleteConmment(JSONObject jsonObject);
    JSONObject createConmment(JSONObject jsonObject);
    JSONObject selectConmment(JSONObject jsonObject);
    JSONObject selectAllConmment();
}
