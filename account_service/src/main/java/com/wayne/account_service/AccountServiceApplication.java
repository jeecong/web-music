package com.wayne.account_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.wayne.account_service.DAO")
@EnableEurekaClient
@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[]  args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

}
