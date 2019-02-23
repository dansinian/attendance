package com.wsh.service.impl;


import com.wsh.dao.CourseMapper;
import com.wsh.dao.IsgocourseMapper;
import com.wsh.dao.StudentMapper;
import com.wsh.entity.Course;
import com.wsh.entity.Isgocourse;
import com.wsh.entity.IsgocourseExample;
import com.wsh.entity.Student;
import com.wsh.service.GocourseService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GocourseServiceimpl implements GocourseService {
    @Autowired
    private IsgocourseMapper gocourseMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;

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
        DataAndNumber dataAndNumber = new DataAndNumber();
        JSONObject returnJson = new JSONObject();
        String courseID = jsonObject.getString("courseID");
        Isgocourse gocourse = new Isgocourse();
        IsgocourseExample gocourseExample = new IsgocourseExample();
        IsgocourseExample.Criteria criteria = gocourseExample.createCriteria();
        criteria.andCourseIdEqualTo(courseID);
        List<Isgocourse> selectIsgocourses = gocourseMapper.selectByExample(gocourseExample);
        if (selectIsgocourses.size() > 0) {
            returnJson.put("msg", "已存在该旷课信息");
            returnJson.put("status", "500");
        } else {
            gocourse.setCourseId(courseID);
            gocourse.setStuId(jsonObject.getString("stuId"));
            gocourse.setCourseTeacher(jsonObject.getString("courseTeacher"));
            gocourse.setIsTruancy(jsonObject.getString("isTruancy"));
            gocourse.setStuClass(jsonObject.getString("stuClass"));
            gocourse.setCourseTime(dataAndNumber.stampToDate(jsonObject.getString("courseTime")));
            int success = gocourseMapper.insert(gocourse);
            if (success > 0) {
                returnJson.put("msg", "添加旷课信息成功");
                returnJson.put("status", "200");
            } else {
                returnJson.put("msg", "添加旷课信息失败");
                returnJson.put("status", "500");
            }
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

    @Override
    public JSONObject createAllStudent(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        boolean is = true;
        JSONArray students = jsonObject.getJSONArray("stuList");
        String courseId = jsonObject.getString("courseId");
        Course course = courseMapper.selectCourseById(courseId);
        String teacher = course.getTeaName();
        for (int i = 0; i < students.size(); i++) {
            JSONObject stuJson = (JSONObject) students.get(i);
            String stuID =  stuJson.getString("stuID");
            Student student = studentMapper.selectstuBystuId(stuID);
            String stuClass = student.getStuClass();
            Isgocourse gocourse = new Isgocourse();
            gocourse.setStuClass(stuClass);
            gocourse.setCourseId(courseId);
            gocourse.setCourseTeacher(teacher);
            gocourse.setIsTruancy("0");
            String date = OutData.createData();
            try {
                date = DataAndNumber.dateToStamp(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            gocourse.setCourseTime(date);
            gocourse.setStuId(stuID);
            int success = gocourseMapper.insert(gocourse);
            if (success>0) {
                is = true;
            } else {
                is = false;
                break;
            }
        }
        if (is){
            returnJson.put("msg","添加失败");
            returnJson.put("status","200");
        } else {
            returnJson.put("msg","添加成功");
            returnJson.put("status","500");
        }
        return returnJson;
    }
}
