package com.wsh.service.Impl;

import com.wsh.dao.AdminMapper;
import com.wsh.dao.StudentMapper;
import com.wsh.dao.TeacherMapper;
import com.wsh.entity.*;
import com.wsh.service.AdminService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public JSONObject loginAdmin(JSONObject jsonObject) throws Exception{

        JSONObject returnmap = new JSONObject();
        String account = jsonObject.getString("account");
        String password = jsonObject.getString("password");
        String type = jsonObject.getString("type");
        if ("student".equals(type)){
            StudentExample studentExample =new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andStuIdEqualTo(account);
            List<Student> students=studentMapper.selectByExample(studentExample);
            if (students.size()==1){
                Student student = students.get(0);
                String jdbcpassword = student.getStuPass();
                if (jdbcpassword.equals(password)){
                    returnmap.put("msg","");
                    returnmap.put("status","200");
                    returnmap.put("type","student");
                    returnmap.put("student", student) ;
                } else {
                    returnmap.put("msg","密码错误");
                    returnmap.put("status","500");
                }
            } else {
                returnmap.put("msg","用户名不存在");
                returnmap.put("status","500");
            }
        } else if("teacher".equals(type)) {
            TeacherExample teacherExample = new TeacherExample();
            TeacherExample.Criteria criteria = teacherExample.createCriteria();
            criteria.andTeaIdEqualTo(account);
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            if (teachers.size()==1) {
                Teacher teacher = teachers.get(0);
                String jdbcpassword = teacher.getTeaPass();
                if (jdbcpassword.equals(password)){
                    returnmap.put("msg","");
                    returnmap.put("status","200");
                    returnmap.put("type","teacher");
                    returnmap.put("teacher", teacher);
                } else {
                    returnmap.put("msg","密码错误");
                    returnmap.put("status","500");
                }
            } else {
                returnmap.put("msg","用户名不存在");
                returnmap.put("type","teacher");
                returnmap.put("status","500");
            }
        } else if ("admin".equals(type)){
            AdminExample adminExample = new AdminExample();
            AdminExample.Criteria criteria = adminExample.createCriteria();
            criteria.andAdminIdEqualTo(account);
            List<Admin> admins = adminMapper.selectByExample(adminExample);
            if (admins.size() ==1){
                Admin admin = admins.get(0);
                String jdbcpassword = admin.getAdminPass();
                if (jdbcpassword.equals(password)) {
                    returnmap.put("msg","");
                    returnmap.put("status","200");
                    returnmap.put("type","admin");
                    returnmap.put("admin", admin);
                } else {
                    returnmap.put("msg","密码错误");
                    returnmap.put("type","admin");
                    returnmap.put("status","500");
                }
            }else {
                returnmap.put("status","500");
                returnmap.put("type","admin");
                returnmap.put("msg","用户名不存在");
            }
        }
        return returnmap;
    }

    @Override
    public JSONObject updatePass(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String oldpassword = jsonObject.getString("old");
        String newpassword = jsonObject.getString("new");
        String id= jsonObject.getString("id");
        String type= jsonObject.getString("type");
        if ("student".equals(type)){
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andStuIdEqualTo(id);
            List<Student> students = studentMapper.selectByExample(studentExample);
            if (students.size()>0){
                Student student = students.get(0);
                if (student.getStuPass().equals(oldpassword)){
                    student.setStuPass(newpassword);
                    int success = studentMapper.updateByExampleSelective(student,studentExample);
                    if (success>0){
                        returnJson.put("msg","修改成功");
                        returnJson.put("status","200");
                        returnJson.put("student",student);
                    }
                }else {
                    returnJson.put("msg","原密码错误");
                    returnJson.put("status","500");
                    returnJson.put("student",student);
                }
            }
        }else if ("teacher".equals(type)){
            TeacherExample teacherExample = new TeacherExample();
            TeacherExample.Criteria criteria = teacherExample.createCriteria();
            criteria.andTeaIdEqualTo(id);
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            if (teachers.size()>0) {
                Teacher teacher = teachers.get(0);
                if (teacher.getTeaPass().equals(oldpassword)){
                    teacher.setTeaPass(newpassword);
                    int success = teacherMapper.updateByExampleSelective(teacher,teacherExample);
                    if (success>0){
                        returnJson.put("msg","修改成功");
                        returnJson.put("status","200");
                        returnJson.put("student",teacher);
                    }
                }else {
                    returnJson.put("msg","原密码错误");
                    returnJson.put("status","500");
                    returnJson.put("student",teacher);
                }
            }
        }else if ("admin".equals(type)){
            AdminExample adminExample = new AdminExample();
            AdminExample.Criteria criteria = adminExample.createCriteria();
            criteria.andAdminIdEqualTo(id);
            List<Admin> admins = adminMapper.selectByExample(adminExample);
            if (admins.size()>0) {
                Admin admin = admins.get(0);
                if (admin.getAdminPass().equals(oldpassword)){
                    admin.setAdminPass(newpassword);
                    int success = adminMapper.updateByExampleSelective(admin,adminExample);
                    if (success>0){
                        returnJson.put("msg","修改成功");
                        returnJson.put("status","200");
                        returnJson.put("student",admin);
                    }
                }else {
                    returnJson.put("msg","原密码错误");
                    returnJson.put("status","500");
                    returnJson.put("student",admin);
                }
            }
        }
        return returnJson;
    }
}
