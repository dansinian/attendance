package com.wsh.dao;

import com.wsh.entity.CourseArrangement;
import com.wsh.entity.CourseArrangementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseArrangementMapper {
    int countByExample(CourseArrangementExample example);

    int deleteByExample(CourseArrangementExample example);

    int deleteByPrimaryKey(String carmId);

    int insert(CourseArrangement record);

    int insertSelective(CourseArrangement record);

    List<CourseArrangement> selectByExample(CourseArrangementExample example);

    CourseArrangement selectByPrimaryKey(String carmId);

    int updateByExampleSelective(@Param("record") CourseArrangement record, @Param("example") CourseArrangementExample example);

    int updateByExample(@Param("record") CourseArrangement record, @Param("example") CourseArrangementExample example);

    int updateByPrimaryKeySelective(CourseArrangement record);

    int updateByPrimaryKey(CourseArrangement record);

    List<CourseArrangement> selectByCourNameLike(String couName);
}