package com.wayne.home_service.controller;

import com.wayne.home_service.controller.feign.CommentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname CommentController
 * @Description Hope No Bugs!
 * @Date 2019/5/12 21:30
 * @Created by wayne
 */

@RestController
public class CommentController {
    @Autowired
    private CommentFeign commentFeign;

    @CrossOrigin
    @GetMapping(value = "/get_song_comment/{song_id}")
    public String getUserMusic(@PathVariable String  song_id){
        String songComment = commentFeign.getSongComment(song_id);
        return songComment;
    }
    @CrossOrigin  //points :让前端可以实现跨域请求
    @PostMapping(value = "/add_song_comment")
    public String  login(@RequestParam String userId,
                         @RequestParam String songId,
                         @RequestParam String content
    ){

        String  login = commentFeign.addSongComment(userId,songId,content);
        return login;
//        String result = JsonUtils.serialize(login);
//        return result;

    }
}
