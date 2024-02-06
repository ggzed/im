import { createRouter, createWebHistory } from 'vue-router'
import { defaultRoutes } from "./defaultRoutes.ts";
import {useRouterGuard} from "./useRouterGuard.ts";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: defaultRoutes
})

// 添加拦截器
useRouterGuard(router);

export default router;
