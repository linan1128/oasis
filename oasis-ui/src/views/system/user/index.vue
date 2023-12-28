<script setup lang="ts">
import { NTag } from 'naive-ui'
import { useElementSize , useWindowSize } from '@vueuse/core';
import { TreeOption } from 'naive-ui'
import {
  UpOutlined,
  DownOutlined,
} from '@vicons/antd';
const formCardRef = ref<HTMLElement|any>(null)
const formCollapsed = ref(true)
const tableCardHeight = ref(0);
const treeCardHeight = ref(0);
const WindowSize = useWindowSize()
const formCarSize = useElementSize(formCardRef)



const setTableHeight = () => {
  tableCardHeight.value = window.innerHeight - 108 - formCarSize.height.value -16 -44
  treeCardHeight.value = window.innerHeight - 108 -44
}

watch(WindowSize.height,setTableHeight)
watch(formCarSize.height,setTableHeight)


const formValue =  ref({
  user: {
    name: '',
    age: ''
  },
  phone: ''
})

const columns = [
  {
    title: 'id',
    key: 'id',
  },
  {
    title: '角色名称',
    key: 'name',
  },
  {
    title: '说明',
    key: 'explain',
  },
  {
    title: '是否默认角色',
    key: 'isDefault',
    render(row) {
      return h(
          NTag,
          {
            type: row.isDefault ? 'success' : 'error',
          },
          {
            default: () => (row.isDefault ? '是' : '否'),
          }
      );
    },
  },
  {
    title: '创建时间',
    key: 'create_date',
  },
];


const pattern = ref('')

const data: TreeOption[] = [
  {
    label: '总公司',
    key: '0',
    children: [
      {
        label: '子公司1',
        key: '0-0',
        children: [
          { label: '子公司1-部门1', key: '0-0-0' },
          { label: '子公司1-部门2', key: '0-0-1' }
        ]
      },
      {
        label: '子公司2',
        key: '0-1',
        children: [
          { label: '子公司2-部门1', key: '0-1-0' },
          { label: '子公司2-部门2', key: '0-1-1' }
        ]
      }
    ]
  }
]
</script>

<template>
  <div>

    <n-grid x-gap="12" :cols="5">
      <n-gi>
        <n-card style="min-height: 400px" :style="{height:`${treeCardHeight}px`}" content-style="padding-top:24px">
          <n-space vertical :size="12">
            <n-input v-model:value="pattern" placeholder="搜索" />
            <n-tree
                :show-irrelevant-nodes="false"
                :pattern="pattern"
                :data="data"
                block-line
            />
          </n-space>
        </n-card>
      </n-gi>
      <n-gi :span="4">
        <div ref="formCardRef" style="transition: 0.5s linear;">
          <n-card content-style="padding-bottom: 0;padding-top:24px">
            <n-form
                inline
                label-placement="left"
                :label-width="80"
                :model="formValue"
            >
              <n-grid :x-gap="12" cols="2 m:2 l:3 xl:4" responsive="screen" :collapsed="formCollapsed">
                <n-grid-item>
                  <n-form-item label="姓名" path="user.name">
                    <n-input v-model:value="formValue.user.name" placeholder="角色名称" />
                  </n-form-item>
                </n-grid-item>
                <n-grid-item>
                  <n-form-item label="年龄" path="user.age">
                    <n-input v-model:value="formValue.user.age" placeholder="权限字符" />
                  </n-form-item>
                </n-grid-item>
                <n-grid-item>
                  <n-form-item label="电话号码" path="phone">
                    <n-input v-model:value="formValue.phone" placeholder="状态" />
                  </n-form-item>
                </n-grid-item>
                <n-grid-item>
                  <n-form-item label="电话号码" path="phone">
                    <n-input v-model:value="formValue.phone" placeholder="状态" />
                  </n-form-item>
                </n-grid-item>
                <n-grid-item>
                  <n-form-item label="电话号码" path="phone">
                    <n-input v-model:value="formValue.phone" placeholder="状态" />
                  </n-form-item>
                </n-grid-item>
                <n-grid-item>
                  <n-form-item label="电话号码" path="phone">
                    <n-input v-model:value="formValue.phone" placeholder="状态" />
                  </n-form-item>
                </n-grid-item>
                <n-grid-item>
                  <n-form-item label="创建时间" path="timePickerValue">
                    <n-date-picker type="daterange" clearable />
                  </n-form-item>
                </n-grid-item>
                <n-grid-item suffix>
                  <n-form-item>
                    <div style="width: 100%;display: flex; justify-content: flex-end">
                      <n-space align="center">
                        <n-button type="primary"  attr-type="button">
                          查询
                        </n-button>
                        <n-button attr-type="button">
                          重置
                        </n-button>
                        <n-button text @click="()=>{formCollapsed=!formCollapsed;tableCardHeight = 0}" icon-placement="right">
                          {{formCollapsed?'展开':'收起'}}
                          <template #icon>
                            <n-icon>
                              <UpOutlined v-if="!formCollapsed" />
                              <DownOutlined v-else />
                            </n-icon>
                          </template>
                        </n-button>
                      </n-space>
                    </div>
                  </n-form-item>
                </n-grid-item>
              </n-grid>
            </n-form>
          </n-card>
        </div>

        <n-card style="margin-top: 16px;min-height: 300px" :style="{height:`${tableCardHeight}px`}">
          <n-data-table
              :flex-height="true"
              :style="{ height: `100%` }"
              :columns="columns"
          />
        </n-card>
      </n-gi>
    </n-grid>






  </div>
</template>