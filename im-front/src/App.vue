<script setup lang="ts">
import {RouterLink, RouterView} from 'vue-router'


</script>
<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <el-row :gutter="20">
          <el-col :span="4">
            <RouterLink to="/">主页</RouterLink>
          </el-col>
          <el-col :span="16">
            <div class="grid-content ep-bg-purple"/>
          </el-col>
          <el-col :span="2">
            <RouterLink to="/login">登录</RouterLink>
          </el-col>
          <el-col :span="2">
            <RouterLink to="/register">注册</RouterLink>
          </el-col>
        </el-row>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu>
            <el-menu-item-group>
              <RouterLink to="/role">
                <el-menu-item index="1-1">角色列表</el-menu-item>
              </RouterLink>
              <RouterLink to="/roleDetail">
                <el-menu-item index="1-1">角色详情</el-menu-item>
              </RouterLink>
              <RouterLink to="/user">
                <el-menu-item index="1-1">用户列表</el-menu-item>
              </RouterLink>
            </el-menu-item-group>
          </el-menu>

        </el-aside>
        <el-main>
          <RouterView/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<!--<template>-->
<!--  <RouterLink to="/">主页</RouterLink>-->
<!--  <div class="common-layout">-->
<!--    <el-container>-->
<!--      <el-header>-->
<!--        <RouterLink to="/login">登录</RouterLink>-->
<!--        <RouterLink to="/register">注册</RouterLink>-->
<!--      </el-header>-->
<!--      <el-container>-->
<!--        <el-aside width="200px">-->
<!--          <RouterLink to="/ums/role">角色列表</RouterLink>-->
<!--          <RouterLink to="/ums/role/6">角色详情</RouterLink>-->
<!--          <RouterLink to="/ums/user">用户列表</RouterLink>-->
<!--        </el-aside>-->
<!--        <el-main>Main</el-main>-->
<!--      </el-container>-->
<!--    </el-container>-->
<!--  </div>-->
<!--  <RouterView/>-->
<!--</template>-->

<!--  <header>-->
<!--    <div class="wrapper">  -->
<!--        <RouterLink to="/">主页</RouterLink>-->
<!--        <RouterLink to="/login">登录</RouterLink>-->
<!--        <RouterLink to="/register">注册</RouterLink>-->
<!--        <RouterLink to="/ums/role">角色列表</RouterLink>-->
<!--        <RouterLink to="/ums/role/6">角色详情</RouterLink> -->
<!--        <RouterLink to="/ums/user">用户列表</RouterLink>  -->
<!--    </div>-->
<!--  </header>-->

<!--  <RouterView />-->
<!--</template>-->

<style scoped></style>
