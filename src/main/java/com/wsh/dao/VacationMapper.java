package com.wsh.dao;

import com.wsh.entity.Vacation;
import com.wsh.entity.VacationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VacationMapper {
    int countByExample(VacationExample example);

    int deleteByExample(VacationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Vacation record);

    int insertSelective(Vacation record);

    List<Vacation> selectByExample(VacationExample example);

    Vacation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Vacation record, @Param("example") VacationExample example);

    int updateByExample(@Param("record") Vacation record, @Param("example") VacationExample example);

    int updateByPrimaryKeySelective(Vacation record);

    int updateByPrimaryKey(Vacation record);

    List<Vacation> selectByLeaveIdLike(String leaveId);

    List<Vacation> selectByStuNameLike(String StuName);
}