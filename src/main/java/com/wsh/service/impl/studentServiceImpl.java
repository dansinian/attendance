package com.wsh.service.impl;

import com.wsh.dao.*;
import com.wsh.entity.*;
import com.wsh.service.StudentService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.IsChOrEnOrNum;
import com.wsh.servlet.OutData;
import com.wsh.servlet.OutputWeek;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.image.DataBufferNative;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseArrangementMapper arragementMapper;
    @Autowired
    private IsgocourseMapper gocourseMapper;
    @Autowired
    private ReportcourseMapper reportcourseMapper;

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
    public JSONObject selectStudent (JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String keyWord = jsonObject.getString("content");
        String Keytype = IsChOrEnOrNum.IsChOrNum(keyWord);
        List<Student> students =new ArrayList<Student>();
            if ("chinese".equals(Keytype)){
                students = studentMapper.selectByNameLike(keyWord);
                if (students.size()==0){
                    students = studentMapper.selectByClassLike(keyWord);
                }
            } else {
                students = studentMapper.selectByStuIdLike(keyWord);
            }
            if (students.size()>0){
                returnJson.put("students",students);
                returnJson.put("status","200");
                returnJson.put("msg","");
            }else{
                returnJson.put("students","");
                returnJson.put("status","500");
                returnJson.put("msg","没有查到学生信息");
            }
        return returnJson;
    }

    @Override
    public JSONObject selectAllStudent() {
        JSONObject jsonObject = new JSONObject();
        List<Student> students =new ArrayList<Student>();
        StudentExample studentExample =new StudentExample();
        StudentExample.Criteria criteria= studentExample.createCriteria();
        criteria.andIdIsNotNull();
        students = studentMapper.selectByExample(studentExample);
        if (students.size()>0){
            jsonObject.put("students",students);
            jsonObject.put("status","200");
            jsonObject.put("msg","");
        }else{
            jsonObject.put("students","");
            jsonObject.put("status","500");
            jsonObject.put("msg","没有查到学生信息");
        }
        return jsonObject;
    }

    @Override
    public JSONObject selectByTeacher(JSONObject jsonObject) throws ParseException {
        String teaID = jsonObject.getString("teacherId");
        JSONObject returnJson = new JSONObject();
        OutputWeek outputWeek = new OutputWeek();
        Date date = new Date();
        String dateStr = OutData.createData();
        String weekDate = dateStr.substring(0,10);
        String weekday = outputWeek.OutputWeek(weekDate).getString("week");
        String reportTime = dateStr.substring(11, 13) + dateStr.substring(14, 16);
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeaIdEqualTo(teaID);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        if (teachers.size()>0){
            Teacher teacher = teachers.get(0);
            String teaName = teacher.getTeaName();
            String teaclass = teacher.getTeaClass();
            String teaDepart = teacher.getTeaDepartment();
            String teaClass[] = teaclass.split(",");
            if (teaClass.length>0) {
                for (int k = 0; k < teaClass.length; k++) {
                String teacherClass = teaClass[k];
                List<Course> courses = courseMapper.selectByTeaAndClass(teaName,teacherClass);
                if (courses.size() > 0) {
                    CourseArrangementExample arrangementExample = new CourseArrangementExample();
                    CourseArrangementExample.Criteria arrangementcriteria = arrangementExample.createCriteria();
                    for (int i = 0; i < courses.size(); i++) {
                        arrangementcriteria.andCourseWeekEqualTo(weekday).andCourseIdEqualTo(courses.get(i).getCourseId()).andStartTimeLessThanOrEqualTo(reportTime).andEndTimeGreaterThanOrEqualTo(reportTime);
                        List<CourseArrangement> arrangements = arragementMapper.selectByExample(arrangementExample);
                        if (arrangements.size() > 0) {
                            for (int j = 0; j < arrangements.size(); j++) {
                                String courseID = arrangements.get(j).getCourseId();
                                if (courseID.equals(courses.get(i).getCourseId())){
                                    JSONArray stuarray = new JSONArray();
                                    StudentExample studentExample =new StudentExample();
                                    StudentExample.Criteria stucriteria= studentExample.createCriteria();
                                    stucriteria.andStuClassEqualTo(teacherClass);
                                    List<Student> students = studentMapper.selectByExample(studentExample);
                                    if (students.size()>0){
                                        for (int l = 0; l < students.size(); l++) {
                                            JSONObject stujson = new JSONObject();
                                            stujson.put("name",students.get(l).getStuName());
                                            stujson.put("stuID",students.get(l).getStuId());
                                            stuarray.add(stujson);
                                        }
                                        returnJson.put("student",stuarray);
                                        returnJson.put("msg","");
                                        returnJson.put("status","200");
                                        returnJson.put("course",courses.get(i).getCourseId());
                                        return returnJson;
                                    }else {
                                        returnJson.put("student","");
                                        returnJson.put("msg","没有查到学生数据");
                                        returnJson.put("status","500");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
                returnJson.put("student","");
                returnJson.put("msg","没有查到该教师所带班级数据");
                returnJson.put("status","500");
            }
    }else{
            returnJson.put("student","");
            returnJson.put("msg","没有查到该教师数据");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject report(JSONObject jsonObject) throws ParseException {
        String stuID = jsonObject.getString("stuId");
        String courseId = jsonObject.getString("courseId");
        DataAndNumber dataAndNumber = new DataAndNumber();
        JSONObject returnJson = new JSONObject();
        String time = OutData.createData();
        String weekDate = time.substring(0,10);
        String week = OutputWeek.OutputWeek(weekDate).getString("week");
        String reportTime = time.substring(11, 13) + time.substring(14, 16);
        weekDate = weekDate.replaceAll("-","");
        Reportcourse reportcourse = new Reportcourse();
        reportcourse.setStuId(stuID);
        reportcourse.setReportTime(reportTime);
        reportcourse.setReportWeek(week);
        reportcourse.setReportCourse(courseId);
        reportcourse.setReportDay(weekDate);
        int success = reportcourseMapper.insert(reportcourse);
        if (success>0){
            returnJson.put("msg","签到成功");
            returnJson.put("status","200");
        }else{
            returnJson.put("msg","签到失败,请重试");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectReportStudent(JSONObject jsonObject) throws ParseException {
        DataAndNumber dataAndNumber = new DataAndNumber();
        JSONObject returnJson = new JSONObject();
        String week = jsonObject.getString("week");
        String courseId = jsonObject.getString("courseId");
        String startTime = jsonObject.getString("startTime").replace(":","");
        String endTime = jsonObject.getString("endTime").replace(":","");
        ReportcourseExample reportcourseExample = new ReportcourseExample();
        ReportcourseExample.Criteria criteria = reportcourseExample.createCriteria();
        criteria.andReportCourseEqualTo(courseId).andReportWeekEqualTo(week).andReportTimeBetween(startTime,endTime);
        List<Reportcourse> reportcourses = reportcourseMapper.selectByExample(reportcourseExample);
        List<Student> students = new ArrayList<Student>();
        if (reportcourses.size()>0){
            for (int i = 0; i < reportcourses.size(); i++) {
                String stuID = reportcourses.get(i).getStuId();
                StudentExample studentExample =new StudentExample();
                StudentExample.Criteria stucriteria= studentExample.createCriteria();
                stucriteria.andStuIdEqualTo(stuID);
                List<Student> students1 = studentMapper.selectByExample(studentExample);
                if (students1.size()>0){
                        students.addAll(students1);
                }
            }
            if (students.size()>0){
                returnJson.put("msg","");
                returnJson.put("status","200");
                returnJson.put("students",students);
            }
        }else {
            returnJson.put("msg","没有签到信息");
            returnJson.put("status","500");
            returnJson.put("students","");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectWeekReport(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String StuClass = jsonObject.getString("stuClass");
        String courseId = jsonObject.getString("courseId");
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");

        String courseStarTime = startTime + " " + "00:00:00";
        String courseEndTime = endTime + " " + "00:00:00";
        try {
            courseStarTime = DataAndNumber.dateToStamp(courseStarTime);
            courseEndTime = DataAndNumber.dateToStamp(courseEndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startTime = startTime.replace("-","");
        endTime = endTime.replace("-","");
        ReportcourseExample reportcourseExample = new ReportcourseExample();
        ReportcourseExample.Criteria criteria = reportcourseExample.createCriteria();
        criteria.andReportCourseEqualTo(courseId).andReportDayBetween(startTime,endTime);
        List<Reportcourse> reportcourses = reportcourseMapper.selectByExample(reportcourseExample);
        IsgocourseExample gocourseExample = new IsgocourseExample();
        IsgocourseExample.Criteria goCriteria = gocourseExample.createCriteria();
        goCriteria.andStuClassEqualTo(StuClass).andCourseTimeBetween(courseStarTime,courseEndTime);
        List<Isgocourse> goucourses = gocourseMapper.selectByExample(gocourseExample);
        JSONArray students = new JSONArray();
        if (goucourses.size()>0){
            for (int i = 0; i < goucourses.size(); i++) {
                String stuID = goucourses.get(i).getStuId();
                Student students1 = studentMapper.selectstuBystuId(stuID);
                if (students1!=null){
                    JSONObject stuJson = new JSONObject();
                    String leaveDate =  DataAndNumber.stampToDate(goucourses.get(i).getCourseTime());

                    stuJson.put("stuId",stuID);
                    stuJson.put("stuName",students1.getStuName());
                    stuJson.put("stuClass",students1.getStuClass());
                    stuJson.put("isTruancy",goucourses.get(i).getIsTruancy());
                    stuJson.put("truancyDay",leaveDate.substring(0,10));
                    stuJson.put("truancyTime",leaveDate.substring(11,16));
                    students.add(stuJson);
                }
            }
        }
        if (reportcourses.size()>0){
            for (int i = 0; i < reportcourses.size(); i++) {
                String stuID = reportcourses.get(i).getStuId();
                Student students1 = studentMapper.selectstuBystuId(stuID);
                if (students1!=null){
                    JSONObject stuJson = new JSONObject();
                    stuJson.put("stuId",stuID);
                    stuJson.put("stuName",students1.getStuName());
                    stuJson.put("stuClass",students1.getStuClass());
                    String reportDay = reportcourses.get(i).getReportDay();
                    String reportTime = reportcourses.get(i).getReportTime();
                    StringBuffer stuDay = new StringBuffer(reportDay);
                    StringBuffer stuTime = new StringBuffer(reportTime);
                    stuTime.insert(2,":");
                    stuDay.insert(4,"-");
                    stuDay.insert(7,"-");
                    String studay = new String(stuDay);
                    String stutime = new String(stuTime);
                    stuJson.put("reportDay",studay);
                    stuJson.put("reportTime",stutime);
                    students.add(stuJson);
                }
            }
            if (students.size()>0){
                returnJson.put("msg","");
                returnJson.put("status","200");
                returnJson.put("students",students);
            }
        }else {
            returnJson.put("msg","没有签到信息");
            returnJson.put("status","500");
            returnJson.put("students","");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectMyReport(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String stuId = jsonObject.getString("stuId");
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");
        String courseStarTime = startTime + " " + "00:00:00";
        String courseEndTime = endTime + " " + "00:00:00";
        try {
            courseStarTime = DataAndNumber.dateToStamp(courseStarTime);
            courseEndTime = DataAndNumber.dateToStamp(courseEndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startTime = startTime.replace("-", "");
        endTime = endTime.replace("-", "");
        ReportcourseExample reportcourseExample = new ReportcourseExample();
        ReportcourseExample.Criteria criteria = reportcourseExample.createCriteria();
        criteria.andStuIdEqualTo(stuId).andReportDayBetween(startTime, endTime);
        List<Reportcourse> reportcourses = reportcourseMapper.selectByExample(reportcourseExample);

        IsgocourseExample gocourseExample = new IsgocourseExample();
        IsgocourseExample.Criteria goCriteria = gocourseExample.createCriteria();
        goCriteria.andStuIdEqualTo(stuId).andCourseTimeBetween(courseStarTime, courseEndTime);
        List<Isgocourse> goucourses = gocourseMapper.selectByExample(gocourseExample);
        JSONArray stuJsarray = new JSONArray();
        if (reportcourses.size() > 0) {
            for (int i = 0; i < reportcourses.size(); i++) {
                String courseID = reportcourses.get(i).getReportCourse();
                Course course = courseMapper.selectCourseById(courseID);
                JSONObject courseJson = new JSONObject();
                String reportDay = reportcourses.get(i).getReportDay();
                String reportTime = reportcourses.get(i).getReportTime();
                StringBuffer stuDay = new StringBuffer(reportDay);
                StringBuffer stuTime = new StringBuffer(reportTime);
                stuTime.insert(2, ":");
                stuDay.insert(4, "-");
                stuDay.insert(7, "-");
                String studay = new String(stuDay);
                String stutime = new String(stuTime);
                courseJson.put("reportCourse", course.getCourseName());
                courseJson.put("reportDay", studay);
                courseJson.put("reportTime", stutime);
                courseJson.put("reportStatus", "2"); // 0旷课 1请假 2签到
                stuJsarray.add(courseJson);
            }
        }
        if (goucourses.size() > 0) {
            for (int i = 0; i < goucourses.size(); i++) {
                String courseID = goucourses.get(i).getCourseId();
                String leaveDate = DataAndNumber.stampToDate(goucourses.get(i).getCourseTime());
                Course course = courseMapper.selectCourseById(courseID);
                JSONObject courseJson = new JSONObject();
                String reportDay = reportcourses.get(i).getReportDay();
                String reportTime = reportcourses.get(i).getReportTime();
                StringBuffer stuDay = new StringBuffer(reportDay);
                StringBuffer stuTime = new StringBuffer(reportTime);
                stuTime.insert(2, ":");
                stuDay.insert(4, "-");
                stuDay.insert(7, "-");
                String studay = new String(stuDay);
                String stutime = new String(stuTime);
                courseJson.put("truancyCourse", course.getCourseName());
                courseJson.put("truancyDay", leaveDate.substring(0, 10));
                courseJson.put("truancyTime", leaveDate.substring(11, 16));
                courseJson.put("reportStatus", goucourses.get(i).getIsTruancy()); // 0旷课 1请假 2签到
                stuJsarray.add(courseJson);
            }
        }
        if (stuJsarray.size() > 0) {
            returnJson.put("msg", "");
            returnJson.put("status", "200");
            returnJson.put("students", stuJsarray);
        } else {
            returnJson.put("msg", "没有查到信息");
            returnJson.put("status", "500");
            returnJson.put("students", "");
        }
        return returnJson;
    }
}
