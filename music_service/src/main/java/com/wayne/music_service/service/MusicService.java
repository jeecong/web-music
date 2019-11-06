package com.wayne.music_service.service;

import com.wayne.music_service.model.HotSong;
import com.wayne.music_service.model.PlaySong;
import com.wayne.music_service.model.SystemResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname MusicService
 * @Description Hope No Bugs!
 * @Date 2019/4/18 20:04
 * @Created by wayne
 */
public interface MusicService {
    List<HotSong> getRandomList();
    List<HotSong> getChenMusic();
    List<PlaySong> getSimilarSongs(String key);
    SystemResultStatus addMusicToList(String song, String user);
    List<HotSong> getUserPlaylist(String userId);
    List<PlaySong>  playUserPlaylist(String userId);
    List<PlaySong> getTodayMusic( String userId,  String day);
}
