//package com.wayne.eureka_service.config;
//
//import com.wayne.eureka_service.intercept.EurekaIntercept;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @Classname WebAppConfig
// * @Description Hope No Bugs!
// * @Date 2019/4/3 14:53
// * @Created by wayne
// */
///**
// * 拦截无法满足需求  舍弃plain
// */
//@Configuration
//public class WebAppConfig extends WebMvcConfigurerAdapter {
//    private List<String> EXCLUDE_PATh= Arrays.asList("/","/statics","/login");
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new EurekaIntercept()).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATh);
//    }
//}
