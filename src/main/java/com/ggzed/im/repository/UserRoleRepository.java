package com.ggzed.im.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggzed.im.mapper.UserInfoMapper;
import com.ggzed.im.model.entity.UserInfo;
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
public class UserRoleRepository extends ServiceImpl<UserInfoMapper, UserInfo> {
    public UserInfo getUserInfoByUsername(String username) {
        return lambdaQuery()
                .eq(UserInfo::getUsername, username)
                .one();
    }
}