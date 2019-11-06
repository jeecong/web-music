package com.wayne.music_service.controller;

import com.wayne.music_service.model.HotSong;
import com.wayne.music_service.model.PlaySong;
import com.wayne.music_service.model.SystemResult;
import com.wayne.music_service.model.SystemResultStatus;
import com.wayne.music_service.service.JsonService;
import com.wayne.music_service.service.MusicService;
import com.wayne.music_service.sys_const.RedisConst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.JsonUtils;

import java.util.*;

import static com.wayne.music_service.model.SystemResultStatus.SUCCESS;

/**
 * @Classname MusicController
 * @Description Hope No Bugs!
 * @Date 2019/4/18 14:51
 * @Created by wayne
 */
@RequestMapping("/api/music")
@RestController
public class MusicController {

    @Autowired
    JsonService jsonService;
    @Autowired
    RedisTemplate<String, String> redisUtil;
    @Autowired
    MusicService musicService;

    @GetMapping(value = "/random_list")
    private String getRandomList() {
        List<HotSong> randomList = musicService.getRandomList();
        return JsonUtils.serialize(randomList);
    }

    @GetMapping(value = "/random_play_list")
    private String getRandomPlayList() {
        List<HotSong> randomList = musicService.getRandomList();
        List<PlaySong> playSongs = convertToPlaySong(randomList);
        return JsonUtils.serialize(playSongs);
    }

    private List<PlaySong> convertToPlaySong(List<HotSong> list) {
        List<PlaySong> result = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            HotSong song = (HotSong) iterator.next();
            PlaySong playSong = new PlaySong();
            playSong.setArtist(song.getSonger());
            playSong.setTitle(song.getSong_name());
            playSong.setMp3("https://api.bzqll.com/music/netease/url?key=579621905&id=" + song.getSong_id() + "&br=999000");
            playSong.setCover(" https://api.bzqll.com/music/netease/pic?key=579621905&id=" + song.getSong_id());
            playSong.setBuy("#");
            playSong.setDuration(song.getSonger());
            playSong.setOga("");
            playSong.setPrice("");
            playSong.setRating(song.getSong_id());
            result.add(playSong);
        }
        return result;
    }

    /**
     * todo  抽到service 层
     *
     * @param userId
     * @param day
     * @return
     */
    @GetMapping(value = "/user_today_music")
    private String getTodayMusic(@RequestParam("id") String userId, @RequestParam(required = false) String day) {
        SystemResult systemResult = new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        if (userId == null) {
            systemResult.setExtension("输入的参数不允许为空");
            return JsonUtils.serialize(systemResult);
        }
        String userPrefix = RedisConst.getUserPrefix(userId);
        System.out.println(userPrefix);
        day="2019.04.24";
        Boolean aBoolean = redisUtil.opsForHash().hasKey(userPrefix, day);
//        System.out.println(aBoolean);
        if (aBoolean == true) {
            List<PlaySong> todayMusic = musicService.getTodayMusic(userId, day);
            if (todayMusic.size() != 0) {
                return JsonUtils.serialize(todayMusic);
            }
        }
        //冷启动 新用户 来了 由于数据原始缺陷 所以不能做精确推荐  只能推荐一些热门歌曲
        System.out.println("冷启动！");
        List<HotSong> randomList = musicService.getRandomList();
        List<PlaySong> result = convertToPlaySong(randomList);
        if (result.size() != 0) {
            return JsonUtils.serialize(result);
        }
        systemResult.setExtension("未能获取数据");
        return JsonUtils.serialize(systemResult);

    }

    @GetMapping(value = "/music_similar_song")
    public String getSimilaritySong(@RequestParam("songId") String songId) {
        SystemResult systemResult = new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        if (songId != null) {
            String key = RedisConst.getSongPrefix(songId);
            if (redisUtil.opsForValue().size(key) == 0) {
                //新歌曲 或者是因为原始数据不够没有训练的歌曲
                List<HotSong> randomList = musicService.getRandomList();
                List<PlaySong> result = convertToPlaySong(randomList);
                if (result.size() != 0) {
                    //枚举设计不合理  此处先这样处理
                    systemResult.setExtension("201");
                    systemResult.setStatus(SUCCESS);
                    systemResult.setObject(result);
                    return JsonUtils.serialize(systemResult);
                }

            }
            List<PlaySong> similarSongs = musicService.getSimilarSongs(key);
            if (similarSongs.size() != 0) {
                systemResult.setStatus(SUCCESS);
                systemResult.setObject(similarSongs);
                return JsonUtils.serialize(systemResult);
            }

        }

        systemResult.setExtension("输入的参数不允许为空");
        return JsonUtils.serialize(systemResult);
    }

    @GetMapping(value = "/add_music_to_list")
    public String addMusicToList(@RequestParam("song") String song, @RequestParam("user") String user) {
        SystemResult systemResult = new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        if (song == null || user == null) {
            systemResult.setExtension("输入的参数不允许为空");
            return JsonUtils.serialize(systemResult);
        }
        SystemResultStatus systemResultStatus = musicService.addMusicToList(song, user);
        if (systemResultStatus == SUCCESS) {
            systemResult.setStatus(SUCCESS);
            systemResult.setExtension("成功");
            return JsonUtils.serialize(systemResult);
        } else {
            return JsonUtils.serialize(systemResult);
        }

    }

    @GetMapping(value = "/user_playlist")
    public String getUserPlaylist(@RequestParam("userId") String userId) {
        SystemResult systemResult = new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        if (userId == null) {
            systemResult.setExtension("输入的参数不允许为空");
            return JsonUtils.serialize(systemResult);
        }
        List<HotSong> userPlaylist = musicService.getUserPlaylist(userId);
        return JsonUtils.serialize(userPlaylist);


    }

    @GetMapping(value = "/play_user_playlist")
    public String playUserPlaylist(@RequestParam("userId") String userId) {
        SystemResult systemResult = new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        if (userId == null) {
            systemResult.setExtension("输入的参数不允许为空");
            return JsonUtils.serialize(systemResult);
        }
        List<PlaySong> userPlaylist = musicService.playUserPlaylist(userId);
        return JsonUtils.serialize(userPlaylist);


    }

    @GetMapping(value = "/delete_playlist_item")
    public String deletePlaylistItem(@RequestParam("userId") String userId, @RequestParam("songId") String songId) {
        SystemResult systemResult = new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        String key = RedisConst.getPlaylistPrefix(userId);
        String newStr="";
        if (songId != null && userId != null) {

            String s = redisUtil.opsForValue().get(key);
            String[] split = s.split(",");

            for (String str :split){
                if (!str.equals(songId)){
                    String songStr=str+",";
                    newStr=newStr+songStr;
                }

            }

            redisUtil.opsForValue().set(key,newStr);
            systemResult.setStatus(SUCCESS);

            systemResult.setExtension("200");
            return JsonUtils.serialize(systemResult);
        }

        systemResult.setExtension("输入的参数不允许为空");
        return JsonUtils.serialize(systemResult);


    }
}
