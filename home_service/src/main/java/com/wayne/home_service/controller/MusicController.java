package com.wayne.home_service.controller;

import com.wayne.home_service.controller.feign.MusicFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MusicController
 * @Description Hope No Bugs!
 * @Date 2019/4/18 15:48
 * @Created by wayne
 */
@RestController
public class MusicController {
    @Autowired
    private MusicFeignClient musicFeignClient;
    @CrossOrigin
    @GetMapping(value = "/default_music")
    public String getRandomMusic(){
        String randomMusic = musicFeignClient.getRandomMusic();
        return randomMusic;
    }
    @CrossOrigin
    @GetMapping(value = "/user_music/{id}")
    public String getUserMusic(@PathVariable String  id){
        String userMusic = musicFeignClient.getUserMusic(id,"today");
        return userMusic;
    }
    @CrossOrigin
    @GetMapping(value = "/default_play_music")
    public String getRandomPlayList(){
        String randomPlayList = musicFeignClient.getRandomPlayList();
        return randomPlayList;
    }
    @CrossOrigin
    @GetMapping(value = "/similar_song/{songId}")
    public String getSimilarSong(@PathVariable String songId){
        String similarSong = musicFeignClient.getSimilarSong(songId);
        return similarSong;
    }
    @CrossOrigin
    @GetMapping(value = "/add_music_to_list/{user}/{song}")
    public String getSimilarSong(@PathVariable String user,@PathVariable String song){
        String similarSong = musicFeignClient.addMusicToList(song,user);
        return similarSong;
    }
    @CrossOrigin
    @GetMapping(value = "/user_playlist/{userId}")
    public String getUserPlaylist(@PathVariable String userId){
        String similarSong = musicFeignClient.getUserPlaylist(userId);
        return similarSong;
    }
    @CrossOrigin
    @GetMapping(value = "/play_user_playlist/{userId}")
    public String playUserPlaylist(@PathVariable String userId){
        String result = musicFeignClient.playUserPlaylist(userId);
        return result;
    }

    @CrossOrigin
    @GetMapping(value = "/delete_playlist_item/{userId}/{songId}")
    public String deletePlaylistItem(@PathVariable String userId,@PathVariable String songId){
        String result = musicFeignClient.deletePlaylistItem(userId,songId);
        return result;
    }
}
