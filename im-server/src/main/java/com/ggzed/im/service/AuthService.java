package com.ggzed.im.service;

import com.ggzed.im.model.req.LoginReq;
import com.ggzed.im.model.req.RegisterReq;

public interface AuthService {

    /**
     * 登录
     */
    String login(LoginReq loginReq);

    void register(RegisterReq req);
}
