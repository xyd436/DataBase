<template>
  <a-layout class="layout-demo">
    <a-layout-sider collapsible breakpoint="xl">
      <div class="logo" />
      <a-menu
          :default-open-keys="['1']"
          :default-selected-keys="['2_2']"
          :style="{ width: '100%'}"
          @menu-item-click="onClickMenuItem"
      >
        <a-sub-menu key="1">
          <template #title>
            <IconCalendar></IconCalendar> 考生管理
          </template>
          <a-menu-item key="1_1">初试成绩管理</a-menu-item>
          <a-menu-item key="1_2">复试成绩管理</a-menu-item>
        </a-sub-menu>

        <a-sub-menu key="2">
          <template #title>
            <IconCalendar></IconCalendar> 录取管理
          </template>
          <a-menu-item key="2_1">复试导师质疑</a-menu-item>
          <a-menu-item key="2_2">复试信息审核</a-menu-item>
          <a-menu-item key="2_3">录取结果发布</a-menu-item>
        </a-sub-menu>
      </a-menu>
      <!-- trigger -->
      <template #trigger="{ collapsed }">
        <IconCaretRight v-if="collapsed"></IconCaretRight>
        <IconCaretLeft v-else></IconCaretLeft>
      </template>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="padding-left: 20px;font-size: 25px;font-weight: bold">
        研究生管理员系统
      </a-layout-header >
      <a-layout style="padding: 0 20px;">
        <a-breadcrumb :style="{ margin: '14px 0' }">
          <a-breadcrumb-item>录取管理</a-breadcrumb-item>
          <a-breadcrumb-item>复试信息审核（审核考生的信息）</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content>
          <template>
            <a-table :columns="columns" :data="data" />
          </template>
        </a-layout-content>
        <a-layout-footer>Footer</a-layout-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>

<script>
import {onMounted} from 'vue';
import axios from "axios";
import {reactive} from "vue";
import { defineComponent } from 'vue';
import { Message } from '@arco-design/web-vue';
import { useRouter } from 'vue-router'; // 引入 useRouter 钩子
import {
  IconCaretRight,
  IconCaretLeft,
  IconCalendar,
} from '@arco-design/web-vue/es/icon';

export default defineComponent({
  components: {
    IconCaretRight,
    IconCaretLeft,
    IconCalendar,
  },
  setup() {
    const router = useRouter(); // 使用 useRouter 钩子
    const columns = [
      {
        title: 'id',
        dataIndex: 'id',
        ellipsis: true,
        tooltip: true,
        width: 100
      },
      {
        title: 'score',
        dataIndex: 'score',
      },
      {
        title: 'student_id',
        dataIndex: 'student_id',
        ellipsis: true,
        width: 150,
      },
      {
        title: 'course_id',
        dataIndex: 'course_id',
        ellipsis: true,
        tooltip: {position: 'left'},
        width: 200,
      },
    ];
    const data = reactive([{
      key: '1',
      name: 'Jane Doe',
      score: 23000,
      student_id: '32 Park Road, London',
      course_id: 'jane.doe@example.com'
    }, {
      key: '2',
      name: 'Alisa Ross',
      score: 25000,
      student_id: '35 Park Road, London',
      course_id: 'alisa.ross@example.com'
    }, {
      key: '3',
      name: 'Kevin Sandra',
      score: 22000,
      student_id: '31 Park Road, London',
      course_id: 'kevin.sandra@example.com'
    }, {
      key: '4',
      name: 'Ed Hellen',
      score: 17000,
      student_id: '42 Park Road, London',
      course_id: 'ed.hellen@example.com'
    }, {
      key: '5',
      name: 'William Smith',
      score: 27000,
      student_id: '62 Park Road, London',
      course_id: 'william.smith@example.com'
    }]);

    // 获取招生数据
    const fetchData = async () => {
      try {
        const response = await axios.get('/findAll');
        if (response.data && Array.isArray(response.data)) {
          console.log(response.data);
          data.splice(0, data.length, ...response.data);
        } else {
          console.error('Invalid data format:', response.data);
        }
      } catch (error) {
        console.error('Failed to fetch admissions data:', error);
      }
    };

    onMounted(fetchData);

    const onClickMenuItem = (key) => {
      switch (key) {
        case '1_1':
          router.push('/'); // 跳转到初试成绩管理页面
          Message.info({ content: `跳转到初试成绩管理页面`, showIcon: true });
          break;
        case '1_2':
          router.push('/ScoreManage'); // 跳转到复试成绩管理页面
          Message.info({ content: `跳转到复试成绩管理页面`, showIcon: true });
          break;
        case '2_1':
          router.push('/TeacherQuestion'); // 跳转到复试导师质疑页面
          Message.info({ content: `跳转到复试导师质疑页面`, showIcon: true });
          break;
        case '2_2':
          router.push('/InfoRetest'); // 跳转到复试信息审核页面
          Message.info({ content: `跳转到复试信息审核页面`, showIcon: true });
          break;
        case '2_3':
          router.push('/ResultRelease'); // 跳转到录取信息发布页面
          Message.info({ content: `跳转到录取信息发布页面`, showIcon: true });
          break;
        default:
          // 其他情况可以不做处理或者跳转到默认页面
          break;
      }
    };

    return {
      onClickMenuItem,
      columns,
      data
    };
  }
});
</script>

<style scoped>
.layout-demo {
  height: 100vh;
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

