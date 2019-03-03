package com.wsh.service.Impl;

import com.wsh.dao.CommentMapper;
import com.wsh.dao.QuestionMapper;
import com.wsh.dao.UserMapper;
import com.wsh.entity.Comment;
import com.wsh.entity.CommentExample;
import com.wsh.entity.Question;
import com.wsh.service.CommentService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import com.wsh.servlet.SortList;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
@Service
public class ConmmentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject deleteConmment(JSONObject jsonObject) {
        String commentId = jsonObject.getString("commentId");
        JSONObject returnJSon = new JSONObject();
        int returncourse= commentMapper.deleteByPrimaryKey(commentId);
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
    public JSONObject createConmment(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String DateString = new String();
        String questionId = jsonObject.getString("questionId");
        String userId = jsonObject.getString("userId");
        try {
            DateString = DataAndNumber.dateToStamp(OutData.createData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Comment comment = new Comment();
        comment.setCommentId(DateString);
        comment.setQueId(questionId);
        comment.setUserId(userId);
        comment.setContent(jsonObject.getString("content"));
        comment.setPraseCount(0);
        comment.setCreateTime(DateString);
        comment.setCommentImg(jsonObject.optString("commentImg"));

        int success = commentMapper.insert( comment);
        if (success > 0) {
            Question question = questionMapper.selectByPrimaryKey(questionId);
            question.setUnread(question.getUnread()+1);
            questionMapper.updateByPrimaryKeySelective(question);
            returnJson.put("comment", comment);
            returnJson.put("msg", "评论成功");
            returnJson.put("status", "200");
        } else {
            returnJson.put("msg", "评论失败");
            returnJson.put("status", "500");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectConmment(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String questionId = jsonObject.getString("questionId");
        CommentExample questionExample = new CommentExample();
        CommentExample.Criteria criteria = questionExample.createCriteria();
        criteria.andQueIdEqualTo(questionId);
        List<Comment> comments = commentMapper.selectByExample(questionExample);
        if (comments.size() > 0){
            returnJson.put("comment",comments);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else{
            returnJson.put("comment","");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectAllConmment() {
        JSONObject returnJson = new JSONObject();
        CommentExample questionExample = new CommentExample();
        CommentExample.Criteria criteria = questionExample.createCriteria();
        criteria.andCommentIdIsNotNull();
        List<Comment> comments = commentMapper.selectByExample(questionExample);
        if (comments.size() > 0){
            returnJson.put("comments",comments);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else{
            returnJson.put("comments","");
            returnJson.put("status","500");
            returnJson.put("msg","没有评论信息");
        }
        return returnJson;
    }
}
