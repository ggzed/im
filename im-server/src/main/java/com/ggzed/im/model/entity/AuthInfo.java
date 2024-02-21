package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ggzed.im.model.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限信息
 * </p>
 *
 * @author ggzed
 * @since 2024-02-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("auth_info")
public class AuthInfo extends BaseModel {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
