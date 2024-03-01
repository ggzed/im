package com.ggzed.im.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ggzed.im.model.common.BaseModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.StringTypeHandler;

import java.util.List;

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
@Builder
@Accessors(chain = true)
@TableName(value = "role_info",autoResultMap = true)
public class RoleInfo extends BaseModel {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 编码
     */
    private String code;

    @TableField(typeHandler = StringTypeHandler.class)
    private List<String> menus;

    /**
     * 名称
     */
    private String name;
}
