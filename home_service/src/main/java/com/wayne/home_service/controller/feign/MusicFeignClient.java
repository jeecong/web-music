package com.wayne.home_service.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Classname MusicFeignClient
 * @Description Hope No Bugs!
 * @Date 2019/4/18 15:41
 * @Created by wayne
 */
@Component
@FeignClient(name = "music-service")
public interface MusicFeignClient {
    @RequestMapping(value = "/api/music/random_list",method= RequestMethod.GET)
    public String getRandomMusic();

    @RequestMapping(value = "/api/music/user_today_music",method= RequestMethod.GET)
    public String getUserMusic(@RequestParam("id") String  userId,@RequestParam(required = false) String day);

    @RequestMapping(value = "/api/music/random_play_list",method= RequestMethod.GET)
    public String getRandomPlayList();

    @RequestMapping(value = "/api/music/music_similar_song",method= RequestMethod.GET)
    public String getSimilarSong(@RequestParam("songId") String songId);

    @RequestMapping(value = "/api/music/add_music_to_list",method= RequestMethod.GET)
    public String addMusicToList(@RequestParam("song") String song,@RequestParam("user") String user);

    @RequestMapping(value = "/api/music/user_playlist",method= RequestMethod.GET)
    public String getUserPlaylist(@RequestParam("userId") String userId);


    @RequestMapping(value = "/api/music/play_user_playlist",method= RequestMethod.GET)
    public String playUserPlaylist(@RequestParam("userId") String userId);

    @RequestMapping(value = "/api/music/delete_playlist_item",method= RequestMethod.GET)
    public String deletePlaylistItem(@RequestParam("userId") String userId,@RequestParam("songId") String songId);
}
