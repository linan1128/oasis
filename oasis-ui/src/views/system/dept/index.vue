<script setup lang="ts">
import type { DataTableColumns } from 'naive-ui'
import { getDeptList } from '@/api/system/dept.ts'
import { FormInst,NButton,NSpace } from 'naive-ui'
const formValue =  ref({
  deptName: '',
  // status: ''
})
type RowData = {
  id: number
  deptName: string
  sort:number
  children?: RowData[]
}

const showTable = ref(false)

const data = ref([] as RowData[])
const loading = ref(false)

const getList = ()=>{
  loading.value = true
  getDeptList(formValue.value).then((res)=>{
    showTable.value= false
    data.value = res.data
    //fix table default-expand-all
    showTable.value= true

    loading.value = false
  })
}

getList()


const columns: DataTableColumns<RowData> = [
  {
    title: '部门名称',
    key: 'deptName'
  },
  {
    title: 'id',
    key: 'id'
  },
  {
    title: 'Action',
    key: 'actions',
    render(row) {
      return h(NSpace,{},{default: () => {
        return [h(
            NButton,
            {
              strong: true,
              tertiary: true,
              size: 'small',
              onClick: () => {console.log(row)}
            },
            {default: () => 'Play'}
        ),h(
            NButton,
            {
              strong: true,
              tertiary: true,
              size: 'small',
              onClick: () => {}
            },
            {default: () => 'Play'}
        )]
        }})
    }
  }
]

const reSetForm = () => {
  formValue.value.deptName = ''
  // formValue.value.status = ''
}


const showModal = ref(false)

const rowKey = (row: RowData) => {row.id}







const model = ref({
  inputValue: null,
  textareaValue: null,
  selectValue: null,
  multipleSelectValue: null,
  datetimeValue: null,
  nestedValue: {
    path1: null,
    path2: null
  },
  switchValue: false,
  checkboxGroupValue: null,
  radioGroupValue: null,
  radioButtonGroupValue: null,
  inputNumberValue: null,
  timePickerValue: null,
  sliderValue: 0,
  transferValue: null
})

const rules = {
  inputValue: {
    required: true,
        trigger: ['blur', 'input'],
        message: '请选择上级部门'
  },
  textareaValue: {
    required: true,
        trigger: ['blur', 'input'],
        message: '请输入 textareaValue'
  },
  selectValue: {
    required: true,
        trigger: ['blur', 'change'],
        message: '请选择 selectValue'
  },
  multipleSelectValue: {
    type: 'array',
        required: true,
        trigger: ['blur', 'change'],
        message: '请选择 multipleSelectValue'
  },
  datetimeValue: {
    type: 'number',
        required: true,
        trigger: ['blur', 'change'],
        message: '请输入 datetimeValue'
  },
  nestedValue: {
    path1: {
      required: true,
          trigger: ['blur', 'input'],
          message: '请输入 nestedValue.path1'
    },
    path2: {
      required: true,
          trigger: ['blur', 'change'],
          message: '请输入 nestedValue.path2'
    }
  },
  checkboxGroupValue: {
    type: 'array',
        required: true,
        trigger: 'change',
        message: '请选择 checkboxGroupValue'
  },
  radioGroupValue: {
    required: true,
        trigger: 'change',
        message: '请选择 radioGroupValue'
  },
  radioButtonGroupValue: {
    required: true,
        trigger: 'change',
        message: '请选择 radioButtonGroupValue'
  },
  inputNumberValue: {
    type: 'number',
        required: true,
        trigger: ['blur', 'change'],
        message: '请输入 inputNumberValue'
  },
  timePickerValue: {
    type: 'number',
        required: true,
        trigger: ['blur', 'change'],
        message: '请输入 timePickerValue'
  },
}
const formRef = ref<FormInst | null>(null)
const handleValidateButtonClick = (e: MouseEvent) => {
  e.preventDefault()
  formRef.value?.validate((errors) => {
    if (!errors) {
      window['$message'].success('验证成功')
    } else {
      window['$message'].error('验证失败')
    }

    console.log(model.value)

  })
}









