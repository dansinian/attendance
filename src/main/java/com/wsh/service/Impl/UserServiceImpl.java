package com.wsh.service.Impl;

import com.wsh.dao.*;
import com.wsh.entity.*;
import com.wsh.service.UserService;
import com.wsh.servlet.IsChOrEnOrNum;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrDou
 * Time: 2019\3\2 0002 12:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentReplyMapper replyMapper;
    @Autowired
    private LikedMapper likedMapper;
    @Autowired
    private FollowMapper followMapper;


    @Override
    public JSONObject deleteUser(JSONObject jsonObject) {
        String userId = jsonObject.getString("userId");
        JSONObject returnJSon = new JSONObject();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        int returncourse= userMapper.deleteByExample(userExample);
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
    public JSONObject createUser(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String userId = jsonObject.getString("userId");
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        User user =new User();
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0){
            returnJson.put("msg","已存在该用户信息");
            returnJson.put("status","500");
            returnJson.put("user",users);
        } else {
            user.setUserId(userId);
            user.setUserName(jsonObject.getString("userName"));
            user.setUserPhone(jsonObject.getString("userPhone"));
            user.setUserPass(userId);
            user.setUserDepartment(jsonObject.getString("userDepartment"));
            user.setUserMajor(jsonObject.getString("userMajor"));
            user.setHeadImg("./webapp/userhead/123.jpg");
            user.setNickname(jsonObject.getString("userName"));
            user.setAutograph(null);
            user.setUserType(jsonObject.getString("type"));
            int success = userMapper.insertSelective(user);
            if (success > 0){
                returnJson.put("user", user);
                returnJson.put("msg", "添加用户信息成功");
                returnJson.put("status", "200");
            } else {
                returnJson.put("ser", "");
                returnJson.put("msg","添加用户信息失败");
                returnJson.put("status","500");
            }
        }
    return returnJson;
    }

    @Override
    public JSONObject updateUser(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String userId = jsonObject.getString("userId");
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 1){
            User olduser = users.get(0);
            User user = new User();
            user.setUserId(userId);
            user.setUserName(jsonObject.optString("userName",olduser.getUserName()));
            user.setUserPhone(jsonObject.optString("userPhone",olduser.getUserPhone()));
            user.setUserPass(jsonObject.optString("userPass",olduser.getUserPass()));
            user.setUserDepartment(jsonObject.optString("userDepartment",olduser.getUserDepartment()));
            user.setUserMajor(jsonObject.optString("userMajor",olduser.getUserMajor()));
            user.setHeadImg(jsonObject.optString("HeadImg",olduser.getHeadImg()));
            user.setNickname(jsonObject.optString("nickName",olduser.getNickname()));
            user.setAutograph(jsonObject.optString("antugraph",olduser.getAutograph()));
            user.setUserType(jsonObject.optString("type",olduser.getUserType()));
            int returnint =userMapper.updateByExampleSelective(user,userExample);
            if(returnint>0){
                returnJson.put("user",user);
                returnJson.put("msg","修改成功");
                returnJson.put("status","200");
            }else {
                returnJson.put("user","");
                returnJson.put("msg","修改失败");
                returnJson.put("status","500");
            }
        }else {
            returnJson.put("user","");
            returnJson.put("msg","没有查到该用户数据");
            returnJson.put("status","500");
        }
    return returnJson;
    }

    @Override
    public JSONObject selectUser (JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String content = jsonObject.getString("content");
        String userType = jsonObject.optString("type");
        List<User> users = new ArrayList<>();
        String type = IsChOrEnOrNum.IsChOrNum(content);
        if ("number".equals(type)) {
            if (!"".equals(userType) && userType != null) {
                users = userMapper.selectByIdLike(content,userType);
            } else {
                users = userMapper.selectByUserIdList(content);
            }

        } else {
            if (!"".equals(userType) && userType != null) {
                users = userMapper.selectByNameLike(content, userType);
            } else {
                users = userMapper.selectByUserName(content);
            }
        }
        if (users.size() > 0){
            if (users.size() == 1) {
                JSONArray followArray = new JSONArray();
                JSONArray fansArray = new JSONArray();
                JSONArray questionArray = new JSONArray();
                FollowExample followExample = new FollowExample();
                FollowExample.Criteria criteria = followExample.createCriteria();
                criteria.andFollowIdEqualTo(content);
                List<Follow> follow = followMapper.selectByExample(followExample);
                criteria.andFollowedIdEqualTo(content);
                List<Follow> followed = followMapper.selectMyFans(content);
                if (follow.size() > 0) {
                    for (int i = 0; i < follow.size(); i++) {
                        String followId = follow.get(i).getFollowedId();
                        User user = userMapper.selectByUserId(followId);
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put("userId",followId);
                        jsonObject1.put("nickName",user.getNickname());
                        jsonObject1.put("headImg",user.getHeadImg());
                        followArray.add(jsonObject1);
                    }
                }
                if (followed.size() > 0) {
                    for (int i = 0; i < followed.size(); i++) {
                        String followedId = followed.get(i).getFollowId();
                        User user = userMapper.selectByUserId(followedId);
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put("userId",followedId);
                        jsonObject1.put("nickName",user.getNickname());
                        jsonObject1.put("headImg",user.getHeadImg());
                        fansArray.add(jsonObject1);
                    }
                }
                QuestionExample questionExample = new QuestionExample();
                QuestionExample.Criteria criteria1 = questionExample.createCriteria();
                criteria1.andUserIdEqualTo(content);
                List<Question> questions = questionMapper.selectByExample(questionExample);
                if (questions.size() > 0) {
                    for (int i = 0; i < questions.size(); i++) {
                        Question question = questions.get(i);
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put("questionId",question.getQueId());
                        jsonObject1.put("title",question.getQueTitle());
                        jsonObject1.put("detail",question.getQueDetail());
                        jsonObject1.put("createTime",question.getCreateTime());
                        questionArray.add(jsonObject1);
                    }
                }
                returnJson.put("follow",followArray);
                returnJson.put("followed",fansArray);
                returnJson.put("questions",questionArray);
                returnJson.put("user",users.get(0));
                returnJson.put("status","200");
                returnJson.put("msg","");
            } else {
                returnJson.put("users",users);
                returnJson.put("status","200");
                returnJson.put("msg","");
            }
        }else{
            returnJson.put("users","");
            returnJson.put("status","500");
            returnJson.put("msg","没有查到用户信息");
        }
        return returnJson;
    }

    @Override
    public JSONObject selectAllUser(JSONObject jsonObject) {
        String content = jsonObject.getString("type");
        JSONObject returnJson = new JSONObject();
        UserExample userExample =new UserExample();
        UserExample.Criteria criteria= userExample.createCriteria();
        criteria.andUserTypeEqualTo(content);
        List<User> Users = userMapper.selectByExample(userExample);
        if (Users.size()>0){
            returnJson.put("Users",Users);
            returnJson.put("status","200");
            returnJson.put("msg","");
        }else{
            returnJson.put("Users","");
            returnJson.put("status","500");
            returnJson.put("msg","没有查到学生信息");
        }
        return returnJson;
    }

    @Override
    public JSONObject userLogin(JSONObject jsonObject) {
        JSONObject returnmap = new JSONObject();
        String account = jsonObject.getString("userId");
        String password = jsonObject.getString("password");
        UserExample userExample =new UserExample();
        UserExample.Criteria criteria= userExample.createCriteria();
        criteria.andUserIdEqualTo(account);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null){
            String jdbcpassword = users.get(0).getUserPass();
            if (jdbcpassword.equals(password)) {
                returnmap.put("msg","");
                returnmap.put("status","200");
                returnmap.put("admin", users.get(0));
            } else {
                returnmap.put("msg","密码错误");
                returnmap.put("status","500");
            }
        }else {
            returnmap.put("status","500");
            returnmap.put("msg","用户不存在");
        }
        return returnmap;
    }

    @Override
    public JSONObject updatePass(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String oldpassword = jsonObject.getString("oldpass");
        String newpassword = jsonObject.getString("newpass");
        String id= jsonObject.getString("userId");
        UserExample userExample =new UserExample();
        UserExample.Criteria criteria= userExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null) {
            if (users.get(0).getUserPass().equals(oldpassword)){
                users.get(0).setUserPass(newpassword);
                int success = userMapper.updateByPrimaryKey(users.get(0));
                if (success>0){
                    returnJson.put("msg","修改成功");
                    returnJson.put("status","200");
                }
            }else {
                returnJson.put("msg","原密码错误");
                returnJson.put("status","500");
            }
        }
        return returnJson;
    }

    /*
    *Excel导入专用
    * */
    @Override
    public JSONObject addStuddents(List excelList) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        int update = 0;
        int add = 0;
        try{
            for (int i = 1; i < excelList.size(); i++) {
                List list = (List) excelList.get(i);
                String userId = (String) list.get(0);
                User user = new User();
                user.setUserId((String) list.get(0));
                user.setUserName((String) list.get(1));
                if ((String) list.get(2) != null && !"".equals((String) list.get(2))) {
                    user.setUserPhone((String) list.get(2));
                } else {
                    user.setUserPhone("");
                }
                if ((String) list.get(3) != null && !"".equals((String) list.get(3))) {
                    user.setUserPass((String) list.get(3));
                } else {
                    user.setUserPass((String) list.get(0));
                }
                user.setUserDepartment((String) list.get(4));
                user.setUserMajor((String) list.get(5));
                if ((String) list.get(6) != null && !"".equals((String) list.get(6))) {
                    user.setHeadImg((String) list.get(6));
                } else {
                    user.setHeadImg("./webapp/userhead/123.jpg");
                }
                if ((String) list.get(7) != null && !"".equals((String) list.get(7))) {
                    user.setNickname((String) list.get(7));
                } else {
                    user.setNickname((String) list.get(1));
                }
                if ((String) list.get(8) != null && !"".equals((String) list.get(8))) {
                    user.setAutograph((String) list.get(8));
                } else {
                    user.setAutograph("");
                }
                user.setUserType((String) list.get(9));
                UserExample userExample =new UserExample();
                UserExample.Criteria criteria= userExample.createCriteria();
                criteria.andUserIdEqualTo(userId);
                List<User> users = userMapper.selectByExample(userExample);
                if (users.size() == 0) {
                    int success = userMapper.insertSelective(user);
                    if (success > 0) {
                        add += 1;
                    }
                } else {
                    user.setId(users.get(0).getId());
                    int success = userMapper.updateByExample(user,userExample);
                    if (success > 0) {
                        update += 1;
                    }
                }
                jsonArray.add(user);
            }
            if (jsonArray.size() > 0) {
                jsonObject.put("msg","录入信息" + add + "条,更新信息" + update + "条");
                jsonObject.put("status","200");
                jsonObject.put("users",jsonArray);
            }
        } catch (Exception e) {
            jsonObject.put("msg","录入失败");
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

    /*
     *点赞和取消点赞
     * */

    @Override
    public JSONObject likes(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String id = jsonObject.getString("ID");
        String type = jsonObject.getString("type");
        String userId = jsonObject.getString("userId");
        if ("question".equals(type)) {
            Question question = questionMapper.selectByPrimaryKey(id);
            question.setPraiseCount(question.getPraiseCount()+1);
            int success = questionMapper.updateByPrimaryKeySelective(question);
            if (success >0) {
                Liked liked = new Liked();
                liked.setLikeUser(userId);
                liked.setLikedQuestion(id);
                likedMapper.insert(liked);
                returnJson.put("status","200");
            } else {
                returnJson.put("status","500");
            }
        } else if ("comment".equals(type)) {
            CommentExample commentExample = new CommentExample();
            CommentExample.Criteria criteria = commentExample.createCriteria();
            criteria.andCommentIdEqualTo(id);
            Comment comment = commentMapper.selectBycommentId(id);
            comment.setPraseCount(comment.getPraseCount()+1);
            int success = commentMapper.updateByExampleSelective(comment,commentExample);
            if (success > 0) {
                Liked liked = new Liked();
                liked.setLikeUser(userId);
                liked.setLikedComment(id);
                likedMapper.insert(liked);
                returnJson.put("status","200");
            } else {
                returnJson.put("status","500");
            }
        } else if ("commentReply".equals(type)) {
            CommentReplyExample replyExample = new CommentReplyExample();
            CommentReplyExample.Criteria criteria = replyExample.createCriteria();
            criteria.andReplyIdEqualTo(id);
            CommentReply reply = replyMapper.selectByRepId(id);
            reply.setPraseCount(reply.getPraseCount()+1);
            int success = replyMapper.updateByExampleSelective(reply,replyExample);
            if (success > 0) {
                Liked liked = new Liked();
                liked.setLikeUser(userId);
                liked.setLikedComment(id);
                likedMapper.insert(liked);
                returnJson.put("status","200");
            } else {
                returnJson.put("status","500");
            }
        }
        return returnJson;
    }


    @Override
    public JSONObject unlikes(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String id = jsonObject.getString("ID");
        String type = jsonObject.getString("type");
        String userId = jsonObject.getString("userId");
        if ("question".equals(type)) {
            Question question = questionMapper.selectByPrimaryKey(id);
            question.setPraiseCount(question.getPraiseCount()-1);
            int success = questionMapper.updateByPrimaryKeySelective(question);
            if (success >0) {
                likedMapper.deleteQuestionLike(id,userId);
            }
        } else if ("comment".equals(type)) {
            CommentExample commentExample = new CommentExample();
            CommentExample.Criteria criteria = commentExample.createCriteria();
            criteria.andCommentIdEqualTo(id);
            Comment comment = commentMapper.selectBycommentId(id);
            comment.setPraseCount(comment.getPraseCount()+1);
            int success = commentMapper.updateByExampleSelective(comment,commentExample);
            if (success > 0) {
                likedMapper.deleteCommentLike(id,userId);
            }
        } else if ("commentReply".equals(type)) {
            CommentReplyExample replyExample = new CommentReplyExample();
            CommentReplyExample.Criteria criteria = replyExample.createCriteria();
            criteria.andReplyIdEqualTo(id);
            CommentReply reply = replyMapper.selectByRepId(id);
            reply.setPraseCount(reply.getPraseCount()+1);
            int success = replyMapper.updateByExampleSelective(reply,replyExample);
            if (success > 0) {
                likedMapper.deleteReplyLike(id,userId);
            }
        }
        return returnJson;
    }

    /*
    * 关注和取消关注
    * */
    @Override
    public JSONObject follow(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String userId = jsonObject.getString("userId");
        String followed = jsonObject.getString("followedId");
        Follow follow = new Follow();
        Follow follow1 = followMapper.selectFollw(userId,followed);
        if (follow1 != null) {
            returnJson.put("msg","不要重复关注");
            returnJson.put("status","500");
        } else {
            follow.setFollowId(userId);
            follow.setFollowedId(followed);
            int success = followMapper.insert(follow);
            if (success > 0) {
                returnJson.put("msg","关注成功");
                returnJson.put("status","200");
            }
        }
        return returnJson;
    }

    @Override
    public JSONObject unfollow(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String userId = jsonObject.getString("userId");
        String followed = jsonObject.getString("followedId");
        Follow follow1 = followMapper.selectFollw(userId,followed);
        if (follow1 != null) {
            FollowExample followExample = new FollowExample();
            FollowExample.Criteria criteria = followExample.createCriteria();
            criteria.andFollowedIdEqualTo(followed).andFollowIdEqualTo(userId);
            int success = followMapper.deleteByExample(followExample);
            if (success > 0) {
                returnJson.put("msg","取消关注成功");
                returnJson.put("status","200");
            }
        } else {
            returnJson.put("msg","请先关注");
            returnJson.put("status","200");
        }
        return returnJson;
    }

}

