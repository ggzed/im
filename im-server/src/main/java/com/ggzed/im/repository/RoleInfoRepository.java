package com.ggzed.im.repository;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggzed.im.mapper.RoleInfoMapper;
import com.ggzed.im.mapper.UserRoleMapper;
import com.ggzed.im.model.entity.RoleInfo;
import com.ggzed.im.model.entity.UserInfo;
import com.ggzed.im.model.entity.UserRole;
import com.ggzed.im.model.req.query.RoleQuery;
import com.ggzed.im.model.req.query.UserQuery;
import com.ggzed.im.model.req.user.RoleEditReq;
import org.springframework.stereotype.Repository;

/**
 * 详细介绍类情况.
 *
 * @ClassName UserInfoRepository
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */
@Repository
public class RoleInfoRepository extends ServiceImpl<RoleInfoMapper, RoleInfo> {
    public IPage<RoleInfo> pageSearch(RoleQuery query, Page<RoleInfo> page) {
        return buildQueryWrapper(query).page(page);
    }

    private LambdaQueryChainWrapper<RoleInfo> buildQueryWrapper(RoleQuery query) {
        return lambdaQuery()
                .eq(StrUtil.isNotBlank(query.getName()), RoleInfo::getName, query.getName());
    }

    public void edit(RoleEditReq req) {
    }

    public void deleteByUserId(String userId) {
    }
}