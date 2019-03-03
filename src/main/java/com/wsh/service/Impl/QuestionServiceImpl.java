package com.wsh.service.Impl;

import com.wsh.dao.QuestionMapper;
import com.wsh.entity.Question;
import com.wsh.entity.QuestionExample;
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
        try {
            DateString = DataAndNumber.dateToStamp(OutData.createData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Question question = new Question();
       question.setQueId(DateString);
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
        criteria.andQueIdIsNotNull();
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
}
