package com.wayne.comment.DAO;

import com.wayne.comment.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectSongComment(String songId);
}