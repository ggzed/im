package com.ggzed.im.web;

import com.ggzed.im.model.req.LoginReq;
import com.ggzed.im.model.req.RegisterReq;
import com.ggzed.im.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */

@Api(tags = "权限验证")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(@RequestBody LoginReq req) {
        return authService.login(req);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public void register(@RequestBody RegisterReq req) {
        authService.register(req);
    }
}
