<template>
      <el-table :data="pageRes.records" style="width: 100%">
        <el-table-column prop="name" label="姓名" width="180" />
        <el-table-column prop="email" label="邮箱" width="180" />
        <el-table-column prop="sex" label="性别" />
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

  <UserEdit :visible = visible :userId = userId @close-drawer="closeDrawer"></UserEdit>
</template>
<script lang="ts" setup>
import {onMounted, reactive, Ref, ref, toRef} from "vue";
import {userPage} from "@/script/api/user";
import {deleteByRoleId} from "@/script/api/role";
import RoleEdit from "@/components/RoleEdit.vue";
import UserEdit from "@/components/UserEdit.vue";

const pageRes: PageRes<UserVo> = reactive({
  total: 0,
  size: 0,
  current: 0,
  totalPages: 0,
  records: [{
    userId: '',
    name: '',
    email:'',
    sex:''
  }]
});

const pageReq: PageReq<UserPageReq> = reactive({
  page: 0,
  size: 10,
  current:0,
  query:{
    name:''
  }
});


const visible = ref(false);
const userId = ref(1);

const handleCurrentChange = (val: number) => {
  pageReq.page = val;
}

const handleEdit = (index: number, row: RoleVo) => {
  visible.value=true;
  userId.value=row.id;
}
const handleDelete = (index: number, row: RoleVo) => {
  deleteByRoleId(row.id);
}

// 关闭弹窗
function closeDrawer() {
  visible.value = false;
}

onMounted(() => {
  userPage(pageReq.query, 1, 10, 1).then(res => {
    console.log("res",res)
    pageRes.current = res.data.current;
    pageRes.total = res.data.total;
    pageRes.size = res.data.size;
    pageRes.totalPages = res.data.totalPages;
    pageRes.records = res.data.records;
  })
})
</script>
