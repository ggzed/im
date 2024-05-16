<script setup lang="ts">
// const show = ref(false);
</script>

<template>
  <router-view />
  <van-tabbar route>
    <van-tabbar-item replace to="/shelf" icon="home-o">书架</van-tabbar-item>
    <van-tabbar-item replace to="/" icon="plus" >论坛</van-tabbar-item>
    <van-tabbar-item replace to="/mine" icon="search">我的</van-tabbar-item>
  </van-tabbar>

</template>

<style scoped>

</style>