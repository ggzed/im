<script setup lang="ts">

</script>

<template>
  <el-header>
      <el-avatar/>
    <el-divider/>
  </el-header>
</template>

<style scoped>
.el-header{
  background-color: #363D40;
  // 给头部设置一下弹性布局
  display: flex;
  // 让它贴标左右对齐
  justify-content: space-between;
  // 清空图片左侧padding
  padding-left: 0;
  // 按钮居中
  align-items: center;
  // 文本颜色
  color: #fff;
  // 设置文本字体大小
  font-size: 20px;

}
</style>