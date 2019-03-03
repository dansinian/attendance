package com.wsh.controller;

import com.wsh.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MrDou
 * Time: 2019\3\2 0002 12:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/deleteUser")
    @ResponseBody
    public JSONObject deleteUser(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return userService.deleteUser(jsonObject);
    }

    @RequestMapping("/createUser")
    @ResponseBody
    public JSONObject createUser(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return userService.createUser(jsonObject);

    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public JSONObject updateUser(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return userService.updateUser(jsonObject);
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public JSONObject selectUser(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return userService.selectUser(jsonObject);
    }
    @RequestMapping("/selectAllUser")
    @ResponseBody
    public JSONObject selectAllUser(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return userService.selectAllUser(jsonObject);
    }
}
