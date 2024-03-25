<template>
  <van-popup
      v-model:show="show"
      position="bottom"
      :style="{ height: '30%' }"
  />
</template>

<script setup lang="ts">
import {ref} from 'vue'
const show = ref(true);
</script>

<style scoped>

</style>