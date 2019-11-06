package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
/**
 * @Classname JsonUtils
 * @Description Hope No Bugs!
 * @Date 2019/4/17 22:55
 * @Created by wayne
 */
public class JsonUtils {
  //todo log打印日志

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将对象序列化为JSON字符串
     *
     * @param object
     * @return JSON字符串
     */
    public static String serialize(Object object) {
        Writer write = new StringWriter();
        try {
            objectMapper.writeValue(write, object);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return write.toString();
    }

    /**
     * 将JSON字符串反序列化为对象
     *
     * @param object
     * @return JSON字符串
     */
    public static <T> T deserialize(String json, Class<T> clazz) {
        Object object = null;
        try {
            object = objectMapper.readValue(json, TypeFactory.rawClass(clazz));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T) object;
    }

    /**
     * 将JSON字符串反序列化为对象
     *
     * @param object
     * @return JSON字符串
     */
//    public static <T> T deserialize(String json, TypeReference<T> typeRef) {
//        try {
//            return (T) objectMapper.readValue(json, typeRef);
//        } catch (JsonParseException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}