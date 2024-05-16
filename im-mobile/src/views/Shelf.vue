<template>
  <div class="head">
    <router-link to="/bookAdd">
      <div class="add" @click="showPopup">
        <van-icon  name="add-o" size="2rem" />
      </div>
    </router-link>
  </div>
  <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
    <van-list
        v-model:loading="loading"
        :finished="finished"
        finished-text="没有更多了"
        @load="onLoad"
    >
      <!--      <van-cell v-for="item in list" :key="item" :title="item"/>-->
      <BookCell v-for="item in list" :key="item" :title="item"></BookCell>
    </van-list>
  </van-pull-refresh>

</template>

<script setup lang="ts">
import {ref} from 'vue';
import BookCell from "@/components/shelf/BookCell.vue";

const list = ref([1]);
const loading = ref(false);
const finished = ref(false);
const refreshing = ref(false);
const visible = ref(false);
const show = ref(false);
const showPopup = () => {
  show.value = true;
};
// 关闭弹窗
function closeDrawer() {
  visible.value = false;
}

const onLoad = () => {
  setTimeout(() => {
    if (refreshing.value) {
      list.value = [];
      refreshing.value = false;
    }

    for (let i = 0; i < 10; i++) {
      list.value.push(list.value.length + 1);
    }
    loading.value = false;

    if (list.value.length >= 40) {
      finished.value = true;
    }
  }, 1000);
};

const onRefresh = () => {
  // 清空列表数据
  finished.value = false;

  // 重新加载数据
  // 将 loading 设置为 true，表示处于加载状态
  loading.value = true;
  onLoad();
};
</script>

<style scoped>
.head {
  height: 50px;
  background: aquamarine;
  display: flex;
  align-items: center;
  justify-content: right;
}
.add{
  width: 30px;
  height: 30px;
  margin-right: 10px;
}
</style>