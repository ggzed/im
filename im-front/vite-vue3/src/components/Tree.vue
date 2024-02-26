<template >
  <el-sub-menu
      v-for="item in menuList" :key="item.path"
      :index="item.path"
  >
    <template #title>
      <span>{{ item.name }}</span>
    </template>
    <!--        有子菜单的继续遍历（递归）-->
    <Tree :menuList="item.children"></Tree>
  </el-sub-menu>
<!--  &lt;!&ndash;      没有子菜单&ndash;&gt;-->
<!--  <el-menu-item :index="item.path" v-if="item.nodeType==2">-->
<!--    <span>{{ item.name }}</span>-->
<!--  </el-menu-item>-->
</template>

<script setup lang="ts">

const props = defineProps({
  menuList: Array
})
</script>

<style scoped>

</style>