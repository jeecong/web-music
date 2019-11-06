package com.wayne.home_service.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname CommentFeign
 * @Description Hope No Bugs!
 * @Date 2019/5/12 21:28
 * @Created by wayne
 */
@Component
@FeignClient(name = "comment-service")
public interface CommentFeign {

    @RequestMapping(value = "/api/comment/get_song_comment",method= RequestMethod.GET)
    public String getSongComment(@RequestParam("songId") String songId);

    @RequestMapping(value = "/api/comment/add_song_comment",method= RequestMethod.GET)
    public String addSongComment(@RequestParam String userId,
                                 @RequestParam String songId,
                                 @RequestParam String content);
}
