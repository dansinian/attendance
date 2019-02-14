package com.wsh.service.impl;


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
        try {
            int returnarragement= arragementMapper.deleteByExample(arragementExample);
            returnString = returnarragement>0?"删除成功":"删除失败";
        }catch (Exception e){
            returnString = "删除失败";
        }
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
        String endTime = jsonObject.getString("endTime").replace(":","");
        CourseArrangementExample.Criteria criteria = arragementExample.createCriteria();
        criteria.andStartTimeEqualTo(startTime).andCourseIdEqualTo(jsonObject.getString("courseId")).andEndTimeEqualTo(endTime);
        List<CourseArrangement> selectArrangements = arragementMapper.selectByExample(arragementExample);
        try {
            if (selectArrangements.size() > 0) {
                returnJson.put("msg", "已存在该课程安排信息");
                returnJson.put("status", "500");
                returnJson.put("arrangement", selectArrangements.get(0));
            } else {
                arragement.setCarmId(carmId);
                arragement.setCourseId(jsonObject.getString("courseId"));
                arragement.setCourseName(jsonObject.getString("courseName"));
                arragement.setCourseWeek(jsonObject.getString("courseWeek"));
                arragement.setStartTime(startTime);
                arragement.setEndTime(endTime);
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
        } catch (Exception e) {
            returnJson.put("arragement", "");
            returnJson.put("msg", "添加课程安排信息失败");
            returnJson.put("status", "500");
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
        CourseArrangementExample.Criteria criteria= courseExample.createCriteria();
        criteria.andCarmIdEqualTo(carmIdID);
        if (arragementMapper.selectByExample(courseExample).size()>0){
            arragement.setCarmId(carmIdID);
            arragement.setCourseId(jsonObject.getString("courseId"));
            arragement.setCourseName(jsonObject.getString("courseName"));
            arragement.setCourseWeek(jsonObject.getString("courseWeek"));
            arragement.setStartTime(jsonObject.getString("startTime").replace(":",""));
            arragement.setEndTime(jsonObject.getString("endTime").replace(":",""));
            int returnint =arragementMapper.updateByExampleSelective(arragement,courseExample);
            if(returnint>0){
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
                StringBuffer s = new StringBuffer(arrangementList.get(i).getStartTime());
                s.insert(2,":");
                String b = new String(s);
                arrangementList.get(i).setStartTime(b);
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
    public List<CourseArrangement> selectVacationCourse(String startTime, String endTime) throws ParseException {
        OutputWeek outputWeek = new OutputWeek();
        DataAndNumber dataAndNumber = new DataAndNumber();
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        List<CourseArrangement> arrans = new ArrayList<CourseArrangement>();
        String startDate = dataAndNumber.stampToDate(startTime);
        String endDate = dataAndNumber.stampToDate(endTime);
        startDate = startDate.substring(11, 13);
        String a = startDate.substring(14, 16);
        endDate = endDate.substring(11, 13);
        String b = endDate.substring(14, 16);
        startDate = startTime + a;
        endTime = endTime + b;
        CourseArrangementExample arrangementExample =new CourseArrangementExample();
        CourseArrangementExample.Criteria criteria = arrangementExample.createCriteria();
        JSONObject startJson = outputWeek.OutputWeek(startTime);
        JSONObject endJson = outputWeek.OutputWeek(endTime);
        int m = startJson.getInt("int");
        int n = endJson.getInt("int");
            for (int i = n; i < m; i++) {
                criteria.andCourseWeekEqualTo(weekDays[i]).andStartTimeGreaterThanOrEqualTo(startDate).andEndTimeLessThanOrEqualTo(endDate);
                List<CourseArrangement> arrangements = arragementMapper.selectByExample(arrangementExample);
                if (arrangements.size()>0){
                        arrans.addAll(arrangements);
                }
            }
        return arrans;
    }

    @Override
    public JSONObject selectAllArragement() {
        JSONObject returnJson = new JSONObject();
        DataAndNumber dataAndNumber = new DataAndNumber();
        CourseArrangementExample arrangementExample =new CourseArrangementExample();
        CourseArrangementExample.Criteria criteria = arrangementExample.createCriteria();
        criteria.andIdIsNotNull();
        List<CourseArrangement> arrangements = arragementMapper.selectByExample(arrangementExample);
        if (arrangements.size()>0){
            for (int i = 0; i <arrangements.size() ; i++) {
                StringBuffer s = new StringBuffer(arrangements.get(i).getStartTime());
                s.insert(2,":");
                String b = new String(s);
                arrangements.get(i).setStartTime(b);
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
