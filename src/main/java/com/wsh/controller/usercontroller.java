package com.wsh.controller;

import com.wsh.service.UserService;
import net.sf.json.JSONObject;
import com.wsh.servlet.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.FutureTask;

@Controller
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public void saveuser(HttpServletRequest request, HttpServletResponse response) throws Exception{
        MessageLog messageLog = new MessageLog();
        messageLog.parameter("窦超","苏丹丹","15129489109");
        FutureTask<String> ft = new FutureTask<String>(messageLog);
        Thread message =new Thread(ft);
        message.start();
    }
   // @CrossOrigin(methods = RequestMethod.POST)
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

   // @CrossOrigin(methods = RequestMethod.POST)
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String s = request.getParameter("test");
        return s;
    }
}
