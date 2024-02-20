package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ggzed.im.model.common.BaseModel;
import lombok.Data;

/**
 * 用户权限关联表.
 *
 * @ClassName UserInfo
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Data
@TableName("user_role")
public class UserRole extends BaseModel {

}