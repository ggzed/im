package com.ggzed.im.mode.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * 详细介绍类情况.
 *
 * @ClassName BaseModel
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseModel {

    /**
     * 模型的唯一标识，主键ID，自增。
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模型的创建时间，插入时自动填充。
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 模型的更新时间，插入和更新时自动填充。
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 模型的创建人，插入时自动填充。
     */
    @TableField(fill = FieldFill.INSERT)
    private String creator;

    /**
     * 模型的更新人，插入和更新时自动填充。
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updater;

}
