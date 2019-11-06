package com.wayne.account_service.service.service_impl;

import com.wayne.account_service.DAO.UserMapper;
import com.wayne.account_service.dto.Message;
import com.wayne.account_service.enum_class.Status;
import com.wayne.account_service.enum_class.SystemResultStatus;
import com.wayne.account_service.model.User;
import com.wayne.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Classname AccountServiceImpl
 * @Description Hope No Bugs!
 * @Date 2019/4/16 17:37
 * @Created by wayne
 */
@Service
public class AccountServiceImpl  implements AccountService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Message getUserByUsername(String username) {
        Message message = new Message();
        User user = userMapper.selectUserByUsername(username);
        message.setStatus(SystemResultStatus.FAIL);
        if (user!=null){
            message.setObject(user);
            message.setExtension(user.getPassword());
            message.setStatus(SystemResultStatus.SUCCESS);
        }
        return message;
    }

    @Override
    public Message addUser(User user) {
        Message message=new Message();
        int insert = userMapper.insert(user);
        message.setStatus(SystemResultStatus.FAIL);
        if (insert ==1){
            message.setStatus(SystemResultStatus.SUCCESS);
        }
        return message;

    }

    @Override
    public Message getUserByUserId(String userId) {
        Message message=new Message();
        message.setStatus(SystemResultStatus.FAIL);
        User user = userMapper.selectByUserId(userId);
        if (user !=null){
            message.setStatus(SystemResultStatus.SUCCESS);
            message.setExtension("{"+"\"name\":\""+user.getNickName()+"\",\"head_url\":\""+user.getHeadUrl()+"\"}");
        }
        return message;

    }
}
