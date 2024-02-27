// src/store/index.ts

import { defineStore } from 'pinia'
import {getMenus} from "@/script/api/auth";

// 定义store, myFirstStore是store的名称，该名称必须唯一，不可重复
export const useStore = defineStore('myFirstStore', {
    state: () => {
        return {
            count: 0,
            name: 'foo',
            list: [1, 2, 3],
            menus:Array
        }
    },
    actions:{
        initMenus(){
            getMenus().then(res => {
                this.menus = res.data
            })
        }
    },
    // persist:{
    //     enable:true
    // }
})
