package com.wsh.controller;

import com.wsh.service.userService;
import net.sf.json.JSONObject;
import com.wsh.servlet.messageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class usercontroller {
    @Autowired
    private userService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public void saveuser(HttpServletRequest request, HttpServletResponse response) throws Exception{
        messageLog messageLog = new messageLog();
        messageLog.parameter("窦超","苏丹丹","15129489109");
        Thread message =new Thread(messageLog);
        message.start();
    }

    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginuser(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        String jsonData = request.getParameter("data");
        JSONObject returnjson = userService.loginUser(JSONObject.fromObject(jsonData));
        session.setAttribute("person",returnjson.getJSONObject(returnjson.getString("type")));
        return returnjson.toString();
    }
}
