<template>
  <a-layout class="layout-demo">
    <a-layout-sider collapsible breakpoint="xl">
      <div class="logo" />
      <a-menu
          :default-open-keys="['1']"
          :default-selected-keys="['0_3']"
          :style="{ width: '100%'}"
          @menu-item-click="onClickMenuItem"
      >
        <a-sub-menu key="1">
          <template #title>
            <IconCalendar></IconCalendar> 考生管理
          </template>
          <a-menu-item key="1_1">成绩导入</a-menu-item>
          <a-menu-item key="1_2">成绩管理</a-menu-item>
        </a-sub-menu>

        <a-sub-menu key="2">
          <template #title>
            <IconCalendar></IconCalendar> 录取管理
          </template>
          <a-menu-item key="2_1">复试信息审核</a-menu-item>
          <a-menu-item key="2_2">复试导师质疑</a-menu-item>
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
          <a-breadcrumb-item>考生管理</a-breadcrumb-item>
          <a-breadcrumb-item>成绩导入</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content>
<!--          内容展示部分-->
          <a-table :columns="columns" :data="data" :scroll="scroll" :expandable="expandable"
                   :pagination="false" :bordered="{cell:true}" @change="handleChange" column-resizable
                   :style="{fontSize: '16px'}">
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
          </a-table>
        </a-layout-content>

        <a-layout-footer>
<!--          页脚部分-->
          Footer
        </a-layout-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import { defineComponent } from 'vue';
import { Message } from '@arco-design/web-vue';
import { useRouter } from 'vue-router'; // 引入 useRouter 钩子
import {
  IconCaretRight,
  IconCaretLeft,
  IconCalendar,
} from '@arco-design/web-vue/es/icon';
import { reactive, h } from 'vue';
import { IconSearch } from '@arco-design/web-vue/es/icon';

//一键切换颜色模式
//document.body.setAttribute('arco-theme', 'dark')
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
          router.push('/'); // 跳转到成绩导入页面
          Message.info({ content: `跳转到成绩导入页面`, showIcon: true });
          break;
        case '1_2':
          router.push('/ScoreManage'); // 跳转到成绩管理页面
          Message.info({ content: `跳转到成绩管理页面`, showIcon: true });
          break;
        case '2_1':
          router.push('/InfoRetest'); // 跳转到复试信息审核页面
          Message.info({ content: `跳转到复试信息审核页面`, showIcon: true });
          break;
        case '2_2':
          router.push('/TeacherQuestion'); // 跳转到复试导师质疑页面
          Message.info({ content: `跳转到复试导师质疑页面`, showIcon: true });
          break;
        default:
          // 其他情况可以不做处理或者跳转到默认页面
          break;
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
        dataIndex: 'sex',
      },
      {
        title: '准考证号',
        dataIndex: 'exam_id',
      },
      {
        title: '初始成绩',
        children:[{
          title: '科目',
          dataIndex: 'initial_course_name',
        },{
          title: '成绩',
          dataIndex: 'initial_score'
        }]
      },
      {
        title: '复试成绩',
        children: [{
          title: '科目',
          dataIndex: 'second_course_name',
        },{
          title: '成绩',
          dataIndex: 'second_score'
        }]
      },
      {
        title: '状态',
        dataIndex: 'status'
      }
    ];

    const scroll = {
      x:1000,
      y:500
    }

    const data = reactive([{
      key: '1',
      name: 'Jane Doe',
      sex: '男',
      initial_course_name: '数学一',
      initial_score: '123',
    }, {
      key: '2',
      name: 'Alisa Ross',
      sex: '女',
      initial_course_name: '英语一',
      initial_score: '88',
    }, {
      key: '3',
      name: 'Kevin Sandra',
      sex: '男',
      initial_course_name: '思想政治',
      initial_score: '83',
    }, {
      key: '4',
      name: 'Ed Hellen',
      sex: '女',
      initial_course_name: '408计算机基础',
      initial_score: '103',
    }, {
      key: '5',
      name: 'William Smith',
      sex: '男',
      initial_course_name: '数学一',
      initial_score: '100',
    }]);

    const handleChange = (data, extra, currentDataSource) => {
      console.log('change', data, extra, currentDataSource)
    }

    return {
      columns,
      data,
      scroll,
      handleChange,
      onClickMenuItem
    }
  },
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
