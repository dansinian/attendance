package com.wsh.service.Impl;

import com.wsh.dao.CommentMapper;
import com.wsh.dao.CommentReplyMapper;
import com.wsh.dao.QuestionMapper;
import com.wsh.entity.*;
import com.wsh.service.QuestionService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import com.wsh.servlet.SortList;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentReplyMapper replyMapper;

    @Override
    public JSONObject deleteQuestion(JSONObject jsonObject) {
        String questionId = jsonObject.getString("questionId");
        JSONObject returnJSon = new JSONObject();
            int returncourse= questionMapper.deleteByPrimaryKey(questionId);
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
    public JSONObject createQuestion(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String DateString = new String();
        String queID = "";
        try {
            queID = DataAndNumber.dateToStamp(OutData.createData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Question question = new Question();
       question.setQueId(queID);
       question.setQueTitle(jsonObject.optString("title"));
       question.setQueSummary(jsonObject.optString("summary"));
       question.setQueDetail(jsonObject.optString("detail"));
       question.setUserId(jsonObject.optString("userId"));
       question.setCreateTime(DateString);
       question.setClickCount(0);
       question.setPraiseCount(0);
       question.setReplyCount(0);
       question.setQueCourse(jsonObject.optString("queCourse"));
       question.setUnread(0);
       question.setQueImg(jsonObject.optString("queImg"));
        int success = questionMapper.insert( question);
        if (success > 0){
            returnJson.put("question", question);
            returnJson.put("msg", "添加帖子成功");
            returnJson.put("status", "200");
        } else {
            returnJson.put("question", "");
            returnJson.put("msg","添加帖子失败");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject updateQuestion(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String questionId = jsonObject.getString("questionId");
        Question question =questionMapper.selectByPrimaryKey(questionId);
        if (question!= null){
            question.setQueId(questionId);
            question.setQueTitle(jsonObject.optString("title"));
            question.setQueSummary(jsonObject.optString("summary"));
            question.setQueDetail(jsonObject.optString("detail"));
            question.setUserId(jsonObject.optString("userId"));
            question.setCreateTime(jsonObject.optString("createTime"));
            question.setClickCount(jsonObject.optInt("clickCount"));
            question.setPraiseCount(jsonObject.optInt("praiseCount"));
            question.setReplyCount(jsonObject.optInt("replyCount"));
            question.setQueCourse(jsonObject.optString("queCourse"));
            question.setUnread(0);
            question.setQueImg(jsonObject.optString("queImg"));
            int returnint =questionMapper.updateByPrimaryKeySelective(question);
            if(returnint>0){
                returnJson.put("question",question);
                returnJson.put("msg","修改成功");
                returnJson.put("status","200");
            }else {
                returnJson.put("question","");
                returnJson.put("msg","修改失败");
                returnJson.put("status","500");
            }
        }else {
            returnJson.put("question","");
            returnJson.put("msg","没有查到该课程数据");
            returnJson.put("status","500");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectQuestion(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String title = jsonObject.getString("title");
        List<Question>questions = questionMapper.selectByTitleLike(title);
        if (questions.size() > 0){
            returnJson.put("questions",questions);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else{
            returnJson.put("questions","");
            returnJson.put("status","500");
            returnJson.put("msg","没有查到信息");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectAllQuestion() {
        JSONObject returnJson = new JSONObject();
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andQueIdIsNotNull().andUserIdNotEqualTo("admin");
        List<Question> questions = questionMapper.selectByExample(questionExample);
        questions =  SortList.sort(questions);
        if (questions.size() > 0){
            returnJson.put("questions",questions);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else{
            returnJson.put("questions","");
            returnJson.put("status","500");
            returnJson.put("msg","没有查到信息");
        }
        return returnJson;
    }

    @Override
    public JSONObject questionDetail(JSONObject jsonObject) {
        String quesId = jsonObject.getString("questionId");
        JSONObject returnJson = new JSONObject();
        Question question = questionMapper.selectByPrimaryKey(quesId);
        if (question != null) {
            returnJson.put("question",question);
            CommentExample commentExample = new CommentExample();
            CommentExample.Criteria criteria = commentExample.createCriteria();
            criteria.andQueIdEqualTo(quesId);
            List<Comment> comments =  commentMapper.selectByExample(commentExample); // 查到该问题下所有的一级评论
            if (comments.size() > 0 ) {
                for (int i = 0; i < comments.size(); i++) {  // 进入每一个一级评论 对二级回复进行组装
                    String commentID = comments.get(i).getCommentId();
                    String userId = comments.get(i).getUserId();
                    CommentReplyExample replyExample = new CommentReplyExample();
                    CommentReplyExample.Criteria criteria1 = replyExample.createCriteria();
                    criteria1.andCommentIdEqualTo(commentID).andReplyuserIdEqualTo(userId);
                    List<CommentReply> replies = replyMapper.selectByExample(replyExample); // 查到所有回复一级留言,并且回复的是该问题的评论
                    while(true) {
                        CommentReplyExample replyExample1 = new CommentReplyExample();
                        CommentReplyExample.Criteria criteria2 = replyExample.createCriteria();
                        criteria2.andCommentIdEqualTo(commentID).andReplyuserIdEqualTo(userId);
                        List<CommentReply> replyList =  replyMapper.selectByExample(replyExample1);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public JSONObject myQuestionList(JSONObject jsonObject) {
        String userDepart = jsonObject.getString("userDepartment");
        String newDate = "";
        JSONObject returnJson = new JSONObject();
        try {
            newDate = DataAndNumber.dateToStamp(OutData.createData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andQueIdLessThanOrEqualTo(newDate).andUserIdNotEqualTo("admin");
        List<Question> questions = questionMapper.selectByExample(questionExample);
        if (questions.size() > 0 ) {
            questions = SortList.sortTime(questions);
            returnJson.put("msg","");
            returnJson.put("status","200");
            returnJson.put("questions",questions);
        } else {
            returnJson.put("msg","没有数据");
            returnJson.put("status","500");
            returnJson.put("questions","");
        }
        return returnJson;
    }

    @Override
    public JSONObject adminList() {
        JSONObject returnJson = new JSONObject();
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andUserIdEqualTo("admin");
        List<Question> questions = questionMapper.selectByExample(questionExample);
        if (questions.size() > 0) {
            questions = SortList.sortTime(questions);
            if (questions.size() > 4) {
                questions = questions.subList(0,4);
            }
            returnJson.put("msg","");
            returnJson.put("status","200");
            returnJson.put("questions",questions);
        } else {
            returnJson.put("msg","没有数据");
            returnJson.put("status","500");
            returnJson.put("questions","");
        }
        return returnJson;
    }
}
