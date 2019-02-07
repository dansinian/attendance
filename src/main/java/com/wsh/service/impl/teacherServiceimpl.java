package com.wsh.service.impl;

import com.wsh.servlet.IsChOrEnOrNum;
import com.wsh.dao.TeacherMapper;
import com.wsh.entity.Teacher;
import com.wsh.entity.TeacherExample;
import com.wsh.service.TeacherService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceimpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public JSONObject deleteTeacher(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String teacherID = jsonObject.getString("teacherId");
        TeacherExample teacherExample =new TeacherExample();
        TeacherExample.Criteria criteria= teacherExample.createCriteria();
        criteria.andTeaIdEqualTo(teacherID);
        try {
            int returncourse= teacherMapper.deleteByExample(teacherExample);
            if (returncourse>0){
                returnJson.put("msg","删除成功");
                returnJson.put("status","200");
            } else {
                returnJson.put("msg","删除失败");
                returnJson.put("status","500");
            }
        }catch (Exception e){
            returnJson.put("msg","删除失败");
            returnJson.put("status","500");
        }
        return returnJson;
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
    public JSONObject selectTeacher(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String keyWord = jsonObject.getString("content");
        List<Teacher> teachers =new ArrayList<Teacher>();
        IsChOrEnOrNum isChOrEnOrNum = new IsChOrEnOrNum();
        String returnType = isChOrEnOrNum.IsChOrNum(keyWord);
        if ("number".equals(returnType)){
            teachers = teacherMapper.selectTeaIdLike(keyWord);
        } else {
            teachers = teacherMapper.selectTeaNameLike(keyWord);
        }
        if (teachers.size() >0){
            returnJson.put("msg","");
            returnJson.put("status","200");
            returnJson.put("teacher",teachers);
        } else {
            teachers = teacherMapper.selectByDepLike(keyWord);
            if (teachers.size() >0){
                returnJson.put("msg","");
                returnJson.put("status","200");
                returnJson.put("teacher",teachers);
            }else {
                returnJson.put("teacher","");
                returnJson.put("msg","没有查到数据");
                returnJson.put("status","500");
            }
        }
        return returnJson;
    }

    @Override
    public JSONObject selectAllTercher() {
        JSONObject returnJson = new JSONObject();
        List<Teacher> teachers =new ArrayList<Teacher>();
        TeacherExample teacherExample =new TeacherExample();
        TeacherExample.Criteria criteria= teacherExample.createCriteria();
        criteria.andIdIsNotNull();
        teachers = teacherMapper.selectByExample(teacherExample);
        if (teachers.size()>0){
            returnJson.put("teachers",teachers);
            returnJson.put("msg","");
            returnJson.put("status","200");
        } else {
            returnJson.put("teachers","");
            returnJson.put("msg","没有数据");
            returnJson.put("status","500");
        }
        return returnJson;
    }
}
