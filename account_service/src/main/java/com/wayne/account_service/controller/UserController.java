package com.wayne.account_service.controller;

import com.wayne.account_service.dto.Message;
import com.wayne.account_service.dto.SystemResult;
import com.wayne.account_service.enum_class.Status;
import com.wayne.account_service.enum_class.SystemResultStatus;
import com.wayne.account_service.model.User;
import com.wayne.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname HomeController
 * @Description Hope No Bugs!
 * @Date 2019/4/15 14:32
 * @Created by wayne
 */
@RequestMapping("/api/user")
@RestController
public class UserController extends BaseController{
    @Autowired
    private AccountService accountService;
    @PostMapping(value = "/login")
    private SystemResult login(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam(required = false) String remeber_me){
        Message message = accountService.getUserByUsername(username);
        SystemResult systemResult=new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
//        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+message.getStatus());
//        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+message.toString());
        //todo  MD5 加密
        if (message.getStatus()== SystemResultStatus.SUCCESS&& message.getExtension().equals(password)){
            systemResult.setObject(message.getObject());
            systemResult.setStatus(SystemResultStatus.SUCCESS);
        }
        System.out.println(systemResult.toString());
        return systemResult;
    }
    @GetMapping(value = "/check_username")
    private  SystemResult checkUsername(String username){
        Message userByUsername = accountService.getUserByUsername(username);

        SystemResult systemResult=new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        if (userByUsername.getStatus()== SystemResultStatus.SUCCESS){
            systemResult.setObject(userByUsername.getObject());
            systemResult.setStatus(SystemResultStatus.SUCCESS);
        }
        return systemResult;
    }
    @PostMapping(value = "/register")
    private SystemResult register(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam String email,@RequestParam String nickname){
        User user =new User();
        user.setCreateTime(String.valueOf(System.currentTimeMillis()));
        user.setEmail(email);
        user.setNickName(nickname);
        user.setUserName(username);
        user.setPassword(password);
        //default headimg
        user.setHeadUrl("head/devoleper.jpg");
        Message message = accountService.addUser(user);
        SystemResult systemResult=new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        if (message.getStatus()== SystemResultStatus.SUCCESS){
            systemResult.setStatus(SystemResultStatus.SUCCESS);
        }
        return systemResult;
    }
    @GetMapping(value = "/get_user_info")
    private  SystemResult getUserInfo(String userId){
        Message userByUsername = accountService.getUserByUserId(userId);

        SystemResult systemResult=new SystemResult();
        systemResult.setStatus(SystemResultStatus.FAIL);
        if (userByUsername.getStatus()== SystemResultStatus.SUCCESS){
            systemResult.setObject(userByUsername.getObject());
            systemResult.setStatus(SystemResultStatus.SUCCESS);
            systemResult.setExtension(userByUsername.getExtension());
        }
        return systemResult;
    }


}
