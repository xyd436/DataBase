<template>
  <a-layout class="layout-demo">
    <a-layout-sider collapsible breakpoint="xl">
      <div class="logo" />
      <a-menu
          :default-open-keys="['3']"
          :default-selected-keys="['/RecruitmentManagement']"
          :style="{ width: '100%' }"
          @menu-item-click="onClickMenuItem"
      >
        <a-menu-item key="/">
          <IconHome></IconHome>
          首页
        </a-menu-item>
        <a-menu-item key="/MentorManagement">
          <icon-user-group />
          导师管理
        </a-menu-item>

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
      </a-layout-header>
      <a-layout style="padding: 0 24px; display: flex; justify-content: space-between; height: 50px">
        <a-breadcrumb :style="{ margin: '16px 0' }">
          <a-breadcrumb-item>招生目录管理</a-breadcrumb-item>
        </a-breadcrumb>
        <a-space style="position: absolute; right:40px;margin: 16px 0">
          <!-- 添加按钮 -->
          <a-button type="primary" @click="onAdd">
            <template #icon><icon-plus /></template>
          </a-button>
          <!-- 删除按钮 -->
          <a-button type="primary" @click="onDelete">
            <template #icon><icon-delete /></template>
            <template #default>Delete</template>
          </a-button>
        </a-space>

        <!-- content -->
        <a-layout-content>
          <!--   招生目录表格显示       -->
          <!-- 表格组件，绑定 columns 和 data 属性 -->
          <a-table :columns="columns"
                   :data="admissionsData"
                   :span-method="spanMethodAll" span-all
                   column-resizable
                   :bordered="{wrapper: true, cell: true}"
                   :sticky-header="0"
                   :stripe="true"
          />
          <!--            &lt;!&ndash; 自定义列过滤器的模板 &ndash;&gt;-->
          <!--            <template #name-filter="{ filterValue, setFilterValue, handleFilterConfirm, handleFilterReset}">-->
          <!--              <div class="custom-filter">-->
          <!--                &lt;!&ndash; 使用垂直布局的空间组件 &ndash;&gt;-->
          <!--                <a-space direction="vertical">-->
          <!--                  &lt;!&ndash; 输入框，用于输入过滤值 &ndash;&gt;-->
          <!--                  <a-input :model-value="filterValue[0]" @input="(value)=>setFilterValue([value])" />-->
          <!--                  &lt;!&ndash; 自定义过滤器的页脚，包含确认和重置按钮 &ndash;&gt;-->
          <!--                  <div class="custom-filter-footer">-->
          <!--                    &lt;!&ndash; 点击确认按钮时触发过滤确认 &ndash;&gt;-->
          <!--                    <a-button @click="handleFilterConfirm">Confirm</a-button>-->
          <!--                    &lt;!&ndash; 点击重置按钮时重置过滤器 &ndash;&gt;-->
          <!--                    <a-button @click="handleFilterReset">Reset</a-button>-->
          <!--                  </div>-->
          <!--                </a-space>-->
          <!--              </div>-->
          <!--            </template>-->
          <!--          </a-table>-->
        </a-layout-content>

        <!-- footer -->
        <a-layout-footer style="color: #E5E6E8">
          <p>&copy; 2024. djx. 数据库.</p>
          <!--          <p>联系方式: example@example.com</p>-->
          <!--          <p><a href="/privacy-policy">隐私政策</a> | <a href="/terms-of-use">使用条款</a></p>-->
        </a-layout-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import {defineComponent, onMounted, reactive, ref} from 'vue';
// import { Message} from '@arco-design/web-vue';
import axios from 'axios';
import {
  IconCaretRight,
  IconCaretLeft,
  IconHome,
  IconUserGroup,
  IconSubscribed,
  IconList,
  IconPlus, IconDelete
} from '@arco-design/web-vue/es/icon';
import {useRouter} from "vue-router";

export default defineComponent({
  name: 'RecuitmentManagement',
  components: {
    IconCaretRight,
    IconCaretLeft,
    IconHome,
    IconUserGroup,
    IconSubscribed,
    IconList,
    IconPlus,
    IconDelete
  },
  methods: {
    onClickMenuItem(key) {
      // Message.info({ content: `You select ${key}`, showIcon: true });
      this.$router.push(key);
    },
  },
  setup() {
    const admissionsData = reactive([]);  // 招生数据
    const selectedKeys = reactive([]);    // 选择的行键
    const rowspanData = ref({});           // 合并行数据缓存

    // 定义合并单元格方法
    const spanMethodAll = ({ rowIndex, columnIndex }) => {
      const fieldsToMerge = ['discipline', 'disciplineCode', 'totalQuota','recommendationQuota','course', 'note','mentor'];
      const columnKey = fieldsToMerge[columnIndex]; // 根据列索引获得列名

      // 缓存行合并信息
      if (Object.keys(rowspanData.value).length === 0) {
        let currentDisciplineCode = null;
        let rowspanCount = 0;

        admissionsData.forEach((row, index) => {
          if (row.disciplineCode !== currentDisciplineCode) {
            // 当出现新专业代码时，重置统计
            currentDisciplineCode = row.disciplineCode;
            rowspanCount = 1;
            rowspanData.value[index] = { rowspan: rowspanCount };
          } else {
            // 当专业代码相同时，继续累加行数
            rowspanCount += 1;
            rowspanData.value[index - rowspanCount + 1].rowspan = rowspanCount;
            rowspanData.value[index] = { rowspan: 0 }; // 设为0表示隐藏该行
          }
        });
      }

      const rowspanInfo = rowspanData.value[rowIndex];
      if (!rowspanInfo || rowspanInfo.rowspan === 0) return { rowspan: 0, colspan: 0 };

      if (columnKey) {
        return { rowspan: rowspanInfo.rowspan, colspan: 1 }; // 合并指定列
      }
      return { rowspan: 1, colspan: 1 };
    };

    // 定义列
    const columns = [
      { title: '学科',
        dataIndex: 'discipline' ,
        width:150
      },
      { title: '学科代码',
        dataIndex: 'disciplineCode',
        width: 90,
        minWidth: 50
      },
      { title: '研究方向',
        dataIndex: 'fieldName',
        width: '5%'
      },
      { title: '总招生数',
        dataIndex: 'totalQuota'
      },
      { title: '推免数',
        dataIndex: 'recommendationQuota',
        width:80
      },
      { title: '考试科目',
        dataIndex: 'course'
      },
      { title: '备注',
        dataIndex: 'note'
      },
      { title: '导师',
        dataIndex: 'mentor',
        width:160,
        minWidth:80
      },
    ];

    // 获取招生数据
    const fetchAdmissionsData = async () => {
      try {
        const response = await axios.get('/selectAllAdmissions');
        if (response.data && Array.isArray(response.data)) {
          console.log(response.data);
          admissionsData.splice(0, admissionsData.length, ...response.data);
          rowspanData.value = {}; // 重置合并信息缓存，以便重新计算
        } else {
          console.error('Invalid data format:', response.data);
        }
      } catch (error) {
        console.error('Failed to fetch admissions data:', error);
      }
    };

    // 添加按钮功能
    const onAdd = () => {
      // 使用 $router 推入新路径
      // 在 setup 中通过调用 useRouter 实现
      const router = useRouter();
      router.push({ path: '/addAdmissions' });
    };

    // 删除按钮功能
    const onDelete = async () => {
      if (selectedKeys.length === 0) {
        alert("请选择要删除的条目");
        return;
      }
      if (confirm("确认删除所选条目？")) {
        try {
          await axios.post('/deleteAdmissions', { ids: selectedKeys });
          alert("删除成功");
          fetchAdmissionsData(); // 重新获取数据
        } catch (error) {
          console.error("删除失败", error);
        }
      }
    };

    // 组件挂载时获取数据
    onMounted(fetchAdmissionsData);

    return {
      columns,
      admissionsData,
      spanMethodAll,
      selectedKeys,
      onAdd,
      onDelete,
    };
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

.layout-demo :deep(.arco-layout-sider-light) .logo {
  background: var(--color-fill-2);
}

.layout-demo :deep(.arco-layout-header) {
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
.layout-demo :deep(.arco-layout-content) {
  display: flex;
  flex-direction: column;
  justify-content: center;
  color: var(--color-white);
  font-size: 16px;
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
