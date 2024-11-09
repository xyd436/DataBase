<template>
  <!-- 主布局容器 -->
  <a-layout class="layout-demo">
    <!-- 侧边栏 -->
    <a-layout-sider collapsible breakpoint="xl">
      <!-- 侧边栏中的Logo -->
      <div class="logo" />
      <!-- 侧边栏菜单 -->
      <a-menu
          :default-open-keys="['1']" <!-- 默认展开的子菜单的key -->
          :default-selected-keys="['0_3']" <!-- 默认选中的菜单项的key -->
          :style="{ width: '100%' }" <!-- 菜单宽度 -->
          @menu-item-click="onClickMenuItem" <!-- 菜单项点击事件 -->
      >
      <!-- 菜单项 -->
      <a-menu-item key="0_1" disabled>
        <IconHome></IconHome> <!-- 主页图标 -->
        Menu 1 <!-- 菜单项文本 -->
      </a-menu-item>
      <a-menu-item key="0_2">
        <IconCalendar></IconCalendar>
        Menu 2
      </a-menu-item>
      <a-menu-item key="0_3">
        <IconCalendar></IconCalendar>
        Menu 3
      </a-menu-item>
      <!-- 子菜单 -->
      <a-sub-menu key="1">
        <template #title>
          <IconCalendar></IconCalendar> Navigation 1 <!-- 子菜单标题 -->
        </template>
        <a-menu-item key="1_1">Menu 1</a-menu-item>
        <a-menu-item key="1_2">Menu 2</a-menu-item>
        <!-- 嵌套的子菜单 -->
        <a-sub-menu key="2" title="Navigation 2">
          <a-menu-item key="2_1">Menu 1</a-menu-item>
          <a-menu-item key="2_2">Menu 2</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="3" title="Navigation 3">
          <a-menu-item key="3_1">Menu 1</a-menu-item>
          <a-menu-item key="3_2">Menu 2</a-menu-item>
          <a-menu-item key="3_3">Menu 3</a-menu-item>
        </a-sub-menu>
      </a-sub-menu>
      <a-sub-menu key="4">
        <template #title>
          <IconCalendar></IconCalendar> Navigation 4 <!-- 子菜单标题 -->
        </template>
        <a-menu-item key="4_1">Menu 1</a-menu-item>
        <a-menu-item key="4_2">Menu 2</a-menu-item>
        <a-menu-item key="4_3">Menu 3</a-menu-item>
      </a-sub-menu>
      </a-menu>
      <!-- 侧边栏折叠按钮 -->
      <template #trigger="{ collapsed }">
        <IconCaretRight v-if="collapsed"></IconCaretRight> <!-- 折叠时显示的图标 -->
        <IconCaretLeft v-else></IconCaretLeft> <!-- 展开时显示的图标 -->
      </template>
    </a-layout-sider>
    <!-- 主内容布局 -->
    <a-layout>
      <!-- 头部 -->
      <a-layout-header style="padding-left: 20px;">
        研究生导师学生双向选择系统 <!-- 头部文本 -->
      </a-layout-header >
      <!-- 内容区域 -->
      <a-layout style="padding: 0 24px;">
        <!-- 面包屑导航 -->
        <a-breadcrumb :style="{ margin: '16px 0' }">
          <a-breadcrumb-item>Home</a-breadcrumb-item>
          <a-breadcrumb-item>List</a-breadcrumb-item>
          <a-breadcrumb-item>App</a-breadcrumb-item>
        </a-breadcrumb>
        <!-- 内容 -->
        <a-layout-content>Content</a-layout-content>
        <!-- 页脚 -->
        <a-layout-footer>Footer</a-layout-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>

<script>
import { defineComponent } from 'vue';
import { Message} from '@arco-design/web-vue';
import {
  IconCaretRight,
  IconCaretLeft,
  IconHome,
  IconCalendar,
} from '@arco-design/web-vue/es/icon';

export default defineComponent({
  components: {
    IconCaretRight,
    IconCaretLeft,
    IconHome,
    IconCalendar,
  },
  methods: {
    onClickMenuItem(key) {
      Message.info({ content: `You select ${key}`, showIcon: true }); <!-- 菜单项点击事件处理 -->
    }
  }
});
</script>

<style scoped>
/* 布局样式 */
.layout-demo {
  height: 100vh; /* 视口高度 */
  background: var(--color-fill-2); /* 背景色 */
  border: 1px solid var(--color-border); /* 边框 */
}
.layout-demo :deep(.arco-layout-sider) .logo {
  height: 32px; /* Logo高度 */
  margin: 12px 8px; /* Logo边距 */
  background: rgba(255, 255, 255, 0.2); /* Logo背景色 */
}
.layout-demo :deep(.arco-layout-sider-light) .logo{
  background: var(--color-fill-2); /* 侧边栏亮色主题下的Logo背景色 */
}
.layout-demo :deep(.arco-layout-header)  {
  height: 64px; /* 头部高度 */
  line-height: 64px; /* 头部行高 */
  background: var(--color-bg-3); /* 头部背景色 */
}
.layout-demo :deep(.arco-layout-footer) {
  height: 48px; /* 页脚高度 */
  color: var(--color-text-2); /* 页脚文字颜色 */
  font-weight: 400; /* 页脚字体粗细 */
  font-size: 14px; /* 页脚字体大小 */
  line-height: 48px; /* 页脚行高 */
}
.layout-demo :deep(.arco-layout-content) {
  color: var(--color-text-2); /* 内容文字颜色 */
  font-weight: 400; /* 内容字体粗细 */
  font-size: 14px; /* 内容字体大小 */
  background: var(--color-bg-3); /* 内容背景色 */
}
.layout-demo :deep(.arco-layout-footer),
.layout-demo :deep(.arco-layout-content)  {
  display: flex; /* 布局为flex */
  flex-direction: column; /* 子元素垂直排列 */
  justify-content: center; /* 垂直居中 */
  color: var(--color-white); /* 文字颜色 */
  font-size: 16px; /* 字体大小 */
  font-stretch: condensed; /* 字体紧缩 */
  text-align: center; /* 文字居中 */
}
</style>