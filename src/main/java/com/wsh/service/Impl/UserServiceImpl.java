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
        List<User> users = new ArrayList<>();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        String type = IsChOrEnOrNum.IsChOrNum(content);
        if ("number".equals(type)) {
            users = userMapper.selectByIdLike(content);
        } else {
            users = userMapper.selectByNameLike(content);
        }
        if (users.size() > 0){
            returnJson.put("users",users);
            returnJson.put("status","200");
            returnJson.put("msg","");
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
        criteria.andUserTypeEqualTo(account);
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
        criteria.andUserTypeEqualTo(id);
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
        try{
            for (int i = 1; i < excelList.size(); i++) {
                List list = (List) excelList.get(i);
                String userId = (String) list.get(0);
                User user = new User();
                user.setUserId((String) list.get(0));
                user.setUserName((String) list.get(1));
                user.setUserPhone((String) list.get(2));
                user.setUserPass((String) list.get(3));
                user.setUserDepartment((String) list.get(4));
                user.setUserMajor((String) list.get(5));
                if ((String) list.get(6) != null && !"".equals((String) list.get(6))) {
                    user.setHeadImg((String) list.get(6));
                } else {
                    user.setHeadImg(null);
                }
                if ((String) list.get(7) != null && !"".equals((String) list.get(7))) {
                    user.setNickname((String) list.get(7));
                } else {
                    user.setNickname(null);
                }
                if ((String) list.get(8) != null && !"".equals((String) list.get(8))) {
                    user.setAutograph((String) list.get(8));
                } else {
                    user.setAutograph(null);
                }
                user.setUserType((String) list.get(9));
                UserExample userExample =new UserExample();
                UserExample.Criteria criteria= userExample.createCriteria();
                criteria.andUserTypeEqualTo(userId);
                List<User> users = userMapper.selectByExample(userExample);
                if (users ==null) {
                    int success = userMapper.insertSelective(user);
                    if (success > 0) {
                        jsonArray.add(user);
                    }
                }
            }
            if (jsonArray.size() > 0) {
                jsonObject.put("msg","录入信息" + jsonArray.size() + "条");
                jsonObject.put("status","200");
                jsonObject.put("users",jsonArray);
            } else {
                jsonObject.put("msg","请确认数据是否重复");
                jsonObject.put("status","500");
            }
        } catch (Exception e) {
            jsonObject.put("msg","录入失败");
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

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
            }
        }
        return returnJson;
    }

    @Override
    public JSONObject unlikes(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        return null;
    }

    @Override
    public JSONObject follow(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject unfollow(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        return null;
    }

}

