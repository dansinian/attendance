package com.wsh.controller;


import com.wsh.service.UserService;
import com.wsh.servlet.ReadExcel;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelRead {
    @Autowired
    private UserService userService;

    @RequestMapping("/readExcel")
    @ResponseBody
    public JSONObject readExcel1(@RequestParam("file") File file){
        JSONObject returnJson = new JSONObject();
        List excelList = ReadExcel.readExcel(file);
        if (excelList.size() > 0) {
            returnJson =  userService.addStuddents(excelList);
        } else {
            returnJson.put("msg","ExcelÎª¿Õ");
            returnJson.put("status","500");
        }
        return returnJson;

    }
}
