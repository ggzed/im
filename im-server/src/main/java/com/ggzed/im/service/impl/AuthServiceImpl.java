package com.ggzed.im.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWT;
import com.ggzed.im.common.constants.JwtConstant;
import com.ggzed.im.common.exception.BizException;
import com.ggzed.im.common.result.ResultEnum;
import com.ggzed.im.model.entity.AuthInfo;
import com.ggzed.im.model.req.LoginReq;
import com.ggzed.im.model.req.RegisterReq;
import com.ggzed.im.repository.AuthInfoRepository;
import com.ggzed.im.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private AuthInfoRepository authInfoRepository;

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

    @Override
    public void register(RegisterReq req) {
        AuthInfo exist = authInfoRepository.getByUsername(req.getUsername());
        if (Objects.nonNull(exist)) {
            throw new BizException(ResultEnum.USER_HAS_EXISTED);
        }
       String userId =  IdUtil.simpleUUID();
        AuthInfo authInfo = AuthInfo.builder()
                .userId(userId)
                .username(req.getUsername())
                .password(req.getPassword()).build();
        authInfoRepository.save(authInfo);
    }
}
