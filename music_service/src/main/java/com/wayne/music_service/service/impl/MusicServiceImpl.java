package com.wayne.music_service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wayne.music_service.DAO.HotSongMapper;
import com.wayne.music_service.controller.feign.AccountFeignClient;
import com.wayne.music_service.model.HotSong;
import com.wayne.music_service.model.PlaySong;
import com.wayne.music_service.model.SystemResultStatus;
import com.wayne.music_service.service.JsonService;
import com.wayne.music_service.service.MusicService;
import com.wayne.music_service.sys_const.RedisConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Classname MusicServiceImpl
 * @Description Hope No Bugs!
 * @Date 2019/4/18 20:05
 * @Created by wayne
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    AccountFeignClient accountFeignClient;

    @Autowired
    RedisTemplate<String, String> redisUtil;
    @Autowired
    JsonService jsonService;

    @Autowired
    private HotSongMapper hotSongMapper;
    @Override
    public List<HotSong> getRandomList() {
        List<HotSong> hotSongs = hotSongMapper.selectRandomList();
        Iterator iterator=hotSongs.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next.toString());
        }
        return hotSongs;
    }
    //测试方法
    @Override
    public List<HotSong> getChenMusic(){
//        List<HotSong> chenMusic = hotSongMapper.selectChenMusic();
        return null;
    }

    /**
     * todo 抽离redis
     * @return
     */
    @Override
    public List<PlaySong> getSimilarSongs(String key) {
        List<PlaySong> result = new ArrayList<>();
        Object hget = redisUtil.opsForValue().get(key);
        if (hget != null) {
            int first = hget.toString().indexOf('[');
            int tail = hget.toString().indexOf(']');
            String[] split = hget.toString().substring(first + 1, tail).split(",");
            List<String> strings = Arrays.asList(split);
            Iterator iterator = strings.iterator();
            while (iterator.hasNext()) {
                int next = Integer.parseInt(((String)iterator.next()).replaceAll(" ",""));
                String url = "https://api.bzqll.com/music/netease/song?key=579621905&id="+next;
                String json = jsonService.loadJSON(url);
                if (json.hashCode()!=0){
//                        System.out.println("2222222222"+json);
                    JSONObject object = JSONObject.parseObject(json);
//                        System.out.println("33333333333"+object.toJSONString());
                    if (object.getInteger("code")==200){
                        JSONObject data = (JSONObject)object.get("data");
                        String name =data.getString("name");
                        String singer=data.getString("singer");
                        PlaySong playSong = new PlaySong();
                        playSong.setArtist(singer);
                        playSong.setTitle(name);
                        playSong.setMp3("https://api.bzqll.com/music/netease/url?key=579621905&id=" +next + "&br=999000");
                        playSong.setCover(" https://api.bzqll.com/music/netease/pic?key=579621905&id=" + next);
                        playSong.setBuy("#");
                        playSong.setDuration(singer);
                        playSong.setOga("");
                        playSong.setPrice("");
                        playSong.setRating(String.valueOf(next));
                        result.add(playSong);
                    }
                }
            }
        }
        return  result;
    }

    @Override
    public SystemResultStatus addMusicToList(String song, String user) {
        String res = accountFeignClient.checkUsername(user);
        System.out.println(res);
        JSONObject object = JSONObject.parseObject(res);
//        System.out.println(object);0
        JSONObject data = (JSONObject)object.get("object");
        String userId = data.getString("user_id");
//        System.out.println();

        String key= RedisConst.getPlaylistPrefix(userId);
        System.out.println(key);
        System.out.println(redisUtil.opsForValue().get(key));
        Object hget = redisUtil.opsForValue().append(key,song+",");
        System.out.println(redisUtil.opsForValue().get(key));
//        System.out.println("======================"+hget);
        if ((Integer) hget!=0){
            return  SystemResultStatus.SUCCESS;
        }
        return  SystemResultStatus.FAIL;

    }

    @Override
    public List<HotSong> getUserPlaylist(String userId) {
        List<HotSong> result=new ArrayList<>();
        String key= RedisConst.getPlaylistPrefix(userId);
        Object hget = redisUtil.opsForValue().get(key);
        System.out.println(key);
        System.out.println(redisUtil.opsForValue().get(key));
        if (hget!=null){
            String[] split = hget.toString().split(",");
            List<String> strings = Arrays.asList(split);
            Iterator iterator = strings.iterator();

            while (iterator.hasNext()) {
                int next = Integer.parseInt(((String)iterator.next()).replaceAll(" ",""));
//            if (next)
                String url = "https://api.bzqll.com/music/netease/song?key=579621905&id="+next;
                String json = jsonService.loadJSON(url);
                if (json.hashCode()!=0){
//                        System.out.println("2222222222"+json);
                    JSONObject object = JSONObject.parseObject(json);
//                        System.out.println("33333333333"+object.toJSONString());
                    if (object.getInteger("code")==200){
                        JSONObject data = (JSONObject)object.get("data");
                        String name =data.getString("name");
                        String singer=data.getString("singer");
                        HotSong hotSong = new HotSong();
//                    hotSong.setId(Long.parseLong(String.valueOf(next)));
                        hotSong.setSong_id(String.valueOf(next));
                        hotSong.setSong_name(name);
                        hotSong.setSonger(singer);
                        result.add(hotSong);

                    }
                }
            }

        }
        return result;
//        System.out.println(hget);

    }

    @Override
    public List<PlaySong> playUserPlaylist(String userId) {
        List<PlaySong> result = new ArrayList<>();
        String key= RedisConst.getPlaylistPrefix(userId);
        Object hget = redisUtil.opsForValue().get(key);
        if (hget != null) {

            String[] split = hget.toString().split(",");
            List<String> strings = Arrays.asList(split);
            Iterator iterator = strings.iterator();
            while (iterator.hasNext()) {
                int next = Integer.parseInt(((String)iterator.next()).replaceAll(" ",""));
                String url = "https://api.bzqll.com/music/netease/song?key=579621905&id="+next;
                String json = jsonService.loadJSON(url);
                if (json.hashCode()!=0){
//                        System.out.println("2222222222"+json);
                    JSONObject object = JSONObject.parseObject(json);
//                        System.out.println("33333333333"+object.toJSONString());
                    if (object.getInteger("code")==200){
                        JSONObject data = (JSONObject)object.get("data");
                        String name =data.getString("name");
                        String singer=data.getString("singer");
                        PlaySong playSong = new PlaySong();
                        playSong.setArtist(singer);
                        playSong.setTitle(name);
                        playSong.setMp3("https://api.bzqll.com/music/netease/url?key=579621905&id=" +next + "&br=999000");
                        playSong.setCover(" https://api.bzqll.com/music/netease/pic?key=579621905&id=" + next);
                        playSong.setBuy("#");
                        playSong.setDuration(singer);
                        playSong.setOga("");
                        playSong.setPrice("");
                        playSong.setRating(String.valueOf(next));
                        result.add(playSong);
                    }
                }
            }
        }
        return  result;
    }

    @Override
    public List<PlaySong> getTodayMusic(String userId, String day) {

            List<PlaySong> result = new ArrayList<>();
            String key = RedisConst.getUserPrefix(userId);
            Date now = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
            String format = ft.format(now);
            day = "2019.04.24";
            Object hget = redisUtil.opsForHash().get(key, day);
//            System.out.println("==================================================================");
//            System.out.println(format);
//            System.out.println(hget);

            if (hget != null) {
                int first = hget.toString().indexOf('[');
                int tail = hget.toString().indexOf(']');
                String[] split = hget.toString().substring(first + 1, tail).split(",");
                List<String> strings = Arrays.asList(split);
                Collections.shuffle(strings);
                int count = 0;
                Iterator iterator = strings.iterator();
                while (iterator.hasNext() && count < 20) {
                    count++;
                    int next = Integer.parseInt(((String) iterator.next()).replaceAll(" ", ""));
                    String url = "https://api.bzqll.com/music/netease/song?key=579621905&id=" + next;
                    String json = jsonService.loadJSON(url);
//                    System.out.println("11111111111"+json);
                    if (json.hashCode() != 0) {
//                        System.out.println("2222222222"+json);
                        JSONObject object = JSONObject.parseObject(json);
//                        System.out.println("33333333333"+object.toJSONString());
                        if (object.getInteger("code") == 200) {
                            JSONObject data = (JSONObject) object.get("data");
                            String name = data.getString("name");
                            String singer = data.getString("singer");
                            PlaySong playSong = new PlaySong();
                            playSong.setArtist(singer);
                            playSong.setTitle(name);
                            playSong.setMp3("https://api.bzqll.com/music/netease/url?key=579621905&id=" + next + "&br=999000");
                            playSong.setCover(" https://api.bzqll.com/music/netease/pic?key=579621905&id=" + next);
                            playSong.setBuy("#");
                            playSong.setDuration(singer);
                            playSong.setOga("");
                            playSong.setPrice("");
                            playSong.setRating(String.valueOf(next));
                            result.add(playSong);
                        }
                    }


                }
                return result;
            }
            //todo redis 挂了
            return result;
        }


}
