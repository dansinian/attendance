package com.wsh.service.impl;


import com.wsh.dao.IsgocourseMapper;
import com.wsh.entity.Isgocourse;
import com.wsh.entity.IsgocourseExample;
import com.wsh.service.GocourseService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GocourseServiceimpl implements GocourseService {
    @Autowired
    private IsgocourseMapper gocourseMapper;

    @Override
    public String deleteGocourse(JSONObject jsonObject) {
        String gocourseID = jsonObject.getString("gocourseId");
        String returnString ="";
        IsgocourseExample gocourseExample =new IsgocourseExample();
        IsgocourseExample.Criteria criteria= gocourseExample.createCriteria();
        criteria.andCourseIdEqualTo(gocourseID);
        try {
            int returngocourse= gocourseMapper.deleteByExample(gocourseExample);
            if (returngocourse>0){
                returnString = "删除成功";
            }
        }catch (Exception e){
            returnString = "删除失败";
        }
        return returnString;
    }

    @Override
    public JSONObject createGocourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String gocourseID = jsonObject.getString("gocourseId");
        Isgocourse gocourse = new Isgocourse();
        IsgocourseExample gocourseExample = new IsgocourseExample();
        IsgocourseExample.Criteria criteria = gocourseExample.createCriteria();
        criteria.andCourseIdEqualTo(gocourseID);
        List<Isgocourse> selectIsgocourses = gocourseMapper.selectByExample(gocourseExample);
        try {
            if (selectIsgocourses.size() > 0) {
                returnJson.put("msg", "已存在该旷课信息");
                returnJson.put("status", "500");
                returnJson.put("gocourse", selectIsgocourses.get(0));
            } else {
                gocourse.setCourseId(gocourseID);
                gocourse.setStuId(jsonObject.getString("student_id"));
                gocourse.setCourseTeacher(jsonObject.getString("courseTeacherId"));
                gocourse.setIsTruancy(jsonObject.getString("isTruancy"));
                gocourseMapper.insert(gocourse);
                List<Isgocourse> returnIsgocourses = gocourseMapper.selectByExample(gocourseExample);
                if (returnIsgocourses.size() > 0) {
                    returnJson.put("gocourse", returnIsgocourses.get(0));
                    returnJson.put("msg", "添加旷课信息成功");
                    returnJson.put("status", "200");
                } else {
                    returnJson.put("gocourse", "");
                    returnJson.put("msg", "添加旷课信息失败");
                    returnJson.put("status", "500");
                }
            }
        } catch (Exception e) {
            returnJson.put("gocourse", "");
            returnJson.put("msg", "添加旷课信息失败");
            returnJson.put("status", "500");
        }
        return returnJson;
    }
    @Override
    public JSONObject updateGocourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String gocourseID = jsonObject.getString("gocourseId");
        Isgocourse gocourse =new Isgocourse();
        IsgocourseExample courseExample =new IsgocourseExample();
        IsgocourseExample.Criteria criteria= courseExample.createCriteria();
        criteria.andCourseIdEqualTo(gocourseID);
        try {
            if (gocourseMapper.selectByExample(courseExample).size()>0){
                gocourse.setCourseId(gocourseID);
                gocourse.setStuId(jsonObject.getString("student_id"));
                gocourse.setCourseTeacher(jsonObject.getString("courseTeacherId"));
                gocourse.setIsTruancy(jsonObject.getString("isTruancy"));
                int returnint =gocourseMapper.updateByExampleSelective(gocourse,courseExample);
                if(returnint>0){
                    returnJson.put("gocourse",gocourse);
                    returnJson.put("msg","修改成功");
                    returnJson.put("status","200");
                }else {
                    returnJson.put("gocourse","");
                    returnJson.put("msg","修改失败");
                    returnJson.put("status","500");
                }
            }else {
                returnJson.put("gocourse","");
                returnJson.put("msg","没有查到该课程数据");
                returnJson.put("status","500");
            }
        }catch (Exception e){
            returnJson.put("gocourse","");
            returnJson.put("msg","修改失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public List<Isgocourse> selectGocourse(JSONObject jsonObject) {
        String keyWord = jsonObject.getString("content");
        String type = jsonObject.getString("type");
        List<Isgocourse> gocourses =new ArrayList<Isgocourse>();
        return gocourses;
    }
}
