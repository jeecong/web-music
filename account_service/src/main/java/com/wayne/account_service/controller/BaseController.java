package com.wayne.account_service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wayne.account_service.model.User;
import utils.MapCache;

import static com.wayne.account_service.system_const.SystemConst.SESSION_USER_KEY;


/**
 * @Classname BaseController
 * @Description Hope No Bugs!
 * @Date 2019/4/16 15:46
 * @Created by wayne
 */

public abstract class BaseController {


    protected MapCache cache = MapCache.single();


    public BaseController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }

    public BaseController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }

    /**
     * 获取请求绑定的登录对象
     * @param request
     * @return
     */
    public User getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return (User) session.getAttribute(SESSION_USER_KEY);
    }

    public Integer getUid(HttpServletRequest request){
        return this.getUser(request).getUser_id();
    }

    public String render_404() {
        return "comm/error_404";
    }

}


