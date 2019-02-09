package com.wsh.dao;

import com.wsh.entity.Reportcourse;
import com.wsh.entity.ReportcourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportcourseMapper {
    int countByExample(ReportcourseExample example);

    int deleteByExample(ReportcourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reportcourse record);

    int insertSelective(Reportcourse record);

    List<Reportcourse> selectByExample(ReportcourseExample example);

    Reportcourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reportcourse record, @Param("example") ReportcourseExample example);

    int updateByExample(@Param("record") Reportcourse record, @Param("example") ReportcourseExample example);

    int updateByPrimaryKeySelective(Reportcourse record);

    int updateByPrimaryKey(Reportcourse record);
}