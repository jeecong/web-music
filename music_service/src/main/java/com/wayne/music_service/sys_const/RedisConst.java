package com.wayne.music_service.sys_const;

/**
 * @Classname RedisConst
 * @Description Hope No Bugs!
 * @Date 2019/4/24 17:44
 * @Created by wayne
 */
public class RedisConst {
    private static String USER_PREFIX="USER::";
    private static String SONG_PREFIX="SONG::";
    private static String PLAYLIST_PREFIX="PLAYLIST::";
    public static String getUserPrefix(String id){
        return USER_PREFIX+id;
    }
    public static String getSongPrefix(String songId){
        return SONG_PREFIX+songId;
    }

    public static String getPlaylistPrefix(String userId) {
        return PLAYLIST_PREFIX+userId;
    }
    //    private static String getUserDayPrefix(String id ,String day){
//
//    }
}
