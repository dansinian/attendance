package com.wsh.service.Impl;

import com.wsh.dao.CourseArrangementMapper;
import com.wsh.dao.CourseMapper;
import com.wsh.entity.Course;
import com.wsh.entity.CourseArrangement;
import com.wsh.entity.CourseArrangementExample;
import com.wsh.entity.CourseExample;
import com.wsh.service.CourseService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseArrangementMapper arrangementMapper;

    @Override
    public String deleteCourse(JSONObject jsonObject) {
        String courseID = jsonObject.getString("courseId");
        String returnString ="";
        CourseExample courseExample =new CourseExample();
        CourseArrangementExample courseArrangementExample = new CourseArrangementExample();
        CourseExample.Criteria criteria= courseExample.createCriteria();
        CourseArrangementExample.Criteria criteria1=courseArrangementExample.createCriteria();
        criteria.andCourseIdEqualTo(courseID);
        criteria1.andCourseIdEqualTo(courseID);
            int returncourse= courseMapper.deleteByExample(courseExample);
            List<CourseArrangement> courseArrangements = arrangementMapper.selectByExample(courseArrangementExample);
            if (courseArrangements.size()>0){
                arrangementMapper.deleteByExample(courseArrangementExample);
            }
            if (returncourse>0){
                returnString = "删除成功";
            }
        return returnString;
    }

    @Override
    public JSONObject createCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String courseID = null;
        try {
            courseID = DataAndNumber.dateToStamp(OutData.createData());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Course course =new Course();

       Course course1 = courseMapper.selectByPrimaryKey(courseID);
            if (course1 != null){
                returnJson.put("msg","已存在该课程");
                returnJson.put("status","500");
                returnJson.put("course", course1);
            } else {
                course.setCourseId(courseID);
                course.setCourseName(jsonObject.getString("courseName"));
                course.setTeaName(jsonObject.getString("teaName"));
                course.setCourseClass(jsonObject.getString("courseClass"));
                course.setCourseMajor(jsonObject.getString("courseMajor"));
                course.setCourseDepartment(jsonObject.getString("courseDepartment"));
                course.setCourseDetail(jsonObject.getString("courseDetail"));
                int success = courseMapper.insert(course);
                if (success > 0){
                    returnJson.put("course", course);
                    returnJson.put("msg", "添加课程成功");
                    returnJson.put("status", "200");
                } else {
                    returnJson.put("course", "");
                    returnJson.put("msg","添加课程失败");
                    returnJson.put("status","500");
                }
            }
        return returnJson;
    }

    @Override
    public JSONObject updateCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String courseID = jsonObject.getString("courseId");
        Course course =new Course();
        if (courseMapper.selectByPrimaryKey(courseID) != null){
            course.setCourseId(courseID);
            course.setCourseName(jsonObject.getString("courseName"));
            course.setTeaName(jsonObject.getString("teaName"));
            course.setCourseClass(jsonObject.getString("courseClass"));
            course.setCourseMajor(jsonObject.getString("courseMajor"));
            course.setCourseDepartment(jsonObject.getString("courseDepartment"));
            course.setCourseDetail(jsonObject.getString("courseDetail"));
            int returnint =courseMapper.updateByPrimaryKeySelective(course);
            if(returnint>0){
                returnJson.put("course",course);
                returnJson.put("msg","修改成功");
                returnJson.put("status","200");
            }else {
                returnJson.put("course","");
                returnJson.put("msg","修改失败");
                returnJson.put("status","500");
            }
        }else {
            returnJson.put("course","");
            returnJson.put("msg","没有查到该课程数据");
            returnJson.put("status","500");
        }
        return returnJson;
    }


    @Override
    public JSONObject selectCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String courName = jsonObject.getString("courseName");
        List<Course> course = courseMapper.selectByNameLike(courName);
        if (course.size()>0){
            returnJson.put("courses",course);
            returnJson.put("status","200");
            returnJson.put("msg","");
        } else {
            returnJson.put("courses","");
            returnJson.put("status","500");
            returnJson.put("msg","没有查到课程数据");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectAllCourse() {
        JSONObject returnJson = new JSONObject();
        CourseExample courseExample =new CourseExample();
        CourseExample.Criteria criteria= courseExample.createCriteria();
        criteria.andCourseIdIsNotNull();
        List<Course> courses = courseMapper.selectByExample(courseExample);
        if (courses.size()>0){
            returnJson.put("courses",courses);
            returnJson.put("status","200");
            returnJson.put("msg","");
        } else{
            returnJson.put("courses","");
            returnJson.put("status","500");
            returnJson.put("msg","没有查到课程数据");
        }
        return returnJson;
    }
}
