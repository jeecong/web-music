package com.wayne.music_service.DAO;

import com.wayne.music_service.model.HotSong;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface HotSongMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotSong record);

    int insertSelective(HotSong record);

    HotSong selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotSong record);

    int updateByPrimaryKey(HotSong record);

    List<HotSong> selectRandomList();
}