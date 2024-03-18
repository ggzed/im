<template>
  <el-table :data="pageRes.records" style="width: 100%">
    <el-table-column prop="name" label="名称" width="180"/>
    <el-table-column prop="code" label="编码" width="180"/>
    <el-table-column label="Operations">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
        >编辑</el-button
        >
        <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
        >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>

  <el-pagination
      small
      background
      layout="prev, pager, next"
      :total="pageRes.total"
      class="mt-4"
      @current-change="handleCurrentChange"
  />
  <RoleEdit :visible = visible :roleId = roleId @close-drawer="closeDrawer"></RoleEdit>
</template>

<script lang="ts" setup>
import {onMounted, reactive, Ref, ref} from "vue";
import {deleteByRoleId, getByRoleId, rolePage} from "@/script/api/role";
import RoleEdit from "@/components/RoleEdit.vue";

const visible = ref(false);
const roleId = ref(1);

const handleEdit = (index: number, row: RoleVo) => {
  visible.value=true;
  roleId.value=row.id;
}
const handleDelete = (index: number, row: RoleVo) => {
  deleteByRoleId(row.id);
}

const pageRes: PageRes<RoleVo> = reactive({
  total: 0,
  size: 0,
  current: 0,
  totalPages: 0,
  records: [{
    id: '',
    name: '',
    code: '',
  }]
});

const pageReq: PageReq<UserPageReq> = reactive({
  page: 0,
  size: 10,
  current: 0,
  query: {
    name: ''
  }
});

const handleCurrentChange = (val: number) => {
  pageReq.page = val;
}

onMounted(() => {
  rolePage(pageReq.query, 1, 10, 1).then(res => {
    pageRes.current = res.data.current;
    pageRes.total = res.data.total;
    pageRes.size = res.data.size;
    pageRes.totalPages = res.data.totalPages;
    pageRes.records = res.data.records;
  })
})

// 关闭弹窗
function closeDrawer() {
  visible.value = false;
}
</script>
