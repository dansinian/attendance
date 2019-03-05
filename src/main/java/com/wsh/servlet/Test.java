package com.wsh.servlet;


import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

public class Test {

    public static void main(String[] args) {
        JSONObject jsonData = null;

        BASE64Decoder base64 = new BASE64Decoder();
        String string ="";
        try {
            string =new String(base64.decodeBuffer("W3sidWlkIjoiM2N5YjA0emVlbW8iLCJtZXNzYWdlIjoiVXBsb2FkIGVycm9yIn1d"), "UTF-8");
        } catch (Exception e) {
            System.out.println("转码失败  ："+e);
            e.printStackTrace();
        }
        System.out.println(string);
    }
}
