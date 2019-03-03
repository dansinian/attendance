package com.wsh.service;

import net.sf.json.JSONObject;

/**
 * Created by MrDou
 * Time: 2019\3\2 0002 12:21
 */
public interface UserService {
    JSONObject deleteUser(JSONObject jsonObject);
    JSONObject createUser(JSONObject jsonObject);
    JSONObject updateUser(JSONObject jsonObject);
    JSONObject selectUser(JSONObject jsonObject);
    JSONObject selectAllUser(JSONObject jsonObject);
}
