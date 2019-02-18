package com.wsh.dao;

import com.wsh.entity.Student;
import com.wsh.entity.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectByNameLike(String Stuname);

    List<Student> selectByClassLike(String Stuclass);

    List<Student> selectByStuIdLike(String StuId);

    Student selectstuBystuId(String stuID,String stuClass);
}