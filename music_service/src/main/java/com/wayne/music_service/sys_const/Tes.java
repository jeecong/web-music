package com.wayne.music_service.sys_const;

import com.alibaba.fastjson.JSONObject;

/**
 * @Classname Tes
 * @Description Hope No Bugs!
 * @Date 2019/4/24 23:48
 * @Created by wayne
 */
public class Tes {
    public static void main(String[] args) {
//        String s ="[28406532, 33337138, 450226681, 33241396, 31473269, 28949843, 439139710, 431610105, " +
//                "27906724, 33314587, 406086090, 31134193, 190042, 447279735, 431357712, 440241144, 421137034]";
//        int first=s.indexOf('[');
//        int tail=s.indexOf(']');
//
//        String str= "{\"result\":\"SUCCESS\",\"code\":200,\"data\":{\"id\":\"526307800\",\"name\":\"123我爱你\",\"singer\":\"新乐尘符\",\"pic\":\"http://p2.music.126.net/_LNk7rEEBSdAcnyHL8zi6Q==/109951163093399018.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=526307800&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=526307800&key=579621905\",\"time\":199}}";
//        JSONObject object = JSONObject.parseObject(str);
//        JSONObject result = (JSONObject)object.get("data");
//        Object wind_direction = result.getString("singer");
//        System.out.println(String.valueOf(wind_direction));
        System.out.println("1,2,3,4,".split(","));
        for (String i:"1,2,3,4,".split(",")){
            System.out.println("============="+i);
        }
    }
}
