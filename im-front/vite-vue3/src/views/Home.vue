  <template>
    <div class="common-layout">
      <el-container>
        <el-aside width="200px">
            <h5 class="mb-2">Custom colors</h5>
            <el-menu
                active-text-color="#ffd04b"
                background-color="#545c64"
                class="el-menu-vertical-demo"
                default-active="2"
                text-color="#fff"
                @open="handleOpen"
                @close="handleClose"
            >
              <Tree :menuList = "menus"/>
            </el-menu>
        </el-aside>
        <el-container>
          <el-header>Header</el-header>
          <el-main><RouterView/></el-main>
        </el-container>
      </el-container>
    </div>
  </template>


  <script lang="ts" setup>
  import {onMounted, ref} from "vue";
  import {getMenus} from "@/script/api/auth";
  import Tree from "@/components/Tree.vue";
  import {useStore} from "@/store";
  import { storeToRefs } from 'pinia'
  const handleOpen = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
  }
  const handleClose = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
  }

  const myStore = useStore();
  const {menus} = storeToRefs(useStore());

  let menuList = ref();
  onMounted(()=>{
    myStore.initMenus();
    // getMenus().then(res => {
    //   menuList = res.data
    // })
  })
  </script>