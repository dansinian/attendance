package com.wsh.controller;

import com.wsh.servlet.FileUpAndDown;
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
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/file")
public class UploadFile {

    /**
     * 上传文件测试
     * @param files
     * @param map
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("files") MultipartFile[] files, ModelMap map){
        List<String> results = FileUpAndDown.uploadFile(files,"","");
        if(results!=null && results.size()>0){
            map.addAttribute("urls", results.get(0));
        }
        return "success";
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

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() throws IOException {
        return "Hello";
    }

}