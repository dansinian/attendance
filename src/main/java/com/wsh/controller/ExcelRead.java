package com.wsh.controller;


import com.wsh.service.UserService;
import com.wsh.servlet.ReadExcel;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelRead {
    @Autowired
    private UserService userService;

    @RequestMapping("/readExcel")
    @ResponseBody
    public JSONObject readExcel1(HttpServletRequest request){
        String jsonData = "{\"fileUrl\":\"D:\\\\IDEAworkspance\\\\forum\\\\src\\\\main\\\\webapp\\\\userhead\\\\user.xls\"}"/*request.getParameter("data")*/;
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        JSONObject returnJson = new JSONObject();
        String fileUrl = jsonObject.optString("fileUrl");
        File file = new File(fileUrl);
        try{
            List excelList = ReadExcel.readExcel(file);
            if (excelList.size() > 0 && !"导入失败".equals(excelList.get(0))) {
                returnJson =  userService.addStuddents(excelList);
            } else {
                returnJson.put("msg","导入失败");
                returnJson.put("status","500");
            }
        }catch (Exception e) {
            returnJson.put("msg","导入失败");
            returnJson.put("status","500");
        }

        return returnJson;

    }
}
