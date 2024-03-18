import service from "@/script/utils/request.ts";

// 用户分页
export const userPage = (data: UserPageReq, page: number, size: number, startRow: number) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/user/page?page=' + page + '&size=' + size + '&startRow=' + startRow,
        method: "post",
        data
    })
}


export const getByUserId = (id: number) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/user/' +id,
        method: "get"
    })
}

export const userEdit = (data: UserVo) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/user/edit',
        method: "post",
        data
    })
}

export const deleteByUserId = (id: number) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/user/delete/'+id,
        method: "post",
    })
}
