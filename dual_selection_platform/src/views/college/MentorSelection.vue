<template>
  <a-layout class="layout-demo">
    <a-layout-sider collapsible breakpoint="xl">
      <div class="logo" />
      <a-menu
          :default-open-keys="['2','3']"
          :default-selected-keys="['/MentorSelection']"
          :style="{ width: '100%' }"
          @menu-item-click="onClickMenuItem"
      >
        <a-menu-item key="/">
          <IconHome></IconHome>
          首页
        </a-menu-item>

        <a-sub-menu key="2">
          <template #title>
            <icon-user-group /> 导师管理
          </template>
          <a-menu-item key="/MentorManagement">导师遴选</a-menu-item>
          <a-menu-item key="/MentorQualification">导师资格审查</a-menu-item>
        </a-sub-menu>

        <a-sub-menu key="3">
          <template #title>
            <icon-subscribed /> 志愿管理
          </template>
          <a-menu-item key="/CandidateVolunteer">考生志愿</a-menu-item>
          <a-menu-item key="/MentorSelection">导师选择</a-menu-item>
        </a-sub-menu>
        <a-menu-item key="/RecruitmentManagement">
          <icon-list />招生目录管理
        </a-menu-item>
      </a-menu>
      <!-- trigger -->
      <template #trigger="{ collapsed }">
        <IconCaretRight v-if="collapsed"></IconCaretRight>
        <IconCaretLeft v-else></IconCaretLeft>
      </template>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="padding-left: 20px;font-size: 25px;font-weight: bold">
        研究生导师双选管理系统
      </a-layout-header >
      <a-layout style="padding: 0 24px;">
        <a-breadcrumb :style="{ margin: '16px 0' }">
          <a-breadcrumb-item>志愿管理</a-breadcrumb-item>
          <a-breadcrumb-item>导师选择</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content>Content</a-layout-content>
        <a-layout-footer>Footer</a-layout-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import { defineComponent } from 'vue';
// import { Message} from '@arco-design/web-vue';
import {
  IconCaretRight,
  IconCaretLeft,
  IconHome,
  IconUserGroup,
  IconSubscribed,
  IconList
} from '@arco-design/web-vue/es/icon';

export default defineComponent({
  components: {
    IconCaretRight,
    IconCaretLeft,
    IconHome,
    IconUserGroup,
    IconSubscribed,
    IconList
  },
  methods: {
    onClickMenuItem(key) {
      // Message.info({ content: `You select ${key}`, showIcon: true });
      this.$router.push(key);
    }
  }
});
</script>
<style scoped>
.layout-demo {
  height: 99vh;
  background: var(--color-fill-2);
  border: 1px solid var(--color-border);
}
.layout-demo :deep(.arco-layout-sider) .logo {
  height: 32px;
  margin: 12px 8px;
  background: rgba(255, 255, 255, 0.2);
}
.layout-demo :deep(.arco-layout-sider-light) .logo{
  background: var(--color-fill-2);
}
.layout-demo :deep(.arco-layout-header)  {
  height: 64px;
  line-height: 64px;
  background: var(--color-bg-3);
}
.layout-demo :deep(.arco-layout-footer) {
  height: 48px;
  color: var(--color-text-2);
  font-weight: 400;
  font-size: 14px;
  line-height: 48px;
}
.layout-demo :deep(.arco-layout-content) {
  color: var(--color-text-2);
  font-weight: 400;
  font-size: 14px;
  background: var(--color-bg-3);
}
.layout-demo :deep(.arco-layout-footer),
.layout-demo :deep(.arco-layout-content)  {
  display: flex;
  flex-direction: column;
  justify-content: center;
  color: var(--color-white);
  font-size: 16px;
  font-stretch: condensed;
  text-align: center;
}
</style>
