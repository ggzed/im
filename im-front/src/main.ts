import { createApp } from 'vue'
import App from './App.vue'
// 导入router和store
import router from './router/index'
import store from './store/index'

const app = createApp(App)
app.use(router)
app.use(store)
app.mount('#app')

