import {RouteRecordRaw, createRouter, createWebHistory} from "vue-router";

const routes: Array<RouteRecordRaw> = [
    {path: "/", redirect: "/home"},
    // {path: "/home", name: "Home", component: () => import("@/views/Home.vue")},
    {path: "/login", name: "Login", component: () => import("@/views/Login.vue")},
    {path: "/user", name: "Login", component: () => import("@/views/User.vue")},
];

const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHistory(),
    routes, // `routes: routes` 的缩写
});

router.beforeEach(async (to, from, next) => {
    const token = localStorage.getItem("token");
    //不需要登录的直接放行
    if (to.meta.requiresAuth === false) {
        next()
        //如果页面需要登录，且登录失效，进入登录页面
    } else if (token == null && to.path !== '/login') {
        next({
            path: '/login',
            query: {redirect: to.fullPath}
        })
    } else {
        next()
    }

})

export default router;
