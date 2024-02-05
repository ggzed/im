package com.ggzed.im.web;

import cn.hutool.jwt.JWT;
import com.ggzed.im.common.constants.JwtConstant;
import com.ggzed.im.model.req.LoginReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */

@Api(tags = "权限验证")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(@RequestBody LoginReq req){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        authenticationManager.authenticate(authenticationToken);

        //上一步没有抛出异常说明认证成功，我们向用户颁发jwt令牌
        String token = JWT.create()
                .setPayload("username", req.getUsername())
                .setKey(JwtConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))
                .sign();

        return token;
    }


}
