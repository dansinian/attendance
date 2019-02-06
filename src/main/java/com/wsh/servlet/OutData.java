package com.wsh.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OutData {
    public static String  createData(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
        String strDateTime = sdf.format(date);
        return strDateTime;
    }

}
