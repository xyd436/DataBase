<template>
  <a-layout class="layout-demo">
    <a-layout-sider collapsible breakpoint="xl">
      <div class="logo" />
      <a-menu
          :default-open-keys="['2','3']"
          :default-selected-keys="['/CandidateVolunteer']"
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
          <a-breadcrumb-item>考生志愿</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content>
          <!-- content -->
          <a-table :columns="columns" :data="data" :scroll="scroll" column-resizable
                   :pagination="false" :bordered="{cell:true,wrapper: true}" @change="handleChange"
                   :style="{fontSize: '16px',height: '100%',fontFamily:'微软雅黑'}">
            <template #stu-filter="{ filterValue, setFilterValue, handleFilterConfirm, handleFilterReset}">
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
        <a-layout-footer>Footer</a-layout-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import {defineComponent, h, onMounted, reactive} from 'vue';
import axios from "axios";
import {
  IconCaretRight,
  IconCaretLeft,
  IconHome,
  IconUserGroup,
  IconSubscribed,
  IconList, IconSearch
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
  },
  setup() {
    // 从数据库获取考生志愿、状态以及成绩
    const fetchData = async () => {
      try {
        const response = await axios.get('/selectAllChoices_Status_Scores');
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

    //表格
    const columns = [
      {
        title: '姓名',
        dataIndex: 'studentName',
        fixed:'left',
        filterable: {
          filter: (value, record) => record.studentName.includes(value),
          slotName: 'stu-filter',
          icon: () => h(IconSearch),
        }
      },
      {
        title: '准考证号',
        dataIndex: 'admissionTicketNumber',
        filterable: {
          filter: (value, record) => record.admissionTicketNumber.includes(value),
          slotName: 'stu-filter',
          icon: () => h(IconSearch),
        }
      },
      {
        title: '志愿顺序',
        dataIndex: 'priority',
        slotName: 'priority',
      },
      {
        title: '导师姓名',
        dataIndex: 'mentorName',
        slotName: 'mentorName',
      },
      {
        title: '研究方向',
        dataIndex: 'field',
        filterable: {
          filters: [{
            text: '大数据技术与人工智能',
            value: '大数据技术与人工智能',
          }, {
            text: '物联网与移动互联网技术',
            value: '物联网与移动互联网技术',
          },{
            text: '虚拟现实与计算机视觉',
            value: '虚拟现实与计算机视觉',
          },{
            text: '计算机技术',
            value: '计算机技术',
          },{
            text: '软件工程',
            value: '软件工程',
          },{
            text: '软件工程（国际联合培养）',
            value: '软件工程（国际联合培养）',
          },{
            text: '人工智能',
            value: '人工智能',
          },{
            text: '大数据技术与工程',
            value: '大数据技术与工程',
          },{
            text: '不分方向',
            value: '不分方向',
          }],
          filter: (value, row) => row.field.includes(value),
        }
      },
      {
        title: '学科',
        dataIndex: 'discipline',
        filterable: {
          filters: [{
            text: '计算机科学与技术',
            value: '计算机科学与技术',
          }, {
            text: '电子信息（全日制专业学位）',
            value: '电子信息（全日制专业学位）',
          },{
            text: '电子信息（非全日制专业学位）',
            value: '电子信息（非全日制专业学位）',
          },{
            text: '农业工程与信息技术（全日制专业学位）',
            value: '农业工程与信息技术（全日制专业学位）',
          }],
          filter: (value, row) => row.discipline.includes(value),
        }
      },
      {
        title: '志愿状态',
        dataIndex: 'status',
        filterable: {
          filters: [{
            text: '考生已提交',
            value: '考生已提交',
          }, {
            text: '同意录取',
            value: '同意录取',
          },{
            text: '被质疑',
            value: '被质疑',
          },{
            text: '被拒绝',
            value: '被拒绝',
          }],
          filter: (value, row) => row.status.includes(value),
        }
      },
      {
        title: '初试成绩',
        dataIndex: 'initialScores',
        slotName: 'initialScores',
      },
      {
        title: '复试成绩',
        dataIndex: 'secondScores',
        slotName: 'secondScores',
      }
    ];

    //表格滑动
    const scroll = {
      x:1800,
      y:690
    }

    //表格数据
    const data = reactive([].map(item => ({ ...item, editable: false })));

    //处理编辑按钮
    const handleEdit = (record) => {
      record.editable = true;
    };
    //处理数据保存
    const handleSave = (record) => {
      record.editable = false;
    };
    //处理数据提交
    const handleSubmit = () => {
      console.log('提交数据：', data);
    };
    const handleChange = (data, extra, currentDataSource) => {
      console.log('change', data, extra, currentDataSource)
    }


    // 组件挂载时获取数据
    onMounted(fetchData);

    return {
      columns,
      data,
      scroll,
      handleChange,
      handleEdit,
      handleSave,
      handleSubmit,
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
