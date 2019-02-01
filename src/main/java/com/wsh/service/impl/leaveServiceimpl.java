package com.wsh.service.impl;


import com.wsh.dao.TeacherMapper;
import com.wsh.dao.VacationMapper;
import com.wsh.entity.Teacher;
import com.wsh.entity.TeacherExample;
import com.wsh.entity.Vacation;
import com.wsh.entity.VacationExample;
import com.wsh.service.LeaveService;
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
        try {
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
                List<Vacation> returnLeaves = leaveMapper.selectByExample(leaveExample);
                if (success > 0) {
                    TeacherExample teacherExample = new TeacherExample();
                    TeacherExample.Criteria criteria1 = teacherExample.createCriteria();
                    criteria1.andTeaNameEqualTo(jsonObject.getString("approvalTea"));
                    List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
                    if (teachers.size()>0){
                        String phone = teachers.get(0).getTeaPhone();
                        String teaName = teachers.get(0).getTeaName();
                        MessageLog messageLog = new MessageLog();
                        String returnmsg =  messageLog.call(teaName,stuName,phone);
                        if ("100".equals(returnmsg)){
                            returnJson.put("leave", "");
                            returnJson.put("msg", "添加请假信息成功,请等待老师审批,如5分钟内没有答复,则拒绝批准");
                            returnJson.put("status", "500");
                        }else{
                            criteria.andLeaveIdEqualTo(leaveID);
                            leaveMapper.deleteByExample(leaveExample);
                            returnJson.put("leave", "");
                            returnJson.put("msg", "添加请假信息失败,短信发送给审批老师失败.请联系管理员");
                            returnJson.put("status", "500");
                        }
                    }
                } else {
                    criteria.andLeaveIdEqualTo(leaveID);
                    leaveMapper.deleteByExample(leaveExample);
                    returnJson.put("leave", "");
                    returnJson.put("msg", "添加请假信息失败,请稍后重试");
                    returnJson.put("status", "500");
                }
            }
        } catch (Exception e) {
            criteria.andLeaveIdEqualTo(leaveID);
            leaveMapper.deleteByExample(leaveExample);
            returnJson.put("leave", "");
            returnJson.put("msg", "添加请假信息异常,请联系管理员");
            returnJson.put("status", "500");
        }
        return returnJson;
    }

    @Override
    public JSONObject updateLeave(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String leaveID = jsonObject.getString("leaveId");
        String persionID = jsonObject.getString("persionId");
        String type = jsonObject.getString("type");
        Vacation leave =new Vacation();
        VacationExample courseExample =new VacationExample();
        VacationExample.Criteria criteria= courseExample.createCriteria();
        criteria.andLeaveIdEqualTo(leaveID);
        if ("guide".equals(type) || "student".equals(type)){
            try {
                if (leaveMapper.selectByExample(courseExample).size()>0){
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
                    int returnint =leaveMapper.updateByExampleSelective(leave,courseExample);
                    if(returnint>0){
                        returnJson.put("leave",leave);
                        returnJson.put("msg","修改成功");
                        returnJson.put("status","200");
                    }else {
                        returnJson.put("leave","");
                        returnJson.put("msg","修改失败");
                        returnJson.put("status","500");
                    }
                }
            }catch (Exception e){
                returnJson.put("leave","");
                returnJson.put("msg","修改失败");
                returnJson.put("status","500");
            }
        }
        return returnJson;
    }

    @Override
    public JSONObject selectLeave(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String keyWord = "%"+jsonObject.getString("content")+"%";
        List<Vacation> leaves =new ArrayList<Vacation>();
        VacationExample courseExample =new VacationExample();
        VacationExample.Criteria criteria= courseExample.createCriteria();
        criteria.andLeaveIdLike(keyWord);
        leaves = leaveMapper.selectByExample(courseExample);
        JSONArray leaveJson= JSONArray.fromObject(leaves);
        if (leaves!=null){
            if (leaves.size()>0){
                returnJson.put("leaves",leaveJson);
                returnJson.put("status","200");
                returnJson.put("msg","");
            }
        }else if (leaves==null||leaves.size()==0){
            returnJson.put("leaves",leaveJson);
            returnJson.put("status","500");
            returnJson.put("msg","没有查到请假信息");
        }else {
            returnJson.put("status","500");
            returnJson.put("msg","查询失败，请稍后重试");
        }
        return jsonObject;
    }

    @Override
    public JSONObject selectAllLeave() {
        JSONObject returnJson = new JSONObject();
        VacationExample courseExample =new VacationExample();
        VacationExample.Criteria criteria= courseExample.createCriteria();
        criteria.andLeaveIdIsNotNull();
        List<Vacation> leaves = leaveMapper.selectByExample(courseExample);
        if (leaves.size()!=0){
            JSONArray leaveJson= JSONArray.fromObject(leaves);
            returnJson.put("leaves",leaveJson);
            returnJson.put("msg","");
            returnJson.put("status","200");
        } else {
            returnJson.put("leaves","");
            returnJson.put("msg","没有数据");
            returnJson.put("status","200");
        }
        return returnJson;
    }
}
