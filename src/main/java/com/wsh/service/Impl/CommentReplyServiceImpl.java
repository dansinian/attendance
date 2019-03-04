package com.wsh.service.Impl;

import com.wsh.dao.CommentReplyMapper;
import com.wsh.entity.Comment;
import com.wsh.entity.CommentExample;
import com.wsh.entity.CommentReply;
import com.wsh.entity.CommentReplyExample;
import com.wsh.service.CommentReplyService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {
    @Autowired
    private CommentReplyMapper replyMapper;

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
        String commentId = jsonObject.getString("commentId");
        CommentReplyExample replyExample = new CommentReplyExample();
        CommentReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andCommentIdEqualTo(commentId);
        List<CommentReply> comments = replyMapper.selectByExample(replyExample);
        if (comments.size() > 0){
            returnJson.put("commentReply",comments);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else{
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
