import { createApp } from 'vue'
import ArcoVue from '@arco-design/web-vue';
import App from './App.vue';
import '@arco-design/web-vue/dist/arco.css';
import { router } from './router'; // 导入路由配置

const app = createApp(App);

app.use(router); // 使用路由中间件
app.use(ArcoVue);
app.mount('#app'); // 挂载 Vue 应用到 DOM 元素中