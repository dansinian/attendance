package com.wsh.service.Impl;

import com.wsh.dao.CourseMapper;
import com.wsh.entity.Course;
import com.wsh.entity.CourseExample;
import com.wsh.service.CourseService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public String deleteCourse(JSONObject jsonObject) {
        String department = jsonObject.getString("department");
        String major= jsonObject.getString("major");
        String course= jsonObject.getString("course");
        String returnString ="";
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andDepartmentEqualTo(department).andMajorEqualTo(major).andCourseEqualTo(course);
        int success = courseMapper.deleteByExample(courseExample);
        if (success > 0) {
            returnString = "删除成功";
        } else {
            returnString = "删除失败";
        }
        return returnString;
    }

    @Override
    public JSONObject createCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String department = jsonObject.getString("department");
        String major= jsonObject.getString("major");
        String courseName= jsonObject.getString("course");
        Course course = new Course();
        course.setDepartment(department);
        course.setMajor(major);
        course.setCourse(courseName);
         int success =courseMapper.insertSelective(course);
        if (success > 0 ){
                returnJson.put("msg","已存在该课程");
                returnJson.put("status","500");
                returnJson.put("course", course);
            } else {
                    returnJson.put("course", "");
                    returnJson.put("msg","添加课程失败");
                    returnJson.put("status","500");
            }
        return returnJson;
    }

    @Override
    public JSONObject selectCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCouIdIsNotNull();
        List<Course>course = courseMapper.selectByExample(courseExample);
        if (course.size() > 0){
            List depart = new ArrayList();
            /*得到所有不同的院系*/
            for (int i = 0; i < course.size(); i++) {
                String courseDep = course.get(i).getDepartment();
                if (!depart.contains(courseDep)) {
                    depart.add(courseDep);
                }
            }
            for (int i = 0; i < depart.size(); i++) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("department",depart.get(i));
                for (int j = 0; j < course.size(); j++) {
                    if (depart.get(i).equals(course.get(j).getDepartment())){
                        String major = course.get(j).getMajor();

                        JSONArray jsonArray1 = new JSONArray();
                        for (int k = 0; k < course.size(); k++) {
                            if (major.equals(course.get(k).getMajor())) {
                                jsonArray1.add(course.get(k).getCourse());
                            }
                            jsonObject1.put(major,jsonArray1);
                        }
                    }
                }
                jsonArray.add(jsonObject1);
            }
            returnJson.put("courses",jsonArray);
            returnJson.put("status","200");
            returnJson.put("msg","");
        } else {
            returnJson.put("courses","");
            returnJson.put("status","500");
            returnJson.put("msg","没有数据");
        }
        return returnJson;
    }

}
