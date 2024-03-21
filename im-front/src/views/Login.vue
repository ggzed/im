<template>
  <el-form :model="loginReq" label-width="120px">
    <el-form-item label="username">
      <el-input v-model="loginReq.username"/>
    </el-form-item>
    <el-form-item label="password">
      <el-input v-model="loginReq.password"/>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="Login">Create</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import {reactive} from 'vue'
import {login} from "@/script/api/auth";
import router from "@/router/index.ts";
import {useStore} from "@/store";

// do not use same name with ref
const loginReq: LoginReq = reactive({
  username: '',
  password: ''
})

const myStore = useStore();

const Login = async () => {
  const res = await login(loginReq);
  localStorage.setItem("token",res.data.token);
  myStore.initMenus();
  router.push('/')
}

// const Login = () => {
//   login(loginReq).then(res => {
//     localStorage.setItem("token",res.data.token);
//     myStore.initMenus();
//   })
//   router.push('/')
// }


</script>