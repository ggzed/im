package com.ggzed.im.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ggzed.im.model.dto.UserInfoDto;
import com.ggzed.im.model.entity.UserInfo1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息DAO.
 *
 * @ClassName UserInfoMapper
 * @Author ggzed
 * @Date 2024/2/4
 * @Version 1.0
 */

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo1> {

    /**
     * 通过username获取用户信息
     * @param username
     * @return
     */
  UserInfoDto getUserInfoByUsername(@Param("username") String username);

}