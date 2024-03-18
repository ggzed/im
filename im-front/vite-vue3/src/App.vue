<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
        <RouterLink to="/">
          <h1 class="mb-2">Test</h1>
        </RouterLink>
        <el-menu
            active-text-color="#ffd04b"
            background-color="#545c64"
            class="el-menu-vertical-demo"
            default-active="2"
            text-color="#fff"
            @open="handleOpen"
            @close="handleClose"
        >
          <Tree :menuList="menus"/>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header>
          <el-row :gutter="20">
            <el-col :span="4">
              <div class="grid-content ep-bg-purple"/>
            </el-col>
            <el-col :span="16">
              <div class="grid-content ep-bg-purple"/>
            </el-col>
            <el-col :span="4">
                <el-avatar> user</el-avatar>
            </el-col>
          </el-row>
        </el-header>
        <el-main>
          <RouterView/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script lang="ts" setup>
import {onMounted, ref} from "vue";
import Tree from "@/components/Tree.vue";
import {useStore} from "@/store";
import {storeToRefs} from 'pinia'

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

const myStore = useStore();
const {menus} = storeToRefs(useStore());

onMounted(() => {
  myStore.initMenus();
})
</script>