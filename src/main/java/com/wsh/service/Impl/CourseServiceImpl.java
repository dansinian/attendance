package com.wsh.service.Impl;

import com.wsh.dao.CourseMapper;
import com.wsh.entity.Course;
import com.wsh.entity.CourseExample;
import com.wsh.service.CourseService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import com.wsh.servlet.SortList;
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
    public JSONObject selectCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String content = jsonObject.getString("content");
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andMajorEqualTo(content);
        List<Course> courses = new ArrayList<>();
        courses = courseMapper.selectByMajorLike(content);
        if (courses.size() == 0 ) {
            courses = courseMapper.selectByTeacherLike(content);
        }
        if (courses.size() > 0){
            returnJson.put("msg","");
            returnJson.put("status","200");
            returnJson.put("course",courses);
        } else {
            returnJson.put("msg","没有数据");
            returnJson.put("status","500");
        }
        return returnJson;
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
        course.setCourseTeacher(jsonObject.getString("courseTeacher"));
        course.setCourseFile(jsonObject.optString("courseFile"));
        int success =courseMapper.insertSelective(course);
        if (success > 0 ) {
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
    public JSONObject getCourse() {
        JSONObject returnJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCouIdIsNotNull();
        List<Course> course = courseMapper.selectByExample(courseExample);
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
                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray1 = new JSONArray();
                String Depart = depart.get(i).toString();
                List major = courseMapper.selectMajorByDepart(Depart);
                SortList.removeDuplicate(major);
                for (int j = 0; j < major.size(); j++) {
                    JSONObject jsonObject1 = new JSONObject();
                    String majorName = major.get(j).toString();
                    List courses = courseMapper.selectCourseByDepartAndMajor(Depart,majorName);
                    SortList.removeDuplicate(courses);
                    JSONArray jsonArray2 = new JSONArray();
                    for (int k = 0; k < courses.size(); k++) {
                        JSONObject jsonObject2 = new JSONObject();
                        String coursename = courses.get(k).toString();
                        String teacher = courseMapper.selectCourseTeacher(Depart,majorName,coursename);
                        jsonObject2.put(coursename,teacher);
                        jsonArray2.add(jsonObject2);
                    }
                    jsonObject1.put(majorName,jsonArray2);
                    jsonArray1.add(jsonObject1);
                }
                jsonObject.put("major",jsonArray1);
                jsonObject.put("department",Depart);
                jsonArray.add(jsonObject);
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
