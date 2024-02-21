import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
import role from "../page/Role.vue";
import home from "../page/Home.vue";
import roleDetail from "../page/RoleDetail.vue";
import register from "../page/Register.vue";
import login from "../page/Login.vue";
import user from "../page/User.vue";
import notFound from "../page/NotFound.vue";

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
