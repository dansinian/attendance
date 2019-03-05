package com.wsh.service.Impl;

import com.wsh.dao.UserMapper;
import com.wsh.entity.User;
import com.wsh.entity.UserExample;
import com.wsh.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrDou
 * Time: 2019\3\2 0002 12:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject deleteUser(JSONObject jsonObject) {
        String userId = jsonObject.getString("userId");
        JSONObject returnJSon = new JSONObject();
        try {
            int returncourse= userMapper.deleteByPrimaryKey(userId);
            if (returncourse>0){
                returnJSon.put("msg","删除成功");
                returnJSon.put("status","200");
            } else {
                returnJSon.put("msg","删除失败");
                returnJSon.put("status","500");
            }
        }catch (Exception e){
            returnJSon.put("msg","删除失败");
            returnJSon.put("status","500");
        }
        return returnJSon;
    }

    @Override
    public JSONObject createUser(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String userId = jsonObject.getString("userId");
        User user =new User();
        User user1 = userMapper.selectByPrimaryKey(userId);
        if (user1 != null){
            returnJson.put("msg","已存在该用户信息");
            returnJson.put("status","500");
            returnJson.put("user", user1 );
        } else {
            user.setUserId(userId);
            user.setUserName(jsonObject.getString("serName"));
            user.setUserPhone(jsonObject.getString("userPhone"));
            user.setUserPass(jsonObject.getString("userPass"));
            user.setUserDepartment(jsonObject.getString("userDepartment"));
            user.setUserMajor(jsonObject.getString("userMajor"));
            user.setHeadImg(jsonObject.getString("HeadImg"));
            user.setNickname(jsonObject.getString("nickName"));
            user.setAutograph(jsonObject.getString("antugraph"));
            int success = userMapper.insert(user);
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
        User user =new User();
        if (userMapper.selectByPrimaryKey(userId) != null){
            user.setUserId(userId);
            user.setUserName(jsonObject.getString("serName"));
            user.setUserPhone(jsonObject.getString("userPhone"));
            user.setUserPass(jsonObject.getString("userPass"));
            user.setUserDepartment(jsonObject.getString("userDepartment"));
            user.setUserMajor(jsonObject.getString("userMajor"));
            user.setHeadImg(jsonObject.getString("HeadImg"));
            user.setNickname(jsonObject.getString("nickName"));
            user.setAutograph(jsonObject.getString("antugraph"));
            int returnint =userMapper.updateByPrimaryKeySelective(user);
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
        String stuId = jsonObject.getString("userId");
        User user = userMapper.selectByPrimaryKey(stuId);
        if (user!=null){
            returnJson.put("users",user);
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
        return jsonObject;
    }

    @Override
    public JSONObject userLogin(JSONObject jsonObject) {
        JSONObject returnmap = new JSONObject();
        String account = jsonObject.getString("userId");
        String password = jsonObject.getString("password");
        User user = userMapper.selectByPrimaryKey(account);
        if (user != null){
            String jdbcpassword = user.getUserPass();
            if (jdbcpassword.equals(password)) {
                returnmap.put("msg","");
                returnmap.put("status","200");
                returnmap.put("admin", user);
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
        String id= jsonObject.getString("adminId");
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null) {
            if (user.getUserPass().equals(oldpassword)){
                user.setUserPass(newpassword);
                int success = userMapper.updateByPrimaryKey(user);
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

    @Override
    public JSONObject addStuddents(List excelList) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try{
            for (int i = 0; i < excelList.size(); i++) {
                List list = (List) excelList.get(i);
                User user = new User();
                user.setUserId((String) list.get(0));
                user.setUserName((String) list.get(1));
                user.setUserPhone((String) list.get(2));
                user.setUserPass((String) list.get(3));
                user.setUserDepartment((String) list.get(4));
                user.setUserMajor((String) list.get(5));
                user.setHeadImg((String) list.get(6));
                user.setNickname((String) list.get(7));
                user.setAutograph((String) list.get(8));
                user.setUserType((String) list.get(9));
                User user1 =  userMapper.selectByPrimaryKey((String) list.get(0));
                if (user1 != null) {
                    if (userMapper.insert(user) > 0) {
                        jsonArray.add(user);
                    }
                }
            }
            if (jsonArray.size() > 0) {
                jsonObject.put("msg","");
                jsonObject.put("status","200");
                jsonObject.put("users",jsonArray);
            }
        } catch (Exception e) {
            jsonObject.put("msg","录入失败");
            jsonObject.put("status","500");
        }
        return jsonObject;
    }


}

