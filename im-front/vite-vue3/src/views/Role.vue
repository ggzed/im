<template>
  <el-table :data="pageRes.records" style="width: 100%">
    <el-table-column prop="name" label="名称" width="180"/>
    <el-table-column prop="code" label="编码" width="180"/>
    <el-table-column prop="roleId" label="操作">
      <el-button type="primary" round @click="edit(roleId)">编辑</el-button>
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
  <RoleEdit :visible = visible :roleId = roleId></RoleEdit>
</template>
<script lang="ts" setup>
import {onMounted, reactive, Ref, ref} from "vue";
import {rolePage} from "@/script/api/role";
import RoleEdit from "@/components/RoleEdit.vue";

const visible = ref(false);
let roleId = ref()
function edit(currentId:any) {
  visible.value= true
  roleId.value = currentId;
}

const pageRes: PageRes<UserVo> = reactive({
  total: 0,
  size: 0,
  current: 0,
  totalPages: 0,
  records: [{
    roleId: '',
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
    console.log("res", res)
    pageRes.current = res.data.current;
    pageRes.total = res.data.total;
    pageRes.size = res.data.size;
    pageRes.totalPages = res.data.totalPages;
    pageRes.records = res.data.records;
  })
})
</script>
