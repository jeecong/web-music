package com.wayne.account_service.service;

import com.wayne.account_service.dto.Message;
import com.wayne.account_service.model.User;
import org.springframework.stereotype.Component;

/**
 * @Classname AccountService
 * @Description Hope No Bugs!
 * @Date 2019/4/16 17:25
 * @Created by wayne
 */

public interface AccountService {
    Message getUserByUsername(String username);
    Message getUserByUserId(String userId);
    Message addUser(User user);
}
