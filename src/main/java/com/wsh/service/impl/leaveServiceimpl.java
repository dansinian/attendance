package com.wsh.service.impl;


import com.wsh.dao.TeacherMapper;
import com.wsh.entity.Teacher;
import com.wsh.entity.TeacherExample;
import com.wsh.servlet.IsChOrEnOrNum;
import com.wsh.dao.LeaveMapper;
import com.wsh.entity.Leave;
import com.wsh.entity.LeaveExample;
import com.wsh.service.leaveService;
import com.wsh.servlet.messageLog;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class leaveServiceimpl implements leaveService {
    private LeaveMapper leaveMapper;
    private TeacherMapper teacherMapper;

    @Override
    public String deleteLeave(JSONObject jsonObject) {
        String leaveID = jsonObject.getString("leaveId");
        String returnString ="";
        LeaveExample leaveExample =new LeaveExample();
        LeaveExample.Criteria criteria= leaveExample.createCriteria();
        criteria.andLeaveIdEqualTo(leaveID);
        try {
            int returnleave= leaveMapper.deleteByExample(leaveExample);
            if (returnleave>0){
                returnString = "删除成功";
            }
        }catch (Exception e){
            returnString = "删除失败";
        }
        return returnString;
    }

    @Override
    public JSONObject createLeave(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String leaveID = jsonObject.getString("leaveId");
        Leave leave = new Leave();
        LeaveExample leaveExample = new LeaveExample();
        LeaveExample.Criteria criteria = leaveExample.createCriteria();
        criteria.andLeaveIdEqualTo(leaveID);
        List<Leave> selectLeaves = leaveMapper.selectByExample(leaveExample);
        try {
            if (selectLeaves.size() > 0) {
                returnJson.put("msg", "已存在该请假信息");
                returnJson.put("status", "500");
                returnJson.put("leave", selectLeaves.get(0));
            } else {
                leave.setLeaveId(leaveID);
                leave.setStuId(jsonObject.getString("StuId"));
                leave.setApplicationTime(jsonObject.getString("applicationTiome"));
                leave.setStartTime(jsonObject.getString("startTime"));
                leave.setEndTime(jsonObject.getString("endTime"));
                leave.setLeaveDay(jsonObject.getString("leaveDay"));
                leave.setApprovalTea(jsonObject.getString("approvalTea"));
                leave.setStatus(jsonObject.getString("status"));
                leave.setLeavecourseTea(jsonObject.getString("leaveCourseTea"));
                leaveMapper.insert(leave);
                List<Leave> returnLeaves = leaveMapper.selectByExample(leaveExample);
                if (returnLeaves.size() > 0) {
                    TeacherExample teacherExample = new TeacherExample();
                    TeacherExample.Criteria criteria1 = teacherExample.createCriteria();
                    criteria1.andTeaNameEqualTo(jsonObject.getString("approvalTea"));
                    List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
                    if (teachers.size()>0){
                        String phone = teachers.get(0).getTeaPhone();
                        String teaName = teachers.get(0).getTeaName();
                            if (teaName!=null){
                                //创建一个线程池对象
                                ExecutorService pool = Executors.newCachedThreadPool();
                                //创建一个有返回值的任务
                                messageLog messageLog = new messageLog();
                                messageLog.parameter(teaName,jsonObject.getString("StuId"),phone);
                                //执行任务并获取Future对象
                                Future<String> future  = pool.submit(messageLog);
                                //从 Future 对象 获取任务返回值
                                while(true){
                                    if(future.isDone()){
                                        try{
                                            String returnValue = future.get().toString();
                                            if (" 发送成功".equals(returnValue)){
                                                returnJson.put("leave", "");
                                                returnJson.put("msg", "添加请假信息成功,请等待老师审批,如5分钟内没有答复,则拒绝批准");
                                                returnJson.put("status", "500");
                                            }else{
                                                returnJson.put("leave", "");
                                                returnJson.put("msg", "添加请假信息失败,短信发送给审批老师失败");
                                                returnJson.put("status", "500");
                                            }
                                        }catch (Exception e){
                                            e.printStackTrace();
                                        }
                                        pool.shutdown();
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                    returnJson.put("leave", "");
                    returnJson.put("msg", "添加请假信息失败");
                    returnJson.put("status", "500");
                }
            }
        } catch (Exception e) {
            returnJson.put("leave", "");
            returnJson.put("msg", "添加请假信息失败");
            returnJson.put("status", "500");
        }
        return returnJson;
    }

    @Override
    public JSONObject updateLeave(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String leaveID = jsonObject.getString("leaveId");
        Leave leave =new Leave();
        LeaveExample courseExample =new LeaveExample();
        LeaveExample.Criteria criteria= courseExample.createCriteria();
        criteria.andLeaveIdEqualTo(leaveID);
        try {
            if (leaveMapper.selectByExample(courseExample).size()>0){
                leave.setLeaveId(leaveID);
                leave.setStuId(jsonObject.getString("leaveName"));
                leave.setApplicationTime(jsonObject.getString("aoolicationTiome"));
                leave.setStartTime(jsonObject.getString("startTime"));
                leave.setEndTime(jsonObject.getString("endTime"));
                leave.setLeaveDay(jsonObject.getString("leaveDay"));
                leave.setApprovalTea(jsonObject.getString("approvalTea"));
                leave.setStatus(jsonObject.getString("status"));
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
            }else {
                returnJson.put("leave","");
                returnJson.put("msg","没有查到该课程数据");
                returnJson.put("status","500");
            }
        }catch (Exception e){
            returnJson.put("leave","");
            returnJson.put("msg","修改失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public List<Leave> selectLeave(JSONObject jsonObject) {
        String keyWord = jsonObject.getString("content");
        String type = jsonObject.getString("type");
        String content = "%"+keyWord+"%";
        List<Leave> leaves =new ArrayList<Leave>();
        LeaveExample courseExample =new LeaveExample();
        LeaveExample.Criteria criteria= courseExample.createCriteria();
        criteria.andLeaveIdLike(content);
        leaves = leaveMapper.selectByExample(courseExample);
        return leaves;
    }
}
