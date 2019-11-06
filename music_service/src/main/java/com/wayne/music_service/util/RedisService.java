package com.wayne.music_service.util;

/**
 * @Classname JsonService
 * @Description Hope No Bugs!
 * @Date 2019/4/24 22:35
 * @Created by wayne
 */
public interface RedisService {

    public  String hget(String key, String item);
    /**
     * set存数据
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * get获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置有效天数
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 移除数据
     * @param key
     * @return
     */
    boolean remove(String key);

}