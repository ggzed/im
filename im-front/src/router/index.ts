import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
import home from "../pages/home/index.vue"
import role from "../pages/ums/role/index.vue"
import roleDetail from "../pages/ums/role/roleDetail/index.vue"
import user from "../pages/ums/user/index.vue"
import login from "../pages/auth/login/index.vue"
import register from "../pages/auth/register/index.vue"
import notFound from "../pages/common/404/index.vue"

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'home',
        component: home
    },
    {
        path: '/role',
        name: 'role',
        component: role
    },
    {
        path: '/roleDetail',
        name: 'roleDetail',
        component: roleDetail
    },
    {
        path: '/user',
        name: 'user',
        component: user
    },
    {
        path: '/login',
        name: 'login',
        component: login
    },
    {
        path: '/register',
        name: 'register',
        component: register
    },
    {
        path: '/404',
        name: '404',
        component: notFound
    },
];
const router = createRouter({
    history: createWebHistory(),
    routes
})

// 添加拦截器
// useRouterGuard(router);

export default router;
