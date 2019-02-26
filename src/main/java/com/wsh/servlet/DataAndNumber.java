package com.wsh.servlet;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataAndNumber {
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

 /*   @Test
    public void asd () throws ParseException{
        String Data = "1549351900001";
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(Data);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        System.out.println(res);
    }*/

    /*@Test
    public void qwe () throws ParseException{
        String Data = "2019-02-07 08:00:00";
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(Data);
        long ts = date.getTime();
        res = String.valueOf(ts);
        System.out.println(res);
    }*/
}

