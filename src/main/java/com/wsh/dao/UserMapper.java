package com.wsh.dao;

import com.wsh.entity.User;
import com.wsh.entity.UserExample;
import com.wsh.entity.UserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    List<UserWithBLOBs> selectByExampleWithBLOBs(UserExample example);

    List<User> selectByExample(UserExample example);

    UserWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserWithBLOBs record, @Param("example") UserExample example);

    int updateByExampleWithBLOBs(@Param("record") UserWithBLOBs record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);

    List<UserWithBLOBs> selectByNameLike(String content,String userType);

    List<UserWithBLOBs> selectByIdLike(String content,String userType);

    UserWithBLOBs selectByUserId(String userId);

    List<UserWithBLOBs> selectByUserName(String content);

    List<UserWithBLOBs> selectByUserIdList(String content);
}
