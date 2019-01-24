package com.wsh.service.impl;

import com.wsh.servlet.IsChOrEnOrNum;
import com.wsh.dao.TeacherMapper;
import com.wsh.entity.Teacher;
import com.wsh.entity.TeacherExample;
import com.wsh.service.teacherService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class teacherServiceimpl implements teacherService {
    private TeacherMapper teacherMapper;

    @Override
    public String deleteTeacher(JSONObject jsonObject) {
        String teacherID = jsonObject.getString("teacherId");
        String returnString ="";
        TeacherExample teacherExample =new TeacherExample();
        TeacherExample.Criteria criteria= teacherExample.createCriteria();
        criteria.andTeaIdEqualTo(teacherID);
        try {
            int returnteacher= teacherMapper.deleteByExample(teacherExample);
            if (returnteacher>0){
                returnString = "删除成功";
            }
        }catch (Exception e){
            returnString = "删除失败";
        }
        return returnString;
    }

    @Override
    public JSONObject createTeacher(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String teacherID = jsonObject.getString("teacherId");
        Teacher teacher = new Teacher();
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeaIdEqualTo(teacherID);
        List<Teacher> selectTeachers = teacherMapper.selectByExample(teacherExample);
        try {
            if (selectTeachers.size() > 0) {
                returnJson.put("msg", "已存在该教师信息");
                returnJson.put("status", "500");
                returnJson.put("teacher", selectTeachers.get(0));
            } else {
                teacher.setTeaId(teacherID);
                teacher.setTeaName(jsonObject.getString("teacherName"));
                teacher.setTeaGender(jsonObject.getString("teacherGender"));
                teacher.setTeaDepartment(jsonObject.getString("teacherDepartment"));
                teacher.setTeaPhone(jsonObject.getString("teacherPhone"));
                teacher.setTeaClass(jsonObject.getString("teacherClass"));
                teacher.setTeaPassword(jsonObject.getString("teacherPassword"));
                teacher.setTeaFlag(jsonObject.getString("teacherFlag"));
                teacherMapper.insert(teacher);
                List<Teacher> returnTeachers = teacherMapper.selectByExample(teacherExample);
                if (returnTeachers.size() > 0) {
                    returnJson.put("teacher", returnTeachers.get(0));
                    returnJson.put("msg", "添加教师信息成功");
                    returnJson.put("status", "200");
                } else {
                    returnJson.put("teacher", "");
                    returnJson.put("msg", "添加教师信息失败");
                    returnJson.put("status", "500");
                }
            }
        } catch (Exception e) {
            returnJson.put("teacher", "");
            returnJson.put("msg", "添加教师信息失败");
            returnJson.put("status", "500");
        }
        return returnJson;
    }
    @Override
    public JSONObject updateTeacher(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String teacherID = jsonObject.getString("teacherId");
        Teacher teacher =new Teacher();
        TeacherExample courseExample =new TeacherExample();
        TeacherExample.Criteria criteria= courseExample.createCriteria();
        criteria.andTeaIdEqualTo(teacherID);
        try {
            if (teacherMapper.selectByExample(courseExample).size()>0){
                teacher.setTeaId(teacherID);
                teacher.setTeaName(jsonObject.getString("teacherName"));
                teacher.setTeaGender(jsonObject.getString("teacherGender"));
                teacher.setTeaDepartment(jsonObject.getString("teacherDepartment"));
                teacher.setTeaPhone(jsonObject.getString("teacherPhone"));
                teacher.setTeaClass(jsonObject.getString("teacherClass"));
                teacher.setTeaPassword(jsonObject.getString("teacherPassword"));
                teacher.setTeaFlag(jsonObject.getString("teacherFlag"));
                int returnint =teacherMapper.updateByExampleSelective(teacher,courseExample);
                if(returnint>0){
                    returnJson.put("teacher",teacher);
                    returnJson.put("msg","修改成功");
                    returnJson.put("status","200");
                }else {
                    returnJson.put("teacher","");
                    returnJson.put("msg","修改失败");
                    returnJson.put("status","500");
                }
            }else {
                returnJson.put("teacher","");
                returnJson.put("msg","没有查到该课程数据");
                returnJson.put("status","500");
            }
        }catch (Exception e){
            returnJson.put("teacher","");
            returnJson.put("msg","修改失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public List<Teacher> selectTeacher(JSONObject jsonObject) {
        String keyWord = jsonObject.getString("content");
        String type = jsonObject.getString("type");
        String content = "%"+keyWord+"%";
        List<Teacher> teachers =new ArrayList<Teacher>();
        TeacherExample teacherExample =new TeacherExample();
        TeacherExample.Criteria criteria= teacherExample.createCriteria();
        String keyType = IsChOrEnOrNum.IsChOrNum(keyWord);
        if ("chinese".equals(keyType)||"english".equals(keyType)){
            try {
                if (!"".equals(type) || type != null){
                    if ("class".equals(type)){
                        criteria.andTeaClassLike(content);
                    }else if ("department".equals(type)) {
                        criteria.andTeaDepartmentLike(content);
                    }
                }else {
                    criteria.andTeaNameLike(content);
                }
            }catch (Exception e){
                return null;
            }
        }else if("number".equals(keyType)){
            criteria.andTeaIdLike(content);
        }
        teachers = teacherMapper.selectByExample(teacherExample);
        return teachers;
    }
}
