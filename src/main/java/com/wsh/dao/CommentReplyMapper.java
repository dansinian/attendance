package com.wsh.dao;

import com.wsh.entity.CommentReply;
import com.wsh.entity.CommentReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentReplyMapper {
    int countByExample(CommentReplyExample example);

    int deleteByExample(CommentReplyExample example);

    int deleteByPrimaryKey(String commentId);

    int insert(CommentReply record);

    int insertSelective(CommentReply record);

    List<CommentReply> selectByExample(CommentReplyExample example);

    CommentReply selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("record") CommentReply record, @Param("example") CommentReplyExample example);

    int updateByExample(@Param("record") CommentReply record, @Param("example") CommentReplyExample example);

    int updateByPrimaryKeySelective(CommentReply record);

    int updateByPrimaryKey(CommentReply record);
}