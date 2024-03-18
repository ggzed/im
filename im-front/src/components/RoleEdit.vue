<template>
  <el-dialog v-model="visible" title="权限设置" width="70%" center :before-close="handleClose" append-to-body>
    <el-form :model="roleInfo" label-width="auto" style="max-width: 600px">
      <el-form-item label="名称">
        <el-input v-model="roleInfo.name"/>
      </el-form-item>
      <el-form-item label="说明">
        <el-input v-model="roleInfo.code"/>
      </el-form-item>
      <el-form-item label="权限设置">
        <el-tree
            ref="treeRef"
            style="max-width: 600px"
            :data="menus"
            show-checkbox
            node-key="id"
            :default-checked-keys="roleInfo.menus"
            :props="defaultProps"
            :default-expand-all = true
        />
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

const {menus} = storeToRefs(useStore());
const treeRef = ref()

const props = defineProps({
  visible: {
    type: Boolean,
    default: false
  },
  roleId: {
    type: Number,
    default: 0
  }
});
const {visible, roleId} = toRefs(props); //数据解构

const roleInfo = ref<RoleEditReq>({
  id: 0,
  name: '',
  code: '',
  menus: []
})
//通知父组件修改值
const emit = defineEmits(["closeDrawer"]);

function closeDrawer() {
  emit("closeDrawer");
}

watch(
    roleId,
    async () => {
      getByRoleId(roleId.value).then(res => {
        roleInfo.value = res.data;
      })
    },
    {immediate: true}
)


const onSubmit = () => {
  roleInfo.value.menus = treeRef.value.getCheckedKeys(true);
  roleEdit(roleInfo.value);
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
