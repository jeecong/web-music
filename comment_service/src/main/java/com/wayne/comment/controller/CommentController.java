package com.wayne.comment.controller;

import com.wayne.comment.model.Comment;
import com.wayne.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.JsonUtils;

import java.util.List;

/**
 * @Classname CommentController
 * @Description Hope No Bugs!
 * @Date 2019/5/12 21:32
 * @Created by wayne
 */
@RequestMapping("/api/comment")
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping(value = "/get_song_comment")
    public String getSimilaritySong(@RequestParam("songId") String songId) {
        List<Comment> songComment = commentService.getSongComment(songId);

        return JsonUtils.serialize(songComment);

    }

    @GetMapping(value = "/add_song_comment")
    public String getSimilaritySong(@RequestParam String userId,
                                    @RequestParam String songId,
                                    @RequestParam String content) {
        int i = commentService.addSongComment(userId, songId, content);
        if (i!=0){
            return "SUCCESS";
        }
        //todo  枚举
        return "FAIL";

    }
}
