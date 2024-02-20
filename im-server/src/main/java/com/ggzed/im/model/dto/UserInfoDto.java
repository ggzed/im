package com.ggzed.im.model.dto;

import com.ggzed.im.model.entity.UserInfo1;
import lombok.Data;

import java.util.List;

/**
 * 详细介绍类情况.
 *
 * @ClassName UserInfoDto
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */
@Data
public class UserInfoDto extends UserInfo1 {
    private List<String> roles;
}