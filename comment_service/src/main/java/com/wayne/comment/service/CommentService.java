package com.wayne.comment.service;

import com.wayne.comment.model.Comment;

import java.util.List;

/**
 * @Classname CommentService
 * @Description Hope No Bugs!
 * @Date 2019/5/12 21:38
 * @Created by wayne
 */

public interface CommentService {
    List<Comment> getSongComment(String songId);
    int addSongComment(String userId, String songId ,String content );
}
