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
export default () => {
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
            open: false,
            port: 5171,
            proxy: {
                "/im": {
                    target: "http://localhost:10100",
                    changeOrigin: true, //是否跨域
                    // rewrite: (path) => path.replace(/^\/mis/, ""), //因为后端接口有mis前缀，所以不需要替换
                    // ws: true,                       //是否代理 websockets
                    // secure: true, //是否https接口
                },
            },
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