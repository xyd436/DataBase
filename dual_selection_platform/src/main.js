import { createApp } from 'vue';
import App from './App.vue';
import { router } from './router'; // 导入路由配置

const app = createApp(App);

app.use(router); // 使用路由中间件

app.mount('#app'); // 挂载 Vue 应用到 DOM 元素中