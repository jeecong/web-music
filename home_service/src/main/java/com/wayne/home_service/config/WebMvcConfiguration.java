package com.wayne.home_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Classname WebMvcConfigration
 * @Description Hope No Bugs!
 * @Date 2019/4/18 12:10
 * @Created by wayne
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/head/**").addResourceLocations("classpath:/static/head/");
        registry.addResourceHandler("/song_pic/**").addResourceLocations("classpath:/static/son_pic/");
        super.addResourceHandlers(registry);
    }
}