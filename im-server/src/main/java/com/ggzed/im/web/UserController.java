package com.ggzed.im.web;

import com.ggzed.im.model.vo.UserVo;
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
    AuthenticationManager authenticationManager;

    @ApiOperation("根据id获取")
    @PostMapping("/{id}")
    public UserVo login(@PathVariable Long id) throws Exception {
        if (id == 1){
            throw new Exception("sss");
        }

        return UserVo.builder().build();
    }


}
