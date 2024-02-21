package com.ggzed.im.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.jwt.JWT;
import com.ggzed.im.common.constants.JwtConstant;
import com.ggzed.im.common.exception.UserNotExistException;
import com.ggzed.im.common.result.ResultEnum;
import com.ggzed.im.model.entity.UserInfo;
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
import java.util.Objects;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserVo getById(Long id) {
        UserInfo userInfo = userInfoRepository.getById(id);
        if (Objects.isNull(userInfo)){
            throw new UserNotExistException(ResultEnum.USER_NOT_EXIST);
        }
        return Convert.convert(UserVo.class, userInfo);
    }
}
