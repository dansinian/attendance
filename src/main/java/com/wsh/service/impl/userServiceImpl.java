package com.wsh.service.impl;


import com.wsh.servlet.ConvertBeanTomap;
import com.wsh.dao.StudentMapper;
import com.wsh.dao.TeacherMapper;
import com.wsh.dao.UserMapper;
import com.wsh.entity.*;
import com.wsh.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private UserMapper userMapper;

/*    @Override
    public Map<String, String> saveUser(JSONObject jsonObject) {
        Map<String, String> returnmap = new HashMap<String, String>();
        if ("student".equals(jsonObject.getString("isteacher"))) {
            Student student = new Student();
            StudentExample studentExample =new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            String stu_num = jsonObject.getString("stu_id");
            criteria.andStuIdentityEqualTo(stu_num);
            int studentcount = studentMapper.countByExample(studentExample);
            if (studentcount != 0) {
                returnmap.put("msg", "用户已存在");
                returnmap.put("status", "");
            } else {
                student.setStuId(jsonObject.getString("id"));
                student.setStuName(jsonObject.getString("name"));
                student.setStuGender(jsonObject.getString("gender"));
                student.setStuIdentity(jsonObject.getString("identity"));
                student.setStuPhone(jsonObject.getString("phone"));
                student.setStuClass(jsonObject.getString("class"));
                student.setStuMajor(jsonObject.getString("major"));
                student.setStuDepartment(jsonObject.getString("department"));
                student.setTeaName(jsonObject.getString("teachername"));
                student.setStuPassword(jsonObject.getString("password"));
                student.setStuFlag(jsonObject.getString("flag"));
                studentMapper.insert(student);
                if (studentMapper.countByExample(studentExample) != 0) {
                    returnmap.put("msg", "注册成功");
                    returnmap.put("status", "200");
                } else {
                    returnmap.put("msg", "注册失败");
                    returnmap.put("status", "");
                }
            }
        } else if ("teacher".equals(jsonObject.getString("isteacher"))){
            Teacher teacher = new Teacher();
            String stu_num = jsonObject.getString("tea_num");
            TeacherExample teacherExample = new TeacherExample();
            TeacherExample.Criteria criteria = teacherExample.createCriteria();
            criteria.andTeaIdEqualTo(stu_num);
            int teacount = teacherMapper.countByExample(teacherExample);
            if (teacount!=0) {
                returnmap.put("msg", "用户已存在");
                returnmap.put("status", "");
            }else {
                teacher.setTeaId(jsonObject.getString("id"));
                teacher.setTeaName(jsonObject.getString("name"));
                teacher.setTeaGender(jsonObject.getString("gender"));
                teacher.setTeaDepartment(jsonObject.getString("department"));
                teacher.setTeaPhone(jsonObject.getString("phone"));
                teacher.setTeaFlag(jsonObject.getString("flag"));
                teacher.setTeaPassword(jsonObject.getString("password"));
                teacherMapper.insert(teacher);
                if (teacherMapper.countByExample(teacherExample)!=0){
                    returnmap.put("msg","注册成功");
                    returnmap.put("status","200");
                }else {
                    returnmap.put("msg","注册失败");
                    returnmap.put("status","");
                }
            }
        }
        return returnmap;
    }*/

    @Override
    public JSONObject loginUser(JSONObject jsonObject) throws Exception{

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
                String jdbcpassword = student.getStuPassword();
                if (jdbcpassword.equals(password)){
                    returnmap.put("msg","");
                    returnmap.put("status","200");
                    returnmap.put("type","student");
                    returnmap.put("student", ConvertBeanTomap.convertBeanToMap(student)) ;
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
                String jdbcpassword = teacher.getTeaPassword();
                if (jdbcpassword.equals(password)){
                    returnmap.put("msg","");
                    returnmap.put("status","200");
                    returnmap.put("type","teacher");
                    returnmap.put("teacher", ConvertBeanTomap.convertBeanToMap(teacher));
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
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserNameEqualTo(account);
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size() ==1){
                User admin = users.get(0);
                String jdbcpassword = admin.getUserPassword();
                if (jdbcpassword.equals(password)) {
                    returnmap.put("msg","");
                    returnmap.put("status","200");
                    returnmap.put("type","admin");
                    returnmap.put("admin", ConvertBeanTomap.convertBeanToMap(admin));
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
                if (student.getStuPassword().equals(oldpassword)){
                    student.setStuPassword(newpassword);
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
                if (teacher.getTeaPassword().equals(oldpassword)){
                    teacher.setTeaPassword(newpassword);
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
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserNameEqualTo(id);
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size()>0) {
                User user = users.get(0);
                if (user.getUserPassword().equals(oldpassword)){
                    user.setUserPassword(newpassword);
                    int success = userMapper.updateByExampleSelective(user,userExample);
                    if (success>0){
                        returnJson.put("msg","修改成功");
                        returnJson.put("status","200");
                        returnJson.put("student",user);
                    }
                }else {
                    returnJson.put("msg","原密码错误");
                    returnJson.put("status","500");
                    returnJson.put("student",user);
                }
            }
        }
        return returnJson;
    }
}


