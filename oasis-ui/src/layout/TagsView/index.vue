<script setup lang="ts">
import { useAppStore } from '@/store/app.ts'
import {
  LeftOutlined,
  RightOutlined,
  DownOutlined,
} from '@vicons/antd';
const appStore = useAppStore()
const collapse = computed(() => appStore.sidebarCollapse);
const panels = ref(["首页", "用户管理", "权限管理", "部门管理", "字典管理"])
const options = [
  {
    label: '刷新当前',
    key: "1"
  },
  {
    label: '关闭当前',
    key: '2'
  },
  {
    label: '关闭其他',
    key: '3'
  },
  {
    label: '关闭所有',
    key: '4'
  }
]

let tabs1 = ref();
const handleClose = () => {

}
const scrollPrev = () => {
  let leftValue = tabs1.value.xScrollInstRef.selfRef.scrollLeft-tabs1.value.scrollWrapperElRef.scrollWidth
  tabs1.value.xScrollInstRef.scrollTo({
    left:leftValue,
    behavior: "smooth"
  })
}
const scrollNext = () => {
  let leftValue = tabs1.value.xScrollInstRef.selfRef.scrollLeft+tabs1.value.scrollWrapperElRef.scrollWidth
  tabs1.value.xScrollInstRef.scrollTo({
    left:leftValue,
    behavior: "smooth"
  })
}
const handleSelect =  (key: string | number) => {

}

</script>

<template>
  <n-el class="tags" :class="{'tags-sidebar-collapse': collapse }">
    <n-tabs
        ref="tabs1"
        v-model:value="value"
        type="card"
        :closable="true"
        :tab-style="{'min-width': '60px','justify-content':'center'}"
        @close="handleClose"
    >
      <n-tab v-for="panel in panels" :key="panel" :name="panel">
        {{ panel }}
      </n-tab>
      <template #prefix>
        <n-el class="prev" @click="scrollPrev">
          <n-icon size="16" color="#515a6e">
            <n-el :tag="LeftOutlined" class="n-el-icon" />
          </n-icon>
        </n-el>
      </template>
      <template #suffix>
        <n-space>
          <n-el class="next" @click="scrollNext">
            <n-icon size="16" color="#515a6e">
              <n-el :tag="RightOutlined" class="n-el-icon" />
            </n-icon>
          </n-el>
          <n-dropdown trigger="hover" :options="options" @select="handleSelect">
            <n-el class="next">
              <n-icon size="16" color="#515a6e">
                <n-el :tag="DownOutlined" class="n-el-icon" />
              </n-icon>
            </n-el>
          </n-dropdown>
        </n-space>
      </template>
    </n-tabs>
  </n-el>
</template>

<style scoped lang="scss">
.tags{
  padding-top: 6px;
  padding-bottom: 6px;
  height: 44px;
  position: fixed;
  top: 64px;
  border-bottom: 1px solid var(--divider-color);
  left: var(--sidebar-width);
  box-sizing: border-box;
  background-color: var(--card-color);
  transition: .3s var(--cubic-bezier-ease-in-out);
  right: 0;
  :deep(.n-tabs){
    .n-tabs-tab{
      height: 31px;
      border-radius: 3px;
    }
    .n-tabs-tab--active {
      border: 1px solid var(--primary-color) !important;
      &:hover {

      }
    }
    .n-tabs-pad,
    .n-tabs-tab-pad,
    .n-tabs-scroll-padding {
      border: none !important;
    }
    .n-tabs-nav__prefix, .n-tabs-nav__suffix {
      padding: 0! important;
      border: none !important;
      padding-left: 12px! important;
      padding-right: 12px! important;

    }
  }
  .prev, .next {
    width: 31px;
    text-align: center;
    height: 31px;
    line-height: 29px;
    cursor: pointer;
    border-radius: 3px;
    box-sizing: border-box;
    transition: .3s var(--cubic-bezier-ease-in-out);
    border: 1px solid var(--border-color) !important;
    .n-icon {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 29px;
      width: 29px;
    }
  }
}
.tags-sidebar-collapse{
  left: var(--sidebar-collapse-width);
}
</style>