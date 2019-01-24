package com.wsh.service;
import net.sf.json.JSONObject;


public interface userService {
    /*Map<String, String> saveUser(JSONObject jsonObject);*/
    JSONObject loginUser(JSONObject jsonObject) throws Exception;
}
