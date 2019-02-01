package com.wsh.servlet;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OutData {
    public static String  createData(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
        String strDateTime = sdf.format(date);
        return strDateTime;
    }

    @Test
    public void asd(){
        String msg="";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
        msg = sdf.format(date);
        System.out.println(msg);
    }

}
