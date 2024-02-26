import {defineConfig} from 'vite';
import vue from '@vitejs/plugin-vue';
// vite 提供的操作env配置变量的方法loadEnv
import {loadEnv} from 'vite';
// nodejs写法，获取项目目录
import path from 'path';
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'

// https://vitejs.dev/config/
export default ({command, mode}) => {
    return defineConfig({
        plugins: [vue(),
            AutoImport({
                resolvers: [ElementPlusResolver()],
            }),
            Components({
                resolvers: [ElementPlusResolver()],
            }),],
        // 服务器配置
        server: {
            host: '0.0.0.0',
            port: Number(loadEnv(mode, process.cwd()).VITE_APP_PORT),
            strictPort: true, // 端口被占用直接退出
            https: false, // 默认用http方式
            open: true,// 在开发服务器启动时自动在浏览器中打开应用程序
            proxy: { // 代理配置
                // 字符串简写写法
                // '/foo': '',
                // 选项写法
                '/api': {
                    target: loadEnv(mode, process.cwd()).VITE_APP_BASE_URL,
                    changeOrigin: true, // 跨域配置
                    rewrite: (path) => path.replace(/^\/api/, '')
                },
                // 正则表达式写法
                // '^/fallback/.*': {
                //   target: 'http://jsonplaceholder.typicode.com',
                //   changeOrigin: true,
                //   rewrite: (path) => path.replace(/^\/fallback/, '')
                // },
            },
            hmr: {
                overlay: true // 屏蔽服务器报错
            }
        },
        resolve: { // 设置项目文件导入路径
            alias: {
                '@': path.resolve(__dirname, './src')
            }
        },
        css: {
            // css预处理器
            preprocessorOptions: {
                // 引入 var.scss 这样就可以在全局中使用 var.scss中预定义的变量了
                // 给导入的路径最后加上 ;
                scss: {
                    additionalData: '@import "@/assets/styles/global.scss";'
                }
            }
        },
        build: { // 分块打包配置
            chunkSizeWarningLimit: 1500, // 分块打包，分解块，将大块分解成更小的块
            rollupOptions: {
                output: {
                    manualChunks(id) {
                        if (id.includes('node_modules')) {
                            return id.toString().split('node_modules/')[1].split('/')[0].toString();
                        }
                    }
                }
            }
        }
    })
}