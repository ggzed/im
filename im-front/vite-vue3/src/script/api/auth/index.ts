import service from "@/script/utils/request.ts";

export const login = (data: LoginReq) => {
        return service({
            url: '/auth/login',
            method: "post",
            data
        })
    }

export const getMenus = () => {
    return service({
        url: '/auth/menus',
        method: "get",
    })
}