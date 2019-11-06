package com.wayne.home_service.controller;

import com.wayne.home_service.controller.feign.AccountFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname HomeController
 * @Description Hope No Bugs!
 * @Date 2019/4/16 19:16
 * @Created by wayne
 */
@RestController
public class AccountController extends BaseController {
    @Autowired
    private AccountFeignClient accountFeignClient;
//    引入feign不需要显式调用
//    @Autowired
//    private RestTemplate restTemplate;
//

    @CrossOrigin  //points :让前端可以实现跨域请求
    @PostMapping(value = "/login")
    public String  login(@RequestParam String username,
                              @RequestParam String password,
                              @RequestParam(required = false) String remeber_me
                              ){

        String  login = accountFeignClient.login(username, password, remeber_me);
        return login;
//        String result = JsonUtils.serialize(login);
//        return result;

    }
    @CrossOrigin
    @RequestMapping(value = "/check_username/{username}",method= RequestMethod.GET)
    public String checkUsername(@PathVariable  String username){
        String s = accountFeignClient.checkUsername(username);
        return s;
    }
    @CrossOrigin
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email,@RequestParam String nickname){
        String register = accountFeignClient.register(username, password, email, nickname);
        return register;
    }

    @CrossOrigin
    @RequestMapping(value = "/get_user_info/{userId}",method= RequestMethod.GET)
    public String getUserInfo(@PathVariable  String userId){
        String s = accountFeignClient.getUserInfo(userId);
        return s;
    }

}
