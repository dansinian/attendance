package com.wsh.dao;

import com.wsh.entity.Isgocourse;
import com.wsh.entity.IsgocourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IsgocourseMapper {
    int countByExample(IsgocourseExample example);

    int deleteByExample(IsgocourseExample example);

    int insert(Isgocourse record);

    int insertSelective(Isgocourse record);

    List<Isgocourse> selectByExample(IsgocourseExample example);

    int updateByExampleSelective(@Param("record") Isgocourse record, @Param("example") IsgocourseExample example);

    int updateByExample(@Param("record") Isgocourse record, @Param("example") IsgocourseExample example);
}