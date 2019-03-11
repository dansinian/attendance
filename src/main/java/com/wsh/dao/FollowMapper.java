package com.wsh.dao;

import com.wsh.entity.Follow;
import com.wsh.entity.FollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FollowMapper {
    int countByExample(FollowExample example);

    int deleteByExample(FollowExample example);

    int insert(Follow record);

    int insertSelective(Follow record);

    List<Follow> selectByExample(FollowExample example);

    int updateByExampleSelective(@Param("record") Follow record, @Param("example") FollowExample example);

    int updateByExample(@Param("record") Follow record, @Param("example") FollowExample example);

    Follow selectFollw(String userId, String followed);

    List selectMyFollow(String content);

    List selectMyFans(String content);
}