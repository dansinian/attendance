package com.wsh.service.Impl;

import com.wsh.dao.AdminMapper;
import com.wsh.entity.*;
import com.wsh.service.AdminService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public JSONObject loginAdmin(JSONObject jsonObject) throws Exception{
        JSONObject returnmap = new JSONObject();
        String account = jsonObject.getString("adminId");
        String password = jsonObject.getString("passWord");
        Admin admin = adminMapper.selectByPrimaryKey(account);
            if (admin != null){
                String jdbcpassword = admin.getAdminPass();
                if (jdbcpassword.equals(password)) {
                    returnmap.put("msg","");
                    returnmap.put("status","200");
                    returnmap.put("admin", admin);
                } else {
                    returnmap.put("msg","密码错误");
                    returnmap.put("status","500");
                }
            }else {
                returnmap.put("status","500");
                returnmap.put("msg","用户名不存在");
            }
        return returnmap;
    }

    @Override
    public JSONObject updatePass(JSONObject jsonObject) {
        JSONObject returnJson = new JSONObject();
        String oldpassword = jsonObject.getString("oldpass");
        String newpassword = jsonObject.getString("newpass");
        String id= jsonObject.getString("adminId");
        Admin admin = adminMapper.selectByPrimaryKey(id);
            if (admin != null) {
                if (admin.getAdminPass().equals(oldpassword)){
                    admin.setAdminPass(newpassword);
                    int success = adminMapper.updateByPrimaryKey(admin);
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
}
