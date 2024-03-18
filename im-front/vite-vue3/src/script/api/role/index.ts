import service from "@/script/utils/request.ts";
import {Ref} from "vue";

// 用户分页
export const rolePage = (data: UserPageReq, page: number, size: number, startRow: number) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/role/page?page=' + page + '&size=' + size + '&startRow=' + startRow,
        method: "post",
        data
    })
}

export const getByRoleId = (id: number) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/role/' +id,
        method: "get"
    })
}

export const roleEdit = (data: RoleEditReq) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/role/edit',
        method: "post",
        data
    })
}

export const deleteByRoleId = (id: number) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/role/delete/'+id,
        method: "post",
    })
}