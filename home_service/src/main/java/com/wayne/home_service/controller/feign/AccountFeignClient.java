package com.wayne.home_service.controller.feign;

import com.wayne.home_service.dto.SystemResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname HomeFeignClient
 * @Description Hope No Bugs!
 * @Date 2019/4/17 16:24
 * @Created by wayne
 */
@Component
@FeignClient(name = "account-service")
public interface AccountFeignClient {
    @RequestMapping(value = "/api/user/login",method= RequestMethod.POST)
    public String login(@RequestParam String username,
                              @RequestParam String password,
                              @RequestParam(required = false) String remember_me);
    @RequestMapping(value = "/api/user/check_username",method = RequestMethod.GET)
    String checkUsername(@RequestParam("username") String username);
    @RequestMapping(value = "/api/user/register",method= RequestMethod.POST)
    public String register(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String email,@RequestParam String nickname);
    @RequestMapping(value = "/api/user/get_user_info",method = RequestMethod.GET)
    String getUserInfo(@RequestParam("userId") String userId);
}
