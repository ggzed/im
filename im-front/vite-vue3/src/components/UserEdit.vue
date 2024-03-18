<template>
  <el-dialog v-model="visible" title="用户信息" width="70%" center :before-close="handleClose" append-to-body>
    <el-form :model="userInfo" label-width="auto" style="max-width: 600px">
      <el-form-item label="名称">
        <el-input v-model="userInfo.name"/>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="userInfo.email"/>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="userInfo.sex" placeholder="please select your zone">
          <el-option label="男" value="1" />
          <el-option label="女" value="0" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">确定</el-button>
        <el-button @click="closeDrawer">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>


<script lang="ts" setup>
import {watch, ref, toRefs} from 'vue'
import {useStore} from "@/store";
import {storeToRefs} from "pinia";
import {roleEdit, getByRoleId} from "@/script/api/role";
import {getByUserId, userEdit} from "@/script/api/user";

const {menus} = storeToRefs(useStore());
const treeRef = ref()

const props = defineProps({
  visible: {
    type: Boolean,
    default: false
  },
  userId: {
    type: Number,
    default: 0
  }
});
const {visible, userId} = toRefs(props); //数据解构

const userInfo = ref<UserVo>({
  id:0,
  userId: '',
  name: '',
  email:'',
  sex:0,
})
//通知父组件修改值
const emit = defineEmits(["closeDrawer"]);

function closeDrawer() {
  emit("closeDrawer");
}

watch(
    userId,
    async () => {
      getByUserId(userId.value).then(res => {
        userInfo.value = res.data;
      })
    },
    {immediate: true}
)


const onSubmit = () => {
  userEdit(userInfo.value);
  closeDrawer();
}
const defaultProps = {
  children: 'children',
  label: 'name',
}
const open = () => {
  visible.value = true
}
defineExpose({
  open
})

const handleClose = (done: () => void) => {
  closeDrawer();
}
</script>
<style scoped></style>
