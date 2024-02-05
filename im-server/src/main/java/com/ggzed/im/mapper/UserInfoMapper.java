package com.ggzed.im.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ggzed.im.model.dto.UserInfoDto;
import com.ggzed.im.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息DAO.
 *
 * @ClassName UserInfoMapper
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 通过username获取用户信息
     * @param username
     * @return
     */
  UserInfoDto getUserInfoByUsername(@Param("username") String username);

}