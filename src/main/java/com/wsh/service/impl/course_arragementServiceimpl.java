package com.wsh.service.impl;


import com.wsh.dao.CourseArrangementMapper;
import com.wsh.dao.CourseMapper;
import com.wsh.entity.Course;
import com.wsh.entity.CourseArrangement;
import com.wsh.entity.CourseArrangementExample;
import com.wsh.entity.CourseExample;
import com.wsh.service.Course_arragementService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class course_arragementServiceimpl implements Course_arragementService {
    @Autowired
    private CourseArrangementMapper arragementMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public String deleteArrangement(JSONObject jsonObject) {
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
        return returnString;
    }

    @Override
    public JSONObject createArrangement(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String arragementID = jsonObject.getString("arragementId");
        CourseArrangement arragement = new CourseArrangement();
        CourseArrangementExample arragementExample = new CourseArrangementExample();
        CourseArrangementExample.Criteria criteria = arragementExample.createCriteria();
        criteria.andCarmIdEqualTo(arragementID);
        List<CourseArrangement> selectArrangements = arragementMapper.selectByExample(arragementExample);
        try {
            if (selectArrangements.size() > 0) {
                returnJson.put("msg", "已存在该课程安排信息");
                returnJson.put("status", "500");
                returnJson.put("arragement", selectArrangements.get(0));
            } else {
                arragement.setCarmId(arragementID);
                arragement.setCarmTime(jsonObject.getString("carmTime"));
                arragement.setCourseId(jsonObject.getString("courseId"));
                arragementMapper.insert(arragement);
                List<CourseArrangement> returnArrangements = arragementMapper.selectByExample(arragementExample);
                if (returnArrangements.size() > 0) {
                    returnJson.put("arragement", returnArrangements.get(0));
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
    public JSONObject updateArrangement(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String arragementID = jsonObject.getString("arragementId");
        CourseArrangement arragement =new CourseArrangement();
        CourseArrangementExample courseExample =new CourseArrangementExample();
        CourseArrangementExample.Criteria criteria= courseExample.createCriteria();
        criteria.andCarmIdEqualTo(arragementID);
        try {
            if (arragementMapper.selectByExample(courseExample).size()>0){
                arragement.setCarmId(arragementID);
                arragement.setCarmTime(jsonObject.getString("carmTime"));
                arragement.setCourseId(jsonObject.getString("courseId"));
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
        }catch (Exception e){
            returnJson.put("arragement","");
            returnJson.put("msg","修改失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public List<CourseArrangement> selectArrangement(JSONObject jsonObject) {
        String keyWord = jsonObject.getString("content"); // 课程的名字
        String content = "%"+keyWord+"%";
        List<CourseArrangement> arrangements =new ArrayList<CourseArrangement>();
        CourseExample courseExample = new CourseExample();
        CourseArrangementExample arrangementExample =new CourseArrangementExample();
        CourseExample.Criteria courseCriteria = courseExample.createCriteria();
        CourseArrangementExample.Criteria criteria= arrangementExample.createCriteria();
        courseCriteria.andCourseNameLike(content);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        if (courses != null && courses.size() >0) {
            for (int i = 0; i < courses.size(); i++) {
               String courseId =  courses.get(i).getCourseId();
                criteria.andCourseIdEqualTo(courseId);
                List<CourseArrangement> arrangementList =  arragementMapper.selectByExample(arrangementExample);
                if (arrangementList.get(i) != null) {
                    arrangements.set(i,arrangementList.get(i));
                }
            }
        }
        return arrangements;
    }
}
