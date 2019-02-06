package com.wsh.service.impl;


import com.wsh.dao.CourseArrangementMapper;
import com.wsh.dao.CourseMapper;
import com.wsh.dao.TeacherMapper;
import com.wsh.dao.VacationMapper;
import com.wsh.entity.*;
import com.wsh.service.Course_arragementService;
import com.wsh.service.GocourseService;
import com.wsh.service.LeaveService;
import com.wsh.servlet.IsChOrEnOrNum;
import com.wsh.servlet.MessageLog;
import com.wsh.servlet.OutData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class LeaveServiceimpl implements LeaveService {
    @Autowired
    private VacationMapper leaveMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseArrangementMapper arrangMapper;
    @Autowired
    private Course_arragementService arrangService;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private GocourseService gocourseService;

    @Override
    public JSONObject deleteLeave(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String leaveID = jsonObject.getString("leaveId");
        VacationExample leaveExample =new VacationExample();
        VacationExample.Criteria criteria= leaveExample.createCriteria();
        criteria.andLeaveIdEqualTo(leaveID);
        try {
            int returnleave= leaveMapper.deleteByExample(leaveExample);
            if (returnleave>0){
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
    public JSONObject createLeave(JSONObject jsonObject) {
        Vacation leave = new Vacation();
        JSONObject returnJson = new JSONObject();
        VacationExample leaveExample = new VacationExample();
        String leaveID = OutData.createData();
        String stuName = jsonObject.getString("StuName" );
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");
        String StuId = jsonObject.getString("StuId");
        VacationExample.Criteria criteria = leaveExample.createCriteria();
        criteria.andStartTimeEqualTo(startTime).andEndTimeEqualTo(endTime).andStuIdEqualTo(StuId);
        List<Vacation> selectLeaves = leaveMapper.selectByExample(leaveExample);
        if (selectLeaves.size() > 0) {
            returnJson.put("msg", "已存在该请假信息");
            returnJson.put("status", "500");
            returnJson.put("leave", selectLeaves.get(0));
        } else {
            leave.setLeaveId(leaveID);
            leave.setStuId(StuId);
            leave.setStuName(stuName);
            leave.setStartTime(startTime);
            leave.setEndTime(endTime);
            leave.setStatus("0");
            leave.setApplicationTime(jsonObject.getString("applicationTime"));
            leave.setLeaveDay(jsonObject.getString("leaveDay"));
            leave.setApprovalTea(jsonObject.getString("approvalTea"));
            leave.setLeavecourseTea(jsonObject.getString("leaveCourseTea"));
            leave.setLeaveReason(jsonObject.getString("leaveReason"));
            int success = leaveMapper.insert(leave);
            if (success > 0) {
                List<Teacher> teachers = teacherMapper.selectTeaNameLike(jsonObject.getString("approvalTea"));
                returnJson.put("guidePhone",teachers.get(0).getTeaPhone());
                returnJson.put("leave", leave);
                returnJson.put("msg", "添加请假信息成功");
                returnJson.put("status", "200");
            } else {
                returnJson.put("leave", "");
                returnJson.put("msg", "添加请假信息失败,请稍后重试");
                returnJson.put("status", "500");
            }
        }
        return returnJson;
    }

    @Override
    public JSONObject updateLeave(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String leaveID = jsonObject.getString("leaveId");
        String type = jsonObject.getString("type");
        Vacation leave =new Vacation();
        VacationExample vacationExample =new VacationExample();
        VacationExample.Criteria criteria= vacationExample.createCriteria();
        criteria.andLeaveIdEqualTo(leaveID);
        List<Vacation> vacations=  leaveMapper.selectByExample(vacationExample);
        if ("guide".equals(type) || "student".equals(type)){
            if (vacations.size()==1){
                leave.setLeaveId(leaveID);
                leave.setStuId(jsonObject.getString("stuId"));
                leave.setStuName(jsonObject.getString("stuName"));
                leave.setApplicationTime(jsonObject.getString("applicationTime"));
                leave.setStartTime(jsonObject.getString("startTime"));
                leave.setEndTime(jsonObject.getString("endTime"));
                leave.setLeaveDay(jsonObject.getString("leaveDay"));
                leave.setApprovalTea(jsonObject.getString("approvalTea"));
                leave.setStatus(jsonObject.getString("status"));
                leave.setLeaveReason(jsonObject.getString("reason"));
                Vacation vacation = vacations.get(0);
                int ID = vacation.getId();
                if("0".equals(vacation.getStatus())){
                    int returnint =leaveMapper.updateByExampleSelective(leave,vacationExample);
                    if(returnint>0){
                        Vacation vacation1 = leaveMapper.selectByPrimaryKey(ID);
                        String status = vacation1.getStatus();
                        if ("1".equals(status)){
                            String startTime = vacation1.getStartTime();
                            String endTime = vacation1.getEndTime();
                            List<CourseArrangement> array = arrangService.selectVacationCourse(startTime,endTime);
                            if (array.size()>0){
                                for (int i = 0; i < array.size(); i++) {
                                    JSONObject IsGoCourse = new JSONObject();
                                    CourseArrangement vacation2 = new CourseArrangement();
                                    CourseExample courseExample = new CourseExample();
                                    CourseExample.Criteria criteria1 = courseExample.createCriteria();
                                    criteria1.andCourseIdEqualTo(vacation2.getCarmId());
                                    List<Course> courses = courseMapper.selectByExample(courseExample);
                                    if (courses.size()>0){
                                        String TeaName = courses.get(0).getTeaName();
                                        vacation2 = array.get(i);
                                        String courseId = vacation2.getCarmId();
                                        IsGoCourse.put("courseID",vacation2.getCourseId());
                                        IsGoCourse.put("stuId",jsonObject.getString("stuId"));
                                        IsGoCourse.put("courseTeacher",TeaName);
                                        IsGoCourse.put("isTruancy","0");
                                        IsGoCourse.put("courseTime",vacation2.getCarmTime());
                                        JSONObject GoCourse = gocourseService.createGocourse(IsGoCourse);
                                    }
                                }
                            }
                        }
                        returnJson.put("leave",leave);
                        returnJson.put("msg","修改成功");
                        returnJson.put("status","200");
                    }else {
                        returnJson.put("leave","");
                        returnJson.put("msg","修改失败");
                        returnJson.put("status","500");
                    }
                }
            }
        }
        return returnJson;
    }

    @Override
    public JSONObject selectLeave(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        List<Vacation> leaves =new ArrayList<Vacation>();
        String keyWord = jsonObject.getString("content");
        IsChOrEnOrNum isChOrEnOrNum = new IsChOrEnOrNum();
        String key = isChOrEnOrNum.IsChOrNum(keyWord);
        if ("chinese".equals(key)){
            String type = jsonObject.getString("type");
            if ("student".equals(type)){
                leaves = leaveMapper.selectByStuNameLike(keyWord);
            }else if ("guide".equals(type)){
                leaves = leaveMapper.selectByGuideName(keyWord);
            } else if ("teacher".equals(type)){
                leaves = leaveMapper.selectByteacherName(keyWord);
            }
        } else{
            leaves = leaveMapper.selectByLeaveIdLike(keyWord);
        }
        if (leaves.size()>0){
            returnJson.put("leaves",leaves);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else{
            returnJson.put("leaves","");
            returnJson.put("status","500");
            returnJson.put("msg","没有查到请假信息");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectAllLeave() {
        JSONObject returnJson = new JSONObject();
        VacationExample vacationExample =new VacationExample();
        VacationExample.Criteria criteria= vacationExample.createCriteria();
        criteria.andLeaveIdIsNotNull();
        List<Vacation> leaves = leaveMapper.selectByExample(vacationExample);
        if (leaves.size()!=0){
            JSONArray leaveJson= JSONArray.fromObject(leaves);
            returnJson.put("leaves",leaveJson);
            returnJson.put("msg","");
            returnJson.put("status","200");
        } else {
            returnJson.put("leaves","");
            returnJson.put("msg","没有数据");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject callTeacher(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String stuName = jsonObject.getString("studentName");
        String teaName = jsonObject.getString("teacherName");
        String teaPhone = jsonObject.getString("teacherPhone");
        MessageLog messageLog = new MessageLog();
        String status = messageLog.call(teaName,stuName,teaPhone);
        if ("100".equals(status)){
            returnJson.put("msg", "添加请假信息成功,请等待老师审批,如两小时没有答复,则拒绝批准");
            returnJson.put("status", "200");
        }else{
            returnJson.put("msg", "添加请假信息失败,短信发送给审批老师失败.请联系管理员");
            returnJson.put("status", "500");
        }
        return returnJson;
    }
}
