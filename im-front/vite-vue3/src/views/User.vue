<template>
      <el-table :data="pageRes.records" style="width: 100%">
        <el-table-column prop="name" label="姓名" width="180" />
        <el-table-column prop="email" label="邮箱" width="180" />
        <el-table-column prop="sex" label="性别" />
      </el-table>
  <el-pagination
      small
      background
      layout="prev, pager, next"
      :total="pageRes.total"
      class="mt-4"
      @current-change="handleCurrentChange"
  />


</template>
<script lang="ts" setup>
import {onMounted, reactive, Ref, ref, toRef} from "vue";
import {page} from "@/script/api/user";

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

const handleCurrentChange = (val: number) => {
  pageReq.page = val;
}

onMounted(() => {
  page(pageReq.query, 1, 10, 1).then(res => {
    console.log("res",res)
    pageRes.current = res.data.current;
    pageRes.total = res.data.total;
    pageRes.size = res.data.size;
    pageRes.totalPages = res.data.totalPages;
    pageRes.records = res.data.records;
  })
})
</script>
