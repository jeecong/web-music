package com.wayne.home_service.enum_class;

/**
 * @Classname SystemResultStatus
 * @Description Hope No Bugs!
 * @Date 2019/4/16 19:06
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

    public static  Status getEnumByKey(String key){
        if(null == key){
            return null;
        }
        for(Status temp:Status.values()){
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
