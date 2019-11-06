package com.wayne.comment.service.impl;

import com.wayne.comment.DAO.CommentMapper;
import com.wayne.comment.model.Comment;
import com.wayne.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CommentServiceImpl
 * @Description Hope No Bugs!
 * @Date 2019/5/12 21:38
 * @Created by wayne
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> getSongComment(String songId) {
        List<Comment> comments = commentMapper.selectSongComment(songId);
//        System.out.println(comments.get(0).toString());
        return comments;
    }

    @Override
    public int addSongComment(String userId, String songId, String content) {
        Comment comment =new Comment();
        comment.setContent(content);
        comment.setPublish_time(System.currentTimeMillis());
        comment.setSong_id(Long.parseLong(songId));
        comment.setUser_id(Long.parseLong(userId));
        int insert = commentMapper.insert(comment);

        return insert;
    }
}
