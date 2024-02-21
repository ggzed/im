package com.ggzed.im.web;

import com.ggzed.im.common.result.Result;
import com.ggzed.im.model.vo.UserVo;
import com.ggzed.im.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

/**
 * 详细介绍类情况.
 *
 * @ClassName UserController
 * @Author ggzed
 * @Date 2024/2/5
 * @Version 1.0
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("根据id获取")
    @PostMapping("/{id}")
    public UserVo login(@PathVariable Long id) throws Exception {
        return userInfoService.getById(id);
    }
}
