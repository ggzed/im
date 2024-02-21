package com.ggzed.im.service;

import com.ggzed.im.model.req.LoginReq;

public interface AuthService {

    /**
     * 登录
     */
    String login(LoginReq loginReq);
}
