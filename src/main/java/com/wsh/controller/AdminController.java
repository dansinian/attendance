
package com.wsh.controller;
import com.wsh.service.AdminService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/loginAdmin")
    @ResponseBody
    public JSONObject loginadmin(HttpServletRequest request) throws Exception{
        String jsonData = request.getParameter("data");
        return adminService.loginAdmin(JSONObject.fromObject(jsonData));
    }

    @RequestMapping("/updatePass")
    @ResponseBody
    public JSONObject updatePass(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        return adminService.updatePass(jsonObject);
    }
}

