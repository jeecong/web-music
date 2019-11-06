package com.wayne.music_service.model;

/**
 * @Classname SystemResultStatus
 * @Description Hope No Bugs!
 * @Date 2019/5/5 22:31
 * @Created by wayne
 */
public enum SystemResultStatus {
    SUCCESS("success","20"),FAIL("error","40");
    private final String description;
    private  final String key;
    //根据key获取枚举

    SystemResultStatus(String description, String key) {
        this.description = description;
        this.key = key;
    }

    public static SystemResultStatus getEnumByKey(String key){
        if(null == key){
            return null;
        }
        for(SystemResultStatus temp: SystemResultStatus.values()){
            if(temp.getKey().equals(key)){
                return temp;
            }
        }
        return null;
    }
    public String getKey() {
        return key;
    }
    public String getDescription() {
        return description;
    }
}

