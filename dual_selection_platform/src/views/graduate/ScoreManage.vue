<template>
  <a-layout class="layout-demo">
    <a-layout-sider collapsible breakpoint="xl">
      <div class="logo" />
      <a-menu
          :default-open-keys="['1']"
          :default-selected-keys="['1_2']"
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
          <a-breadcrumb-item>考生管理</a-breadcrumb-item>
          <a-breadcrumb-item>复试成绩管理</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content>
          <!--          内容展示部分-->
          <a-table :columns="columns" :data="data" :scroll="scroll" column-resizable
                   :pagination="false" :bordered="{cell:true,wrapper: true}" @change="handleChange"
                   :style="{fontSize: '16px',height: '93%',fontFamily:'微软雅黑'}" >
            <template #stuname-filter="{ filterValue, setFilterValue, handleFilterConfirm, handleFilterReset}">
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
<!--            编辑成绩/综合评价-->
            <template #score="{ record }">
              <a-textarea v-if="record.editable" v-model="record.score" auto-size :max-length="50" allow-clear show-word-limit />
              <span v-else>{{ record.score }}</span>
            </template>
            <!-- 编辑时间-->
            <template #time="{ record }">
              <a-date-picker
                  v-if="record.editable" v-model="record.time"
                  style="width: 160px"
                  show-time
                  format="YYYY-MM-DD hh:mm"
                  @change="onChange"
                  @select="onSelect"
                  @ok="onOk"
              />
<!--              <a-date-picker v-if="record.editable" v-model="record.time" />-->
              <span v-else>{{ record.time }}</span>
            </template>
<!--            编辑地点-->
            <template #location="{ record }">
              <a-textarea v-if="record.editable" v-model="record.location" auto-size :max-length="50" allow-clear show-word-limit />
              <span v-else>{{ record.location }}</span>
            </template>
<!--            编辑保存框-->
            <template #edit="{ record }">
              <a-space>
                <a-button type="primary" status="warning" v-if="!record.editable" @click="handleEdit(record)">编辑</a-button>
                <a-button type="primary" status="success" v-if="!record.editable" disabled>保存</a-button>
              </a-space>
              <a-space>
                <a-button type="primary" status="warning" v-if="record.editable" disabled>编辑</a-button>
                <a-button type="primary" status="success" v-if="record.editable"  @click="handleSave(record)" >保存</a-button>
              </a-space>
            </template>
          </a-table>
          <!--          上传所有成绩按钮-->
          <a-button @click="handleSubmit" type="primary">上传所有成绩</a-button>
        </a-layout-content>


        <!--        <a-layout-footer>-->
        <!--&lt;!&ndash;          页脚部分&ndash;&gt;-->
        <!--          Footer-->
        <!--        </a-layout-footer>-->
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import {defineComponent, onMounted, reactive, h} from 'vue';
import { Message } from '@arco-design/web-vue';
import { useRouter } from 'vue-router'; // 引入 useRouter 钩子
import {
  IconCaretRight,
  IconCaretLeft,
  IconCalendar,
  IconSearch
} from '@arco-design/web-vue/es/icon';
import axios from "axios";

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

    // 从数据库获取复试成绩数据
    const fetchData = async () => {
      try {
        const response = await axios.get('/findSecondViewAll');
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
        dataIndex: 'stuname',
        fixed:'left',
        filterable: {
          filter: (value, record) => record.stuname.includes(value),
          slotName: 'stuname-filter',
          icon: () => h(IconSearch),
        }
      },
      {
        title: '性别',
        dataIndex: 'gender',
        filterable: {
          filters: [{
            text: '男',
            value: '男',
          }, {
            text: '女',
            value: '女',
          },],
          filter: (value, row) => row.gender.includes(value),
        }
      },
      {
        title: '准考证号',
        dataIndex: 'id_number',
        filterable: {
          filter: (value, record) => record.id_number.includes(value),
          slotName: 'stuname-filter',
          icon: () => h(IconSearch),
        }
      },{
        title: '复试科目',
        dataIndex: 'course',
        filterable: {
          filters: [{
            text: '外语听力与口语',
            value: '外语听力与口语',
          }, {
            text: '专业知识测试',
            value: '专业知识测试',
          },{
            text: '综合素质面试',
            value: '综合素质面试',
          },{
            text: '综合评价',
            value: '综合评价',
          }],
          filter: (value, row) => row.course.includes(value),
        }
      },{
        title: '复试时间',
        dataIndex: 'time',
        slotName: 'time',
      },
      {
        title: '地点',
        dataIndex: 'location',
        slotName: 'location',
      },
      {
        title: '成绩/综合评价',
        dataIndex: 'score',
        slotName: 'score',
      },
      {
        title: '编辑成绩',
        dataIndex: 'edit',
        slotName: 'edit',
      }
    ];

    //表格滑动
    const scroll = {
      x:1800,
      y:520
    }

    //表格数据
    const data = reactive([
      { stuname: '陈卓妍', gender: '女', id_number: '123456789012345', course: '综合素质面试', score: '0' },
      { stuname: '陈卓妍', gender: '女', id_number: '123456789012345', course: '综合评价', score: '无' },
      { stuname: '丁佳欣', gender: '女', id_number: '234567890123456', course: '外语听力与口语', score: '0' },
      { stuname: '丁佳欣', gender: '女', id_number: '234567890123456', course: '综合评价', score: '无' },
      { stuname: '苏畅', gender: '女', id_number: '345678901234567', course: '外语听力与口语', score: '0' },
      { stuname: '苏畅', gender: '女', id_number: '345678901234567', course: '专业知识测试', score: '0' },
      { stuname: '夏羽迪', gender: '女', id_number: '456789012345678', course: '综合素质面试', score: '0' },
      { stuname: '夏羽迪', gender: '女', id_number: '456789012345678', course: '综合评价', score: '无' },
    ].map(item => ({ ...item, editable: false })));

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
      onClickMenuItem,
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
