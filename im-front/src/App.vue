<template>
<!--  <div class="common-layout">-->
<!--    <el-container>-->
<!--      <Head></Head>-->
<!--      <el-container>-->
<!--        <el-aside width="200px">-->
<!--          <el-menu-->
<!--              active-text-color="#ffd04b"-->
<!--              background-color="#545c64"-->
<!--              class="el-menu-vertical-demo"-->
<!--              default-active="2"-->
<!--              text-color="#fff"-->
<!--              @open="handleOpen"-->
<!--              @close="handleClose"-->
<!--          >-->
<!--            <Tree :menuList="menus"/>-->
<!--          </el-menu>-->
<!--        </el-aside>-->
<!--        <el-main style="overflow-y: hidden">-->
<!--          <el-breadcrumb :separator-icon="ArrowRight">-->
<!--            <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>-->
<!--            <el-breadcrumb-item>promotion management</el-breadcrumb-item>-->
<!--            <el-breadcrumb-item>promotion list</el-breadcrumb-item>-->
<!--            <el-breadcrumb-item>promotion detail</el-breadcrumb-item>-->
<!--          </el-breadcrumb>-->
<!--          <el-card style="width: 80% ;height: 100%" shadow="always"><RouterView/></el-card>-->
<!--        </el-main>-->
<!--      </el-container>-->
<!--    </el-container>-->
<!--  </div>-->
  <Home></Home>
</template>


<script lang="ts" setup>
import {onMounted, ref} from "vue";
import Tree from "@/components/Tree.vue";
import {useStore} from "@/store";
import {storeToRefs} from 'pinia'

import { ArrowRight } from '@element-plus/icons-vue'
import Home from "@/components/Home.vue";
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
<style lang="scss" scoped>

.el-aside{
  background: #73787e;
}

.main {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  width: 100%;
}

.common-layout{
  height: 100vh;
}
</style>