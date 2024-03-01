import service from "@/script/utils/request.ts";
import request from "@/script/utils/request.ts";

export const page = (data: UserPageReq,page:number,size:number,startRow:number) => {
        return request<PageRes<UserVo>>({
            url: '/user/page?page='+page+'&size='+size+'&startRow='+startRow,
            method: "post",
            data
        })
    }
