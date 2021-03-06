package com.wsh.controller;

import com.wsh.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public void saveuser(HttpServletRequest request, HttpServletResponse response) throws Exception{
    }
    @RequestMapping("/loginUser")
    @ResponseBody
    public JSONObject loginuser(HttpServletRequest request, HttpServletResponse response) throws Exception{

        HttpSession session = request.getSession();
        String jsonData = request.getParameter("data");
        JSONObject returnjson = userService.loginUser(JSONObject.fromObject(jsonData));
        if ("200".equals(returnjson.getString("status"))){
            session.setAttribute("person",returnjson.getJSONObject(returnjson.getString("type")));
        }
        return returnjson;
    }

    @RequestMapping("/updatePass")
    @ResponseBody
    public JSONObject updatePass(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return userService.updatePass(jsonObject);
    }
}
