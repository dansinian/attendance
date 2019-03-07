package com.wsh.dao;

import com.wsh.entity.CommentReply;
import com.wsh.entity.CommentReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentReplyMapper {
    int countByExample(CommentReplyExample example);

    int deleteByExample(CommentReplyExample example);

    int insert(CommentReply record);

    int insertSelective(CommentReply record);

    List<CommentReply> selectByExample(CommentReplyExample example);

    int updateByExampleSelective(@Param("record") CommentReply record, @Param("example") CommentReplyExample example);

    int updateByExample(@Param("record") CommentReply record, @Param("example") CommentReplyExample example);

    int deleteByReplyId(String replyId);

    CommentReply selectByRepId(String replyId);
}