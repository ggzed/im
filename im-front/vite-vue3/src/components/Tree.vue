<template>
  <div>
    <template v-for="item in props.menuList" :key="item.path">
      <!--      分为两种方式渲染：有子菜单和没有子菜单-->
      <el-sub-menu
          :index="item.path"
          v-if="item.nodeType == 1"
      >
        <template #title>
          <span>{{ item.name + item.path }}</span>
        </template>
        <!--        有子菜单的继续遍历（递归）-->
        <Tree :menuList="item.children"></Tree>
      </el-sub-menu>
      <!--      没有子菜单-->
      <RouterLink :to=item.path>
        <el-menu-item :index="item.path" v-if="item.nodeType==2">
          <span>{{ item.name }}</span>
        </el-menu-item>
      </RouterLink>
    </template>
  </div>
</template>

<script setup lang="ts">

const props = defineProps({
  menuList: Array<MenuVo>
})
console.log("menuList", props.menuList)

</script>

<style scoped>

</style>