<template>
  <el-dialog v-model="visible" title="权限设置" width="70%" center>
    <el-form :model="form" label-width="auto" style="max-width: 600px">
      <el-form-item label="名称">
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item label="说明">
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item label="权限设置">
        <el-tree
            style="max-width: 600px"
            :data="data"
            show-checkbox
            node-key="id"
            :default-expanded-keys="[2, 3]"
            :default-checked-keys="[5]"
            :props="defaultProps"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">Create</el-button>
        <el-button @click="closeDrawer">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>


<script setup lang="ts">
import {onMounted, ref, toRefs} from 'vue'

const props = defineProps({
  visible: Boolean,
  roleId: String
});
const { visible,roleId } = toRefs(props); //数据解构
//通知父组件修改值
const emit = defineEmits(["closeDrawer"]);
function closeDrawer() {
  emit("closeDrawer");
}

import { reactive } from 'vue'
import {getByRoleId} from "@/script/api/role";

const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})


const onSubmit = () => {
  closeDrawer();
  console.log('submit!')
}
const defaultProps = {
  children: 'children',
  label: 'label',
}
const data = [
  {
    id: 1,
    label: 'Level one 1',
    children: [
      {
        id: 4,
        label: 'Level two 1-1',
        children: [
          {
            id: 9,
            label: 'Level three 1-1-1',
          },
          {
            id: 10,
            label: 'Level three 1-1-2',
          },
        ],
      },
    ],
  },
  {
    id: 2,
    label: 'Level one 2',
    children: [
      {
        id: 5,
        label: 'Level two 2-1',
      },
      {
        id: 6,
        label: 'Level two 2-2',
      },
    ],
  },
  {
    id: 3,
    label: 'Level one 3',
    children: [
      {
        id: 7,
        label: 'Level two 3-1',
      },
      {
        id: 8,
        label: 'Level two 3-2',
      },
    ],
  },
]
const open = () => {
  visible.value = true
}
defineExpose({
  open
})
</script>
<style scoped></style>
