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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
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
        String arragementID = jsonObject.getString("arragementId");
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
        CourseArrangement arragement = new CourseArrangement();
        OutData outData = new OutData();
        DataAndNumber dataAndNumber = new DataAndNumber();
        CourseArrangementExample arragementExample = new CourseArrangementExample();
        String arragementID = dataAndNumber.dateToStamp(OutData.createData());
        CourseArrangementExample.Criteria criteria = arragementExample.createCriteria();
        criteria.andCarmIdEqualTo(arragementID);
        List<CourseArrangement> selectArrangements = arragementMapper.selectByExample(arragementExample);
        try {
            if (selectArrangements.size() > 0) {
                returnJson.put("msg", "已存在该课程安排信息");
                returnJson.put("status", "500");
                returnJson.put("arrangement", selectArrangements.get(0));
            } else {
                arragement.setCarmId(arragementID);
                arragement.setCarmTime(jsonObject.getString("carmTime"));
                arragement.setCourseId(jsonObject.getString("courseId"));
                arragement.setCourseId(jsonObject.getString("courseName"));
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
        String arragementID = jsonObject.getString("arragementId");
        CourseArrangementExample.Criteria criteria= courseExample.createCriteria();
        criteria.andCarmIdEqualTo(arragementID);
        if (arragementMapper.selectByExample(courseExample).size()>0){
            arragement.setCarmId(arragementID);
            arragement.setCarmTime(dataAndNumber.dateToStamp(jsonObject.getString("carmTime")));
            arragement.setCourseId(jsonObject.getString("courseId"));
            int returnint =arragementMapper.updateByExampleSelective(arragement,courseExample);
            if(returnint>0){
                arragement.setCarmTime(jsonObject.getString("carmTime"));
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
        List<CourseArrangement> arrangements =new ArrayList<CourseArrangement>();
        List<CourseArrangement> arrangementList =  arragementMapper.selectByCourNameLike(keyWord);
        if (arrangementList.size() >0) {
            for (int i = 0; i < arrangementList.size(); i++) {
                arrangementList.get(i).setCarmTime(dataAndNumber.stampToDate(arrangementList.get(i).getCarmTime()));
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
    public List<CourseArrangement> selectVacationCourse(String startTime, String endTime) {
        CourseArrangementExample arrangementExample =new CourseArrangementExample();
        CourseArrangementExample.Criteria criteria = arrangementExample.createCriteria();
        criteria.andCarmTimeBetween(startTime,endTime);
        List<CourseArrangement> arrangements = arragementMapper.selectByExample(arrangementExample);
        return arrangements;
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
            for (int i = 0; i < arrangements.size(); i++) {
                arrangements.get(i).setCarmTime(dataAndNumber.stampToDate(arrangements.get(i).getCarmTime()));
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
