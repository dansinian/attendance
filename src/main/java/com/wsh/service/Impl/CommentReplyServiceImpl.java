package com.wsh.service.Impl;

import com.wsh.dao.CommentReplyMapper;
import com.wsh.dao.UserMapper;
import com.wsh.entity.*;
import com.wsh.service.CommentReplyService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import com.wsh.servlet.SortList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {
    @Autowired
    private CommentReplyMapper replyMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public JSONObject deleteConmmentReply(JSONObject jsonObject) {
        String replyId = jsonObject.getString("replyId");
        JSONObject returnJSon = new JSONObject();
        int returncourse= replyMapper.deleteByReplyId(replyId);
        if (returncourse>0){
            returnJSon.put("msg","删除成功");
            returnJSon.put("status","200");
        } else {
            returnJSon.put("msg","删除失败");
            returnJSon.put("status","500");
        }
        return returnJSon;
    }

    @Override
    public JSONObject createConmmentReply(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String DateString = OutData.createData();
        String repId = "";
        try {
            repId = DataAndNumber.dateToStamp(DateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CommentReply reply = new CommentReply();
        reply.setReplyId(repId);
        reply.setCommentId(jsonObject.getString("commentId"));
        reply.setReplyuserId(jsonObject.getString("replyUserId"));
        reply.setUserId(jsonObject.getString("userId"));
        reply.setContent(jsonObject.getString("content"));
        reply.setPraseCount(0);
        reply.setCreateTime(DateString);
        int success = replyMapper.insert( reply);
        if (success > 0){

            returnJson.put("user", reply);
            returnJson.put("msg", "评论成功");
            returnJson.put("status", "200");
        } else {
            returnJson.put("msg", "评论失败");
            returnJson.put("status", "500");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectConmmentReply(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        JSONArray replyArray = new JSONArray();
        String commentId = jsonObject.getString("commentId");
        CommentReplyExample replyExample = new CommentReplyExample();
        CommentReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andCommentIdEqualTo(commentId);
        List<CommentReply> replies = replyMapper.selectByExample(replyExample);
        if (replies.size() > 0) {
            SortList.sortReplyTime(replies);
            Collections.reverse(replies);
            for (int j = 0; j < replies.size(); j++) {
                CommentReply reply = replies.get(j);
                JSONObject jsonObject2 = new JSONObject();
                User user = userMapper.selectByUserId(reply.getUserId());
                User user1 = userMapper.selectByUserId(reply.getReplyuserId());
                jsonObject2.put("replyUser",user.getNickname());
                jsonObject2.put("replyedUser",user1.getNickname());
                jsonObject2.put("replyContent",reply.getContent());
                jsonObject2.put("replyId",reply.getReplyId());
                jsonObject2.put("createTime",reply.getCreateTime());
                jsonObject2.put("prase",String.valueOf(reply.getPraseCount()));
                replyArray.add(jsonObject2);
            }
            returnJson.put("commentReply",replyArray);
            returnJson.put("status","200");
            returnJson.put("msg","");
        } else{
            returnJson.put("comment","");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectReplyed(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String replyId = jsonObject.getString("replyId");
        CommentReplyExample replyExample = new CommentReplyExample();
        CommentReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andReplyIdEqualTo(replyId);
        List<CommentReply> replyList = replyMapper.selectByExample(replyExample);
        if (replyList.size() > 0){
            returnJson.put("answerReply",replyList);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else{
            returnJson.put("comment","");
            returnJson.put("status","500");
        }
        return returnJson;
    }
}
