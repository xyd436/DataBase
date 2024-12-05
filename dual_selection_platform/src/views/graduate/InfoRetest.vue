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
            <icon-user-group />
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
          <a-breadcrumb-item>复试信息审核</a-breadcrumb-item>
        </a-breadcrumb>

        <a-layout-content>
          <a-table :columns="columns" :data="data" :scroll="scroll" column-resizable
                   :pagination="false" :bordered="{cell:true,wrapper: true}" @change="handleChange"
                   :style="{fontSize: '16px',height: '100%',fontFamily:'微软雅黑'}">
            <template #name-filter="{ filterValue, setFilterValue, handleFilterConfirm, handleFilterReset}">
              <div class="custom-filter">
                <a-space direction="vertical">
                  <a-input :model-value="filterValue[0]" @input="(value)=>setFilterValue([value])" />
                  <div class="custom-filter-footer">
                    <a-button @click="handleFilterConfirm">查找</a-button>
                    <a-button @click="handleFilterReset">重置</a-button>
                  </div>
                </a-space>
              </div>
            </template>

            <template #edit="{ record }">
              <a-space>
                <a-button type="primary" status="success" @click="handlePass(record)">通过</a-button>
                <a-button type="primary" status="warning" @click="handleFailed(record)" >驳回</a-button>
              </a-space>
            </template>
          </a-table>
          
          
        </a-layout-content>
        
<!--        <a-layout-footer>Footer</a-layout-footer>-->
      </a-layout>
    </a-layout>
  </a-layout>
</template>

<script>
import {h, onMounted} from 'vue';
import axios from "axios";
import {reactive} from "vue";
import { defineComponent } from 'vue';
import { Message } from '@arco-design/web-vue';
import { useRouter } from 'vue-router'; // 引入 useRouter 钩子
import {
  IconCaretRight,
  IconCaretLeft,
  IconCalendar, IconSearch,
} from '@arco-design/web-vue/es/icon';

export default defineComponent({
  components: {
    IconCaretRight,
    IconCaretLeft,
    IconCalendar,
  },
  setup() {
    const router = useRouter(); // 使用 useRouter 钩子

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

    // 获取招生数据
    const fetchData = async () => {
      try {
        const response = await axios.get('/findStuAll');
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

    const columns = [
      {
        title: '姓名',
        dataIndex: 'name',
        fixed:'left',
        filterable: {
          filter: (value, record) => record.name.includes(value),
          slotName: 'name-filter',
          icon: () => h(IconSearch),
        }
      },
      {
        title: '性别',
        dataIndex: 'gender',
      },
      {
        title: '出生日期',
        dataIndex: 'birth',
      },
      {
        title: '毕业院校',
        dataIndex: 'undergraduate_school',
      },
      {
        title: '本科专业',
        dataIndex: 'undergraduate_major',
      },
      {
        title: '应届类别',
        dataIndex: 'graduating_category',
      },
      {
        title: '定向类别',
        dataIndex: 'directed_category',
      },
      {
        title: '是否接收方向调整',
        dataIndex: 'adjust_accepted',
      },
      {
        title: '个人简介',
        dataIndex: 'introduction',
      },
      {
        title: '操作',
        dataIndex: 'edit',
        slotName: 'edit'
      }
    ];

    const data = reactive([{
      key: '1',
      name: 'Jane Doe',
      score: 23000,
      student_id: '32 Park Road, London',
      course_id: 'jane.doe@example.com'
    }]);

    //表格滑动
    const scroll = {
      x:1500,
      y:550
    }

    //处理审核通过
    const handlePass = () => {
      console.log('审核通过')
    };
    //处理审核不通过
    const handleFailed = () => {
      console.log('审核不通过')
    };
    const handleChange = (data, extra, currentDataSource) => {
      console.log('change', data, extra, currentDataSource)
    }

    onMounted(fetchData);

    return {
      onClickMenuItem,
      columns,
      data,
      scroll,
      handlePass,
      handleFailed,
      handleChange
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
  overflow: auto;
}
.layout-demo :deep(.arco-layout-footer),
.layout-demo :deep(.arco-layout-content)  {
  color: var(--color-white);
  font-size: 20px;
  font-stretch: condensed;
  text-align: center;
}
.custom-filter {
  padding: 20px;
  background: var(--color-bg-5);
  border: 1px solid var(--color-neutral-3);
  border-radius: var(--border-radius-medium);
  box-shadow: 0 2px 5px rgb(0 0 0 / 10%);
}
.custom-filter-footer {
  display: flex;
  justify-content: space-between;
}
</style>