const options = [
  {
    label: 'Rubber Soul',
    key: 'Rubber Soul',
    children: [
      {
        label:
            "Everybody's Got Something to Hide Except Me and My Monkey",
        key: "Everybody's Got Something to Hide Except Me and My Monkey"
      },
      {
        label: 'Drive My Car',
        key: 'Drive My Car',
        disabled: true
      },
      {
        label: 'Norwegian Wood',
        key: 'Norwegian Wood'
      },
      {
        label: "You Won't See",
        key: "You Won't See",
        disabled: true
      },
      {
        label: 'Nowhere Man',
        key: 'Nowhere Man'
      },
      {
        label: 'Think For Yourself',
        key: 'Think For Yourself'
      },
      {
        label: 'The Word',
        key: 'The Word'
      },
      {
        label: 'Michelle',
        key: 'Michelle',
        disabled: true
      },
      {
        label: 'What goes on',
        key: 'What goes on'
      },
      {
        label: 'Girl',
        key: 'Girl'
      },
      {
        label: "I'm looking through you",
        key: "I'm looking through you"
      },
      {
        label: 'In My Life',
        key: 'In My Life'
      },
      {
        label: 'Wait',
        key: 'Wait'
      }
    ]
  },
  {
    label: 'Let It Be',
    key: 'Let It Be Album',
    children: [
      {
        label: 'Two Of Us',
        key: 'Two Of Us'
      },
      {
        label: 'Dig A Pony',
        key: 'Dig A Pony'
      },
      {
        label: 'Across The Universe',
        key: 'Across The Universe'
      },
      {
        label: 'I Me Mine',
        key: 'I Me Mine'
      },
      {
        label: 'Dig It',
        key: 'Dig It'
      },
      {
        label: 'Let It Be',
        key: 'Let It Be'
      },
      {
        label: 'Maggie Mae',
        key: 'Maggie Mae'
      },
      {
        label: "I've Got A Feeling",
        key: "I've Got A Feeling"
      },
      {
        label: 'One After 909',
        key: 'One After 909'
      },
      {
        label: 'The Long And Winding Road',
        key: 'The Long And Winding Road'
      },
      {
        label: 'For You Blue',
        key: 'For You Blue'
      },
      {
        label: 'Get Back',
        key: 'Get Back'
      }
    ]}]







</script>

<template>
<div id="drawer-target">
  <div ref="formCardRef">
    <n-card content-style="padding-bottom: 0;padding-top:24px">
      <n-form
          inline
          label-placement="left"
          :label-width="80"
          :model="formValue"
      >
        <n-grid :x-gap="12" cols="2 m:3 l:4 xl:5" responsive="screen">
          <n-grid-item>
            <n-form-item label="部门名称" path="deptName">
              <n-input v-model:value="formValue.deptName" placeholder="请输入部门名称" />
            </n-form-item>
          </n-grid-item>
<!--          <n-grid-item>-->
<!--            <n-form-item label="状态" path="status">-->
<!--              <n-input v-model:value="formValue.status" placeholder="部门状态" />-->
<!--            </n-form-item>-->
<!--          </n-grid-item>-->
          <n-grid-item suffix>
            <n-form-item>
              <div style="width: 100%;display: flex; justify-content: flex-end">
                <n-space align="center">
                  <n-button type="primary" @click="getList">
                    查询
                  </n-button>
                  <n-button attr-type="button" @click="reSetForm">
                    重置
                  </n-button>
                </n-space>
              </div>
            </n-form-item>
          </n-grid-item>
        </n-grid>
      </n-form>
    </n-card>
  </div>
  <n-card style="margin-top: 16px;">
    <div style="padding-bottom: 12px">
      <n-button type="primary" @click="showModal = true">
        新增
      </n-button>
    </div>
    <n-data-table
        size="small"
        :loading="loading"
        v-if="showTable"
        :columns="columns"
        :data="data"
        :row-key="rowKey"
        default-expand-all
    />
  </n-card>
  <n-modal
      v-model:show="showModal"
      preset="card"
      :style="{
        width: '60%',
        height:'80vh',
        minHeight:'300px'
      }"
      :content-style="{
        overflow:'auto',
        padding:'0'
      }"

      title="新增部门"
      :bordered="true"
      :segmented="true"
      :mask-closable="false"
      :auto-focus="false"
  >
    <n-scrollbar>
      <div style="padding: 20px">
        <n-form
            ref="formRef"
            :model="model"
            :rules="rules"
            label-placement="left"
            label-width="auto"
            require-mark-placement="right-hanging"
        >
          <n-form-item label="上级部门" path="inputValue">
            <n-tree-select
                v-model:value="model.inputValue"
                :options="options"
                default-value="Drive My Car"
            />
          </n-form-item>
          <n-form-item label="部门名称" path="textareaValue">
            <n-input v-model:value="model.textareaValue" placeholder="请填写部门名称" />
          </n-form-item>
          <n-form-item label="排序" path="inputNumberValue">
            <n-input-number v-model:value="model.inputNumberValue" />
          </n-form-item>
          <n-form-item label="状态" path="radioGroupValue">
            <n-radio-group v-model:value="model.radioGroupValue" name="radiogroup1">
              <n-space>
                <n-radio value="Radio 1">
                  Radio 1
                </n-radio>
                <n-radio value="Radio 2">
                  Radio 2
                </n-radio>
              </n-space>
            </n-radio-group>
          </n-form-item>


        </n-form>
      </div>
    </n-scrollbar>
    <template #footer>
      <n-space justify="end">
        <n-button type="primary" @click="handleValidateButtonClick">确定</n-button>
        <n-button @click="showModal=false">取消</n-button>
      </n-space>
    </template>
  </n-modal>
</div>

</template>

<style scoped lang="scss">

</style>