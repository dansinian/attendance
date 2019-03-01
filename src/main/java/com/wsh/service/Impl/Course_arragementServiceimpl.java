package com.wsh.service.Impl;


import com.wsh.dao.CourseArrangementMapper;
import com.wsh.dao.CourseMapper;
import com.wsh.entity.Course;
import com.wsh.entity.CourseArrangement;
import com.wsh.entity.CourseArrangementExample;
import com.wsh.entity.CourseExample;
import com.wsh.service.Course_arragementService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import com.wsh.servlet.OutputWeek;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Course_arragementServiceimpl implements Course_arragementService {
    @Autowired
    private CourseArrangementMapper arragementMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public JSONObject deleteArrangement(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String arragementID = jsonObject.getString("carmId");
        String returnString ="";
        CourseArrangementExample arragementExample =new CourseArrangementExample();
        CourseArrangementExample.Criteria criteria= arragementExample.createCriteria();
        criteria.andCarmIdEqualTo(arragementID);
        int returnarragement= arragementMapper.deleteByExample(arragementExample);
        returnString = returnarragement>0?"删除成功":"删除失败";
        if ("删除成功".equals(returnString)){
            returnJson.put("status","200");
        }else {
            returnJson.put("status","500");
        }
        returnJson.put("msg",returnString);
        return returnJson;
    }

    @Override
    public JSONObject createArrangement(JSONObject jsonObject) throws ParseException {
        JSONObject returnJson = new JSONObject();
        DataAndNumber dataAndNumber = new DataAndNumber();
        CourseArrangement arragement = new CourseArrangement();
        CourseArrangementExample arragementExample = new CourseArrangementExample();
        OutData outData = new OutData();
        String carmId = outData.createData();
        carmId = dataAndNumber.dateToStamp(carmId);
        String startTime = jsonObject.getString("startTime").replace(":","");
        CourseArrangementExample.Criteria criteria = arragementExample.createCriteria();
        criteria.andCourseTimeEqualTo(startTime).andCourseIdEqualTo(jsonObject.getString("courseId"));
        List<CourseArrangement> selectArrangements = arragementMapper.selectByExample(arragementExample);
        if (selectArrangements.size() > 0) {
            returnJson.put("msg", "已存在该课程安排信息");
            returnJson.put("status", "500");
            returnJson.put("arrangement", selectArrangements.get(0));
        } else {
            arragement.setCarmId(carmId);
            arragement.setCourseId(jsonObject.getString("courseId"));
            arragement.setCourseName(jsonObject.getString("courseName"));
            arragement.setCourseWeek(jsonObject.getString("courseWeek"));
            arragement.setCourseTime(jsonObject.getString("courseTime"));
            int success = arragementMapper.insert(arragement);
            if (success > 0) {
                returnJson.put("arragement",arragement);
                returnJson.put("msg", "添加课程安排信息成功");
                returnJson.put("status", "200");
            } else {
                returnJson.put("arragement", "");
                returnJson.put("msg", "添加课程安排信息失败");
                returnJson.put("status", "500");
            }
        }
        return returnJson;
    }

    @Override
    public JSONObject updateArrangement(JSONObject jsonObject) throws Exception{
        JSONObject returnJson = new JSONObject();
        CourseArrangement arragement =new CourseArrangement();
        DataAndNumber dataAndNumber = new DataAndNumber();
        CourseArrangementExample courseExample =new CourseArrangementExample();
        String carmIdID = jsonObject.getString("arragementId");
        String courseTime = jsonObject.getString("CourseTime");
        String setTime = courseTime.replace(":","");
        CourseArrangementExample.Criteria criteria= courseExample.createCriteria();
        criteria.andCarmIdEqualTo(carmIdID);
        if (arragementMapper.selectByExample(courseExample).size()>0){
            arragement.setCarmId(carmIdID);
            arragement.setCourseId(jsonObject.getString("courseId"));
            arragement.setCourseName(jsonObject.getString("courseName"));
            arragement.setCourseWeek(jsonObject.getString("courseWeek"));
            arragement.setCourseTime(setTime);
            int returnint =arragementMapper.updateByExampleSelective(arragement,courseExample);
            if(returnint>0){
                arragement.setCourseTime(courseTime);
                returnJson.put("arragement",arragement);
                returnJson.put("msg","修改成功");
                returnJson.put("status","200");
            }else {
                returnJson.put("arragement","");
                returnJson.put("msg","修改失败");
                returnJson.put("status","500");
            }
        }else {
            returnJson.put("arragement","");
            returnJson.put("msg","没有查到该课程数据");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectArrangement(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        JSONArray returnJsarr = new JSONArray();
        DataAndNumber dataAndNumber = new DataAndNumber();
        String keyWord = jsonObject.getString("content"); // 课程的名字
        List<CourseArrangement> arrangementList =  arragementMapper.selectByCourNameLike(keyWord);
        if (arrangementList.size() >0) {
            for (int i = 0; i <arrangementList.size() ; i++) {
                StringBuffer s = new StringBuffer(arrangementList.get(i).getCourseTime());
                if (!"".equals(s)){
                    s.insert(2,":");
                    String b = new String(s);
                    arrangementList.get(i).setCourseTime(b);
                }
            }
            returnJson.put("Arrangements",arrangementList);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else {
            returnJson.put("Arrangements","");
            returnJson.put("status","500");
            returnJson.put("msg","查询失败，没有数据");
        }
        return returnJson;
    }


    @Override
    public JSONObject selectAllArragement() {
        JSONObject returnJson = new JSONObject();
        DataAndNumber dataAndNumber = new DataAndNumber();
        CourseArrangementExample arrangementExample =new CourseArrangementExample();
        CourseArrangementExample.Criteria criteria = arrangementExample.createCriteria();
        criteria.andCarmIdIsNotNull();
        List<CourseArrangement> arrangements = arragementMapper.selectByExample(arrangementExample);
        if (arrangements.size()>0){
            for (int i = 0; i <arrangements.size() ; i++) {
                StringBuffer s = new StringBuffer(arrangements.get(i).getCourseTime());
                if (!"".equals(s)){
                    s.insert(2,":");
                    String b = new String(s);
                    arrangements.get(i).setCourseTime(b);
                }
            }
            returnJson.put("Arrangements",arrangements);
            returnJson.put("msg","");
            returnJson.put("status","200");
        }else {
            returnJson.put("Arrangements","");
            returnJson.put("msg","没有查到数据");
            returnJson.put("status","500");
        }
        return returnJson;
    }
}
