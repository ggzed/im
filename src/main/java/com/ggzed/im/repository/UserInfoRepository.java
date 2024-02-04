package com.ggzed.im.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggzed.im.mapper.UserInfoMapper;
import com.ggzed.im.model.dto.UserInfoDto;
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
public class UserInfoRepository extends ServiceImpl<UserInfoMapper, UserInfo> {
    public UserInfoDto getUserInfoByUsername(String username) {
        return baseMapper.getUserInfoByUsername(username);
    }
}