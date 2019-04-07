package com.wsh.service.Impl;

import com.wsh.dao.CommentMapper;
import com.wsh.dao.CommentReplyMapper;
import com.wsh.dao.QuestionMapper;
import com.wsh.dao.UserMapper;
import com.wsh.entity.*;
import com.wsh.service.QuestionService;
import com.wsh.servlet.DataAndNumber;
import com.wsh.servlet.OutData;
import com.wsh.servlet.SortList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentReplyMapper replyMapper;
    @Autowired
    private UserMapper userMapper;

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
        String DateString = OutData.createData();
        String queID = "";
        try {
            queID = DataAndNumber.dateToStamp(DateString);
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
        Question question1 =questionMapper.selectByPrimaryKey(questionId);
        if (question1!= null){
            Question question = new Question();
            question.setQueId(questionId);
            question.setQueTitle(jsonObject.optString("title",question1.getQueTitle()));
            question.setQueDetail(jsonObject.optString("detail",question1.getQueDetail()));
            question.setQueImg(jsonObject.optString("queImg",question1.getQueImg()));
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
        List<Question>questions = new ArrayList<>();
        String content = jsonObject.getString("content");
        questions = questionMapper.selectByCourseLike(content);
        if (questions.size() ==0) {
            questions = questionMapper.selectByTitleLike(content);
            if (questions.size() == 0) {
                questions = questionMapper.selectByContentLike(content);
            }
        }
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
        criteria.andQueIdIsNotNull();
        List<Question> questions = questionMapper.selectByExample(questionExample);
        questions =  SortList.sortTime(questions);
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
            question.setClickCount(question.getClickCount() +1 );
            questionMapper.updateByPrimaryKey(question); // 每次查看question详情的时候,点击数+1
            returnJson.put("question",question);
            CommentExample commentExample = new CommentExample();
            CommentExample.Criteria criteria = commentExample.createCriteria();
            criteria.andQueIdEqualTo(quesId);
            List<Comment> comments =  commentMapper.selectByExample(commentExample); // 查到该问题下所有的一级评论
            if (comments.size() > 0 ) {
                JSONArray jsonArray = new JSONArray();
                for (int i = 0; i < comments.size(); i++) { // 进入每一个一级评论 对二级回复进行组装
                    JSONObject commJson = new JSONObject();
                    String userID = comments.get(i).getUserId();
                    User user2 = userMapper.selectByUserId(userID);
                    JSONObject jsonObject1 = new JSONObject();
//                    jsonObject1.put(user2.getNickname() + "发表了评论",comments.get(i).getContent());
                    jsonObject1.put("commentId",comments.get(i).getCommentId());
                    jsonObject1.put("commentConent",comments.get(i).getContent());
                    jsonObject1.put("userNickname",user2.getNickname());
                    jsonObject1.put("userId",user2.getUserId());
                    jsonObject1.put("parseCount",comments.get(i).getPraseCount());
                    JSONArray replyArray = new JSONArray();
                    String commentID = comments.get(i).getCommentId();
                    String userId = comments.get(i).getUserId();
                    CommentReplyExample replyExample = new CommentReplyExample();
                    CommentReplyExample.Criteria criteria1 = replyExample.createCriteria();
                    criteria1.andCommentIdEqualTo(commentID);
                    List<CommentReply> replies = replyMapper.selectByExample(replyExample); // 查到所有回复一级留言,并且回复的是该问题的评论
                    if (replies.size() > 0) {
                        SortList.sortReplyTime(replies);
                        Collections.reverse(replies);
                        for (int j = 0; j < replies.size(); j++) {
                            CommentReply reply = replies.get(j);
                            JSONObject jsonObject2 = new JSONObject();
                            User user = userMapper.selectByUserId(reply.getUserId());
                            User user1 = userMapper.selectByUserId(reply.getReplyuserId());
                            JSONObject jsonObject3 = new JSONObject();
                            JSONObject jsonObject4 = new JSONObject();
                            jsonObject4.put("name",user1.getNickname());
                            jsonObject4.put("Id",user1.getUserId());
                            jsonObject3.put("name",user.getNickname());
                            jsonObject3.put("Id",user.getUserId());
                            jsonObject2.put("replyUser",jsonObject3);
                            jsonObject2.put("replyedUser",jsonObject4);
                            jsonObject2.put("replyContent",reply.getContent());
                            jsonObject2.put("replyId",reply.getReplyId());
                            jsonObject2.put("createTime",reply.getCreateTime());
                            jsonObject2.put("praseCount",String.valueOf(reply.getPraseCount()));
                            replyArray.add(jsonObject2);
                        }
                    }
                    commJson.put("comment",jsonObject1);
                    commJson.put("reply",replyArray);
                    jsonArray.add(commJson);
                    if (jsonArray.size() > 0) {
                        returnJson.put("comments",jsonArray);
                        returnJson.put("status","200");
                        returnJson.put("msg","");
                    } else{
                        returnJson.put("comments","");
                        returnJson.put("status","500");
                        returnJson.put("msg","暂无评论");
                    }
                }
            }
            else {
                returnJson.put("comments","");
                returnJson.put("status","500");
                returnJson.put("msg","暂无评论");
            }
        }
        return returnJson;
    }

    @Override
    public JSONObject recommendQuestion() throws ParseException {
        JSONObject returnJson = new JSONObject();
        String newDate = DataAndNumber.dateToStamp(OutData.createData());
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andUserIdNotEqualTo("admin");
        List<Question> questions = questionMapper.selectByExample(questionExample);
        if (questions.size() > 0 ) {
            questions = SortList.sort(questions);
            if (questions.size() >= 10) {
                returnJson.put("questions",questions.subList(0,10));
            } else {
                returnJson.put("questions",questions);
            }
            returnJson.put("msg","");
            returnJson.put("status","200");

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
