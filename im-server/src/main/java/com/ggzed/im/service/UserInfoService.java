package com.ggzed.im.service;

import com.ggzed.im.model.req.LoginReq;
import com.ggzed.im.model.vo.UserVo;

public interface UserInfoService {

    UserVo getById(Long id);

}
