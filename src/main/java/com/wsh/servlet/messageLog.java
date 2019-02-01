package com.wsh.servlet;


import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.Callable;

/*
* 短信接口*/
public class MessageLog implements Callable<String> {

        private static final String addr = "http://api.sms.cn/sms/";
        private static final String userId = "sprite00";
        private static final String pwd = "78e5e4babf3b5dcfdeb0db9677a3ed59";
        private static final String encode = "UTF-8";
        private String teacher;
        private String student;
        private String phone;
        public void parameter(String teacher, String student,String phone) {
                this.teacher = teacher;
                this.phone = phone;
                this.student = student;
        }

    @Override
    public String call() throws Exception {
        String straddr = addr +
                "?ac=send&uid=" + userId +
                "&pwd=" + pwd +
                "&mobile=" + phone +
                "&template=492823" +
                "&encode=" + encode +
                "&content=" + "{\"teacher\":\"" + teacher+"\"" + "," + "\"student\":\"" +student+"\"";
        StringBuffer sb = new StringBuffer(straddr);

        //发送请求
        URL url;
        String inputline = "";
        String returnString = "";
        try {
            url = new URL(sb.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream()));

            //返回结果
            inputline = in.readLine();
            JSONObject returndata = JSONObject.fromObject(inputline);
            returnString = returndata.getString("status");
            System.out.println(inputline + "a");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnString;
    }

}
