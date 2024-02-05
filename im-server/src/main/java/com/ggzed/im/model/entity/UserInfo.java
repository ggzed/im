package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ggzed.im.model.common.BaseModel;
import lombok.Data;

/**
 * 用户信息.
 *
 * @ClassName UserInfo
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Data
@TableName("user_info")
public class UserInfo extends BaseModel {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}