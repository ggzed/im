package com.ggzed.im.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.jwt.JWT;
import com.ggzed.im.common.constants.JwtConstant;
import com.ggzed.im.model.req.LoginReq;
import com.ggzed.im.model.vo.UserVo;
import com.ggzed.im.repository.UserInfoRepository;
import com.ggzed.im.service.AuthService;
import com.ggzed.im.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserVo getById(Long id) {
        return Convert.convert(UserVo.class, userInfoRepository.getById(id));
    }
}
