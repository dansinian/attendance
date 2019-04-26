package com.wsh.controller;

import com.wsh.service.UserService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.FileUpAndDown;
import com.wsh.servlet.OutData;
import com.wsh.servlet.ReadExcel;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class UploadFile {
    @Autowired
    private UserService userService;
    /**
     * 上传文件测试
     * @param files
     * @param map
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map upload(@RequestParam("files") MultipartFile[] files, ModelMap map){
        String fileName = "";
        try {
            fileName = DataAndNumber.dateToStamp(OutData.createData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> results = FileUpAndDown.uploadFile(files,"",fileName);
        if(results!=null && results.size()>0){
            map.addAttribute("urls", results.get(0));
        }
        return map;
    }

    /**
     * 下载文件测试
     * @param url
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/download")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(@RequestParam("url")String url,HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("utf-8");
        return FileUpAndDown.downloadFile(url,"下载的文件"+ url.substring(url.lastIndexOf(".")));
    }

}