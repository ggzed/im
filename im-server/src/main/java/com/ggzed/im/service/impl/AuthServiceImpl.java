package com.ggzed.im.service.impl;

import cn.hutool.jwt.JWT;
import com.ggzed.im.common.constants.JwtConstant;
import com.ggzed.im.model.req.LoginReq;
import com.ggzed.im.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(LoginReq req) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        authenticationManager.authenticate(authenticationToken);
        //上一步没有抛出异常说明认证成功，我们向用户颁发jwt令牌
        return JWT.create()
                .setPayload("username", req.getUsername())
                .setKey(JwtConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))
                .sign();
    }
}
