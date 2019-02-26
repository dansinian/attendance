package com.wsh.servlet;

import net.sf.json.JSONObject;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
* 调用这个方法 接收值只可以是时间戳形式*/
public class OutputWeek {
    public static JSONObject OutputWeek(String date) throws ParseException {
        JSONObject returnJson = new JSONObject();
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        if (date.equals("")) {
            cal.setTime(new Date(System.currentTimeMillis()));
        }else {
            cal.setTime(new Date(getDateByStr2(date).getTime()));
        }
        int w =  cal.get(Calendar.DAY_OF_WEEK) - 1;
        String weekday = weekDays[w];
        returnJson.put("week",weekday);
        returnJson.put("int",w);
        return returnJson;
    }

    public static Date getDateByStr2(String dd)
    {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sd.parse(dd);
        } catch (ParseException e) {
            date = null;
            e.printStackTrace();
        }
        return date;
    }

    /*public void adsasd() throws ParseException {
        String date = "2019-2-13";
        DataAndNumber dataAndNumber = new DataAndNumber();
        date = dataAndNumber.stampToDate(date);
        System.out.println(date);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        if (date.equals("")) {
            cal.setTime(new Date(System.currentTimeMillis()));
        }else {
            cal.setTime(new Date(getDateByStr2(date).getTime()));
        }
        int w =  cal.get(Calendar.DAY_OF_WEEK) - 1;
        String weekday = weekDays[w];
        System.out.println(weekday);
    }*/

}
