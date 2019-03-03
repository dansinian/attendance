package com.wsh.controller;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/upload")
public class UploadHeadImg {

    @RequestMapping("/uploadImg")
    @ResponseBody
    public JSONObject uploadHeadImage(@RequestParam("file") MultipartFile file) throws IOException {
        Assert.notNull(file, "上传文件不能为空");
        String src="/plug-in/images/people/";
        //String path = request.getSession().getServletContext().getRealPath("/"+src);
        String path="D:/IDEAWorkspance/forum/src/main/webapp/userhead";
        JSONObject json = new JSONObject();
        //System.currentTimeMillis()根据系统时间产生随机数，保证上传的图片名字不一样
        String name=System.currentTimeMillis()+file.getOriginalFilename();
        File dir = new File(path, name);
        src=src+name;
        if (!dir.exists()) {
            dir.mkdirs();
            json.put("msg","上传成功");
            json.put("status","200");
            json.put("src",src);
        } else {
            json.put("msg","上传失败");
            json.put("status","500");
        }
        file.transferTo(dir);
        return json;
    }
}
