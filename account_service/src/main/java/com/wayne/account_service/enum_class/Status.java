package com.wayne.account_service.enum_class;

/**
 * @Classname Status
 * @Description Hope No Bugs!
 * @Date 2019/4/15 11:06
 * @Created by wayne
 */
public  enum Status {
    SUCCESS("success","100"),FAIL("error","200");
    private final String description;
    private  final String key;
    //根据key获取枚举

    Status(String description, String key) {
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
