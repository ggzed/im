package com.ggzed.im.service;

import com.ggzed.im.model.common.PageResult;
import com.ggzed.im.model.req.page.PageReq;
import com.ggzed.im.model.req.query.RoleQuery;
import com.ggzed.im.model.req.query.UserQuery;
import com.ggzed.im.model.req.user.RoleEditReq;
import com.ggzed.im.model.req.user.UserEditReq;
import com.ggzed.im.model.vo.RoleVo;
import com.ggzed.im.model.vo.UserVo;

public interface RoleInfoService {

    RoleVo getById(String id);

    PageResult<RoleVo> page(RoleQuery query, PageReq pageReq);

    void edit(RoleEditReq req);

    void delete(String id);
}
