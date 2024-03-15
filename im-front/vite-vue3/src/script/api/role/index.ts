import service from "@/script/utils/request.ts";

// 用户分页
export const rolePage = (data: UserPageReq, page: number, size: number, startRow: number) => {
    // 返回的数据格式可以和服务端约定
    return service({
        url: '/role/page?page=' + page + '&size=' + size + '&startRow=' + startRow,
        method: "post",
        data
    })
}
