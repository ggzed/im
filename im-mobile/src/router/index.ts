import {
    createRouter,
    createWebHashHistory,
} from 'vue-router'
import Shelf from "@/views/Shelf.vue";
import BookAdd from "@/views/shelf/BookAdd.vue";
import Square from "@/views/Square.vue";
import Mine from "@/views/Mine.vue";
import Add from "@/views/Add.vue";

const routes = [
    {
        path: '/shelf',
        name: 'shelf',
        component: Shelf
    },
    {
        path: '/bookAdd',
        name: 'add',
        component: BookAdd,
    },
    {
        path: '/',
        name: 'square',
        component: Square
    }
    ,
    {
        path: '/mine',
        name: 'mine',
        component: Mine
    }
]
// 创建路由对象
const router = createRouter({
    history: createWebHashHistory(),
    routes
})
export default router;

