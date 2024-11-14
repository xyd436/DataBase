import { createApp } from 'vue';
import ArcoVue from '@arco-design/web-vue';
import App from './App.vue';
import '@arco-design/web-vue/dist/arco.css';
import { router } from './router'; // 导入路由配置
import axios from './axios';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

// 将axios添加到Vue的原型链上，这样在组件内部就可以通过this.$axios来使用axios
const app = createApp(App);

app.config.globalProperties.$axios = axios; // 修改这里，使用app.config.globalProperties

app.use(router); // 使用路由中间件
app.use(ArcoVue); // 使用ArcoVue组件库
app.use(ElementPlus);

app.mount('#app'); // 挂载 Vue 应用到 DOM 元素中