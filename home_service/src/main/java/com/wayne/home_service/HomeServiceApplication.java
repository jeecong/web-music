package com.wayne.home_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HomeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeServiceApplication.class, args);
    }
//    @LoadBalanced  feign整合了ribbon负载均衡
//    @Bean   static/head/devoleper.jpg
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//  }
}
