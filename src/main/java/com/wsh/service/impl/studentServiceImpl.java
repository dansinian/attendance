package com.wsh.service.impl;

import com.wsh.dao.StudentMapper;
import com.wsh.entity.Student;
import com.wsh.entity.StudentExample;
import com.wsh.service.StudentService;
import com.wsh.servlet.IsChOrEnOrNum;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JSONObject deleteStudent(JSONObject jsonObject) {
        String courseID = jsonObject.getString("courseID");
        JSONObject returnJSon = new JSONObject();
        StudentExample courseExample =new StudentExample();
        StudentExample.Criteria criteria= courseExample.createCriteria();
        criteria.andStuIdEqualTo(courseID);
        try {
            int returncourse= studentMapper.deleteByExample(courseExample);
            if (returncourse>0){
                returnJSon.put("msg","删除成功");
                returnJSon.put("status","200");
            } else {
                returnJSon.put("msg","删除失败");
                returnJSon.put("status","500");
            }
        }catch (Exception e){
            returnJSon.put("msg","删除失败");
            returnJSon.put("status","500");
        }
        return returnJSon;
    }

    @Override
    public JSONObject createStudent(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String studentID = jsonObject.getString("studentId");
        Student student =new Student();
        StudentExample courseExample =new StudentExample();
        StudentExample.Criteria criteria= courseExample.createCriteria();
        criteria.andStuIdEqualTo(studentID);
        List<Student> selectCourses = studentMapper.selectByExample(courseExample);
        try {
            if (selectCourses.size()>0){
                returnJson.put("msg","已存在该学生信息");
                returnJson.put("status","500");
                returnJson.put("student", selectCourses.get(0));
            } else {
                student.setStuId(studentID);
                student.setStuName(jsonObject.getString("studentName"));
                student.setStuGender(jsonObject.getString("studentGender"));
                student.setStuIdentity(jsonObject.getString("studentIdentity"));
                student.setStuPhone(jsonObject.getString("studentPhone"));
                student.setStuClass(jsonObject.getString("studentClass"));
                student.setStuMajor(jsonObject.getString("studentMajor"));
                student.setStuDepartment(jsonObject.getString("studentDepartment"));
                student.setTeaName(jsonObject.getString("teacherName"));
                student.setStuPassword(jsonObject.getString("studentPassword"));
                student.setStuFlag(jsonObject.getString("studentFlag"));
                student.setSchedule(jsonObject.getString("schedule")); //需要字符串转数组
                studentMapper.insert(student);
                List<Student> returnStudents = studentMapper.selectByExample(courseExample);
                if (returnStudents.size()>0){
                    returnJson.put("student", returnStudents.get(0));
                    returnJson.put("msg", "添加学生信息成功");
                    returnJson.put("status", "200");
                } else {
                    returnJson.put("student", "");
                    returnJson.put("msg","添加学生信息失败");
                    returnJson.put("status","500");
                }
            }
        }catch (Exception e) {
            returnJson.put("student", "");
            returnJson.put("msg","添加学生信息失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject updateStudent(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String studentID = jsonObject.getString("studentId");
        Student student =new Student();
        StudentExample courseExample =new StudentExample();
        StudentExample.Criteria criteria= courseExample.createCriteria();
        criteria.andStuIdEqualTo(studentID);
        try {
            if (studentMapper.selectByExample(courseExample).size()>0){
                student.setStuId(studentID);
                student.setStuName(jsonObject.getString("studentName"));
                student.setStuGender(jsonObject.getString("studentGender"));
                student.setStuIdentity(jsonObject.getString("studentIdentity"));
                student.setStuPhone(jsonObject.getString("studentPhone"));
                student.setStuClass(jsonObject.getString("studentClass"));
                student.setStuMajor(jsonObject.getString("studentMajor"));
                student.setStuDepartment(jsonObject.getString("studentDepartment"));
                student.setTeaName(jsonObject.getString("teacherName"));
                student.setStuPassword(jsonObject.getString("studentPassword"));
                student.setStuFlag(jsonObject.getString("studentFlag"));
                student.setSchedule(jsonObject.getString("schedule"));
                int returnint =studentMapper.updateByExampleSelective(student,courseExample);
                if(returnint>0){
                    returnJson.put("student",student);
                    returnJson.put("msg","修改成功");
                    returnJson.put("status","200");
                }else {
                    returnJson.put("student","");
                    returnJson.put("msg","修改失败");
                    returnJson.put("status","500");
                }
            }else {
                returnJson.put("student","");
                returnJson.put("msg","没有查到该课程数据");
                returnJson.put("status","500");
            }
        }catch (Exception e){
            returnJson.put("student","");
            returnJson.put("msg","修改失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public List<Student> selectStudent (JSONObject jsonObject) {
        String keyWord = jsonObject.getString("content");
        String Keytype = IsChOrEnOrNum.IsChOrNum(keyWord);
        String content = "%"+keyWord+"%";
        List<Student> students =new ArrayList<Student>();
        StudentExample courseExample =new StudentExample();
        StudentExample.Criteria criteria= courseExample.createCriteria();
        try {
            if ("chinese".equals(Keytype)){
                criteria.andStuNameLike(content);
                students = studentMapper.selectByExample(courseExample);
                if (students.size()==0){
                    criteria.andStuClassLike(content);
                    students = studentMapper.selectByExample(courseExample);
                }
            } else {
                criteria.andStuIdLike(content);
                students = studentMapper.selectByExample(courseExample);
            }
        }catch (Exception e){
            return null;
        }

        return students;
    }

}
