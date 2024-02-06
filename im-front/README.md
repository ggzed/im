# Vue3 动态路由

我们将以[动态路由初始化项目](https://gitee.com/wangzhaoyv/vue3-dynamic-routing/tree/feat-init)这个为基础开始实现一个后端配置路由，前端动态加载。这个的思路与Vue2的是一致的，Vue2的实现可以查看这篇[Vue2动态路由](https://juejin.cn/post/7061531375953788959)，不过进入Vue3后有很多方便的能力，能让我们实现更加优雅，更加方便。


```bash
node => 16x
```

## 最终项目目录介绍

**项目目录结构**

```bash
|-- vue3-dynamic-routing
    |-- .env  
    |-- index.html 
    |-- package.json 
    |-- README.md
    |-- tsconfig.app.json
    |-- tsconfig.json
    |-- tsconfig.node.json
    |-- vite.config.ts 
    |-- apifox
    |   |-- 动态路由.apifox.json 
    |-- src
        |-- App.vue
        |-- main.ts
        |-- api
        |   |-- common
        |       |-- index.ts 
        |-- pages
        |   |-- auth
        |   |   |-- login
        |   |   |   |-- index.vue
        |   |   |-- register
        |   |       |-- index.vue
        |   |-- common
        |   |   |-- 404
        |   |       |-- index.vue
        |   |-- home
        |   |   |-- index.vue
        |   |-- ums
        |       |-- role
        |       |   |-- index.vue
        |       |   |-- roleDetail
        |       |       |-- index.vue
        |       |-- user
        |           |-- index.vue
        |-- router
        |   |-- defaultRoutes.ts
        |   |-- index.ts
        |   |-- routeComponents.ts
        |   |-- useRouterGuard.ts
        |-- stores
        |   |-- useRoutesStore.ts
        |-- utils
            |-- http
                |-- index.ts

```



**目录分析**

*页面相关*

+ pages：所有页面的主目录，方便后面查找
+ auth：一些与权限相关的目录，这些路由往往不需要权限控制，所以属于直接展示的目录
+ home：主页面目录，可以给添加嵌套路由练手
+ ums：管理页面，一般都会需要权限控制

*辅助目录*

+ api：接口请求
+ router：路由
+ stores：pinia
+ utils/http: 请求封装
+ .env: 开发环境配置文件



**router.ts**

```typescript
import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/pages/home/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/pages/auth/login/index.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/pages/auth/register/index.vue')
    }, 
    {
      path: '/404',
      name: '404',
      component: componentMap["404"]
    }, 
    {
      path: '/ums/role',
      name: 'ums_role',
      component: () => import('@/pages/ums/role/index.vue')
    }, 
    {
      path: '/ums/user',
      name: 'ums_user',
      component: () => import('@/pages/ums/user/index.vue')
    },
  ]
})

export default router;
```

+ 我们现在是将所有的路由都作为无权限控制路由，后期主要改造该部分



## 创建接口数据【软件：Apifox】

本项目中会提供一个apifox的json文件，这个软件mock真的很棒，我这边简单说一下怎么使用

文件目录：`apifox/动态路由.apifox.json`

软件操作：

+ 首页 
+ 导入项目
+ 选择导入数据格式为 【Apifox】
+ 动态路由.apifox.json文件拖入 
+ 填写项目名称 
+ 确定
+ 确定导入 

配置：

+ 选择环境 => 本地mock
+  默认Mock方式： 响应示例优先 【直接导入提供文件，这个应该是默认的】
+ 配置项目的mock环境` vite.config.ts `下的server选项，将apifox提供的地址替换target地址



#### 数据说明

```json
{
    "id": 1,       
    "parentId": 0,       // 父级id
    "title": "用户列表",  //  展示名称 
    "sort": 0,	        //  排序
    "name": "user",     //  可作为路由名称
    "component": "user",//  路由组件的key
    "icon": "ums-user", //  图标
    "path": "/ums/user",//  路由地址
    "hidden": 0         //  是否在菜单上展示
}
```





#### 使用store获取数据

```typescript
import { getMenuList } from "@/api/common/index.ts"; 
import { defineStore } from "pinia"; 
/**
 * 将路由处理为菜单的树状结构
 * @param list 
 * @param parentId 
 * @returns 
 */
export function dealWithRouterToMenu(list: Array<menuType>, parentId = 0) {
  let result: Array<menuType> = [];
  list.forEach((item) => {
    // 排除隐藏的菜单
    if (item.parentId === parentId && item.hidden !== 1) {
      result.push({ ...item, children: dealWithRouterToMenu(list, item.id) });
    }
  });
  return result;
}



export const useRoutesStore = defineStore("routers", {
  state: (): { routes: Array<menuType> } => ({
    routes: [],
  }),
  actions: {
    async getRoutesList() { 
      const data = await getMenuList() || []; 
      const routes = data?.list || [];
      this.routes = routes;
      return routes;
    },
  },
  getters: {
    menus: (state) => {
      return dealWithRouterToMenu(state.routes); 
    },
  },
});
```

+ actions：使用getRoutesList获取路由数据
+ getters：使用menus获取树状菜单数据





## 改造router文件夹文件



### 分离路由

把路由分为两种：【需要动态的】 -【不需要动态的】，单独为他们存放



#### 1. 在router文件夹下新建文件defaultRoutes.ts

```typescript
import type { RouteRecordRaw } from 'vue-router';
import { componentMap } from "./routeComponents.ts";

export const defaultRoutes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: componentMap.home
  },
  {
    path: '/login',
    name: 'login',
    component: componentMap.login
  },
  {
    path: '/register',
    name: 'register',
    component: componentMap.register
  },
  {
    path: '/404',
    name: '404',
    component: componentMap["404"]
  }, 
];

```

在`router/index.ts`中引入

```typescript
import { createRouter, createWebHistory } from 'vue-router'
import { defaultRoutes } from "./defaultRoutes.ts";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: defaultRoutes
})



export default router;
```

> 这里先去掉需要权限这部分路由，因为需要我们使用接口获取



#### 2. 获取pages下的所有页面

##### *规则*

首先我们需要一个规则，怎么样的文件才算是页面，什么样的文件算是组件，这个很重要。以下是这次我演示的规则：pages下的所有`index.vue`, 都是页面，其他都不属于



##### *获取页面组件*

新建文件`router/routeComponents.ts`

```typescript
/**
 * 获取所有页面组件
 * 页面的标识是：index.vue,其他的都不算页面
 * @returns 
 */
const getPageComponents = () => {

  // tips： 通过路径创建组件名称
  const getComponentName = (name: string) => {
    const nameList = name.split("/");
    const newName = nameList.pop();
    if (newName === "index.vue") {
      return nameList.pop();
    }
  };

  // 定义一个组件对象，后续作为返回值使用
  const componentMap: { [key: string]: () => Promise<any> } = {};

  // ../pages/*/*.vue：不深层次获取文件夹
  const components = import.meta.glob("../pages/**/index.vue");
  // 循环，将所有页面组件放入对象中
  for (const key in components) {
    const component = components[key];
    const componentName = getComponentName(key);
    if (componentName) {
      componentMap[componentName] = component;
    }
  }

  return componentMap;
};

// 所有页面路由数据
export const componentMap = getPageComponents();

// 这里打印一下，后续配置路由，需要这里的key
console.log("页面组件信息：" ,componentMap);
```

> tips： 通过路径创建组件名称
>
> **说明：**
>
> 获取组件名称，也就是componentMap 的 key
>
> **问题：**
>
> 这个名称我这个做的比较简陋，只是取文件夹名称而已，有一定的冲突风险
>
> **方案：**
>
> 可以根据路径作为名称，这样就可以避免上面说的问题



##### *替换默认路由的组件，测试一下页面情况*

```typescript
import type { RouteRecordRaw } from 'vue-router';
import { componentMap } from "./routeComponents.ts";

export const defaultRoutes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: componentMap.home
  },
  {
    path: '/login',
    name: 'login',
    component: componentMap.login
  },
  {
    path: '/register',
    name: 'register',
    component: componentMap.register
  },
  {
    path: '/404',
    name: '404',
    component: componentMap["404"]
  }, 
];

```



##### *创建拦截器实现动态加载路由*

**useRouterGuard.ts**

```typescript
import { componentMap } from "./routeComponents";
import { useRoutesStore } from "@/stores/useRoutesStore";
import type { Router } from "vue-router";
 

export function addRouter(list: Array<any>, router: Router) {
  list.forEach((item) => {
    let { component, path, name } = item;
    if (component) {
      const componentInfo = componentMap[component] || componentMap["404"];
      router.addRoute({
        path,
        name,
        component: componentInfo,
      });
    }
  });
}

export const useRouterGuard = (router: Router) => {
  // 全局前置守卫
  router.beforeEach(async (_to, _from, next) => {
    const menuInfo = useRoutesStore();
    // 没有获取过路由
    if (menuInfo.routes.length === 0) {
      const list = await menuInfo.getRoutesList();
      addRouter(list, router);

      // 触发重定向
      // 注意这里只能使用重定向去跳转
      // 因为这个跳转没有添加路由前本身就是错误的，所以需要使用重定向的形式完成
      // 这里不能使用return，return和next同时存在这个方法内就会报错
      // "vue-router": "^4.1.6" - Error： Invalid navigation guard
      next(_to.fullPath);
    } else {
      next();
    }
  });

  // 全局解析守卫
  router.beforeResolve(async (_to) => {});

  // 全局后置钩子
  router.afterEach((_to, _from) => {});
};
```

**说明：**

+ 在store路由的长度为0时，应该尝试获取路由
+ 通过addRoute添加单个路由，addRoute可以有两个参数，第一个参数为路由名称，然后第二个参数为路由，这样就可以添加嵌套路由了[【动态路由】](https://router.vuejs.org/zh/guide/advanced/dynamic-routing.html)，所以需要添加子路由的话可以使用该方法
+ 还可以通过hasRoute判断是否存在路由
+ 这里接口配置的component属性就是`router/routeComponents.ts`文件中`componentMap`的`key值`
+ 这里的判断大致和Vue2版本是一致的，可以参考那边后期进行完善

**注意点：**

+ 触发重定向的时候可能会报错，在注释上已经标注了

+ 应该在退出登录的时候应该删除所有动态路由





## 最后

相较于Vue2版本的动态路由，这个版本主要就是路由平铺，基本上不使用嵌套路由【可以在Home中添加左侧菜单和头部状态展示组件，然后中间给一个` <RouterView />`, 然后将所有路由添加到Home的子路由上，用于完成公共部分】，因为这样在后端路由层级变化的时候就会相当灵活，随便后端路由怎么变化，前端都不会受到影响！



##### [【Git : vue3-dynamic-routing】](https://gitee.com/wangzhaoyv/vue3-dynamic-routing)

