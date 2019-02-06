package com.wsh.service.impl;


import com.wsh.dao.CourseArrangementMapper;
import com.wsh.dao.CourseMapper;
import com.wsh.dao.StudentMapper;
import com.wsh.dao.TeacherMapper;
import com.wsh.entity.*;
import com.wsh.service.CourseService;
import com.wsh.servlet.OutData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseArrangementMapper courseArrangementMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;

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
        try {
            int returncourse= courseMapper.deleteByExample(courseExample);
            List<CourseArrangement> courseArrangements = courseArrangementMapper.selectByExample(courseArrangementExample);
            if (courseArrangements.size()>0){
                courseArrangementMapper.deleteByExample(courseArrangementExample);
            }
            if (returncourse>0){
                returnString = "删除成功";
            }
        }catch (Exception e){
            returnString = "删除失败";
        }
        return returnString;
    }

    @Override
    public JSONObject createCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String courseID = OutData.createData();
        Course course =new Course();
        CourseExample courseExample =new CourseExample();
        CourseExample.Criteria criteria= courseExample.createCriteria();
        criteria.andCourseIdEqualTo(courseID);
        List<Course> selectCourses = courseMapper.selectByExample(courseExample);
        try {
            if (selectCourses.size()>0){
                returnJson.put("msg","已存在该课程");
                returnJson.put("status","500");
                returnJson.put("course", selectCourses.get(0));
            } else {
                course.setCourseId(courseID);
                course.setCourseName(jsonObject.getString("courseName"));
                course.setTeaName(jsonObject.getString("teaName"));
                course.setCourseClass(jsonObject.getString("courseClass"));
                course.setCourseMajor(jsonObject.getString("courseMajor"));
                course.setCourseDepartment(jsonObject.getString("courseDepartment"));
                courseMapper.insert(course);
                List<Course> returnCourses = courseMapper.selectByExample(courseExample);
                if (returnCourses.size()>0){
                    returnJson.put("course", returnCourses.get(0));
                    returnJson.put("msg", "添加课程成功");
                    returnJson.put("status", "200");
                } else {
                    returnJson.put("course", "");
                    returnJson.put("msg","添加课程失败");
                    returnJson.put("status","500");
                }
            }
        }catch (Exception e) {
            returnJson.put("course", "");
            returnJson.put("msg","添加课程失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject updateCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String courseID = jsonObject.getString("courseId");
        Course course =new Course();
        CourseExample courseExample =new CourseExample();
        CourseExample.Criteria criteria= courseExample.createCriteria();
        criteria.andCourseIdEqualTo(courseID);
        try {
            if (courseMapper.selectByExample(courseExample).size()>0){
                course.setCourseId(jsonObject.getString("courseId"));
                course.setCourseName(jsonObject.getString("courseName"));
                course.setTeaName(jsonObject.getString("teaName"));
                course.setCourseClass(jsonObject.getString("courseClass"));
                course.setCourseMajor(jsonObject.getString("courseMajor"));
                course.setCourseDepartment(jsonObject.getString("courseDepartment"));
                int returnint =courseMapper.updateByExampleSelective(course,courseExample);
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
        }catch (Exception e){
            returnJson.put("course","");
            returnJson.put("msg","修改失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }


    @Override
    public JSONObject selectCourse(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String keyWord = jsonObject.getString("content");
        List<Course> courses = courseMapper.selectByMajorLike(keyWord);
            if (courses.size()>0){
                returnJson.put("courses",courses);
                returnJson.put("status","200");
                returnJson.put("msg","");
            } else{
                List<Course> course = courseMapper.selectByNameLike(keyWord);
                if (course.size()>0){
                    returnJson.put("courses",course);
                    returnJson.put("status","200");
                    returnJson.put("msg","");
                } else {
                    returnJson.put("courses","");
                    returnJson.put("status","500");
                    returnJson.put("msg","没有查到课程数据");
                }
        }
        return returnJson;
    }

    @Override
    public JSONObject selectCourseByTeacher(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String searchKey = jsonObject.getString("teacherName");
        CourseExample courseExample =new CourseExample();
        CourseExample.Criteria criteria= courseExample.createCriteria();
        criteria.andTeaNameEqualTo(searchKey);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        ArrayList<String> courseName = new ArrayList<String>();
        if (courses.size()>0){
            for (int i = 0; i < courses.size(); i++) {
                courseName.add(courses.get(i).getCourseName());
            }
            returnJson.put("course",courseName);
        }else {
            returnJson.put("course","");
        }
        List<Teacher> teachers = teacherMapper.selectTeaNameLike(searchKey);
        JSONArray arraylevel1 = new JSONArray();
        if (teachers.size()>0){
            for (int k = 0; k <teachers.size(); k++) {
                String Class = teachers.get(k).getTeaClass();
                Class.replaceAll("，",",");
                returnJson.put("teacherName",teachers.get(k).getTeaName());
                String teaClass[] = Class.split(",");
                if (teaClass.length>0){
                    for (int i = 0; i < teaClass.length; i++) {
                        JSONObject stuLevel2 = new JSONObject();
                        JSONArray arraylevel3 = new JSONArray();
                        StudentExample studentExample = new StudentExample();
                        StudentExample.Criteria stucriteria = studentExample.createCriteria();
                        stucriteria.andStuClassEqualTo(teaClass[i]);
                        List<Student> students = studentMapper.selectByExample(studentExample);
                        if (students.size()>0){
                            for (int j = 0; j < students.size(); j++) {
                                JSONObject stulevel3 = new JSONObject();
                                stulevel3.put("name",students.get(j).getStuName());
                                stulevel3.put("studentID",students.get(j).getStuId());
                                arraylevel3.add(stulevel3);
                            }
                        }else {
                            stuLevel2.put("Student","");
                        }
                        stuLevel2.put("Student",arraylevel3);
                        stuLevel2.put("teaClass",teaClass[i]);
                        arraylevel1.add(stuLevel2);
                    }
                    returnJson.put("Class",arraylevel1);
                } else {
                    returnJson.put("Class","");
                }
            }
        }else {
            returnJson.put("Class","");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectAllCourse() {
        JSONObject returnJson = new JSONObject();
        CourseExample courseExample =new CourseExample();
        CourseExample.Criteria criteria= courseExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Course> courses = courseMapper.selectByExample(courseExample);
        if (courses.size()>0){
            JSONArray courseJson= JSONArray.fromObject(courses);
            returnJson.put("courses",courseJson);
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
