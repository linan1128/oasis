<script setup lang="ts">
import { useAppStore } from '@/store/app.ts'
import { useTagsViewStore,RouteItem } from '@/store/tagsView.ts';
import { useRoute, useRouter } from 'vue-router';
import {
  LeftOutlined,
  RightOutlined,
  DownOutlined,
} from '@vicons/antd';
import { GameControllerOutline, GameController } from '@vicons/ionicons5'
const appStore = useAppStore()
const tagsViewStore = useTagsViewStore();
const route = useRoute();
const router = useRouter();
const collapse = computed(() => appStore.sidebarCollapse);
const nameRef = ref()
const tabsList: any = computed(() => tagsViewStore.tabsList);
const panels = ref([])
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
const handleClose = (name: any) => {
  const routeInfo = tabsList.value.find((item: any) => item.fullPath == name);
  tagsViewStore.closeCurrentTab(routeInfo);
  if(name == route.fullPath){
    const currentRoute = tabsList.value[Math.max(0, tabsList.value.length - 1)];
    nameRef.value = currentRoute.fullPath;
    router.push(currentRoute);
  }
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
function handleClick (value: any) {
  router.push({ path: value });

}
function handleContextMenu(e: any, item: any){
  e.preventDefault();
  console.log(item)
}
const getSimpleRoute = (route: any): RouteItem => {
  const { fullPath, hash, meta, name, params, path, query } = route;
  return { fullPath, hash, meta, name, params, path, query };
};
watch(
    () => route.fullPath,
    (to) => {
      nameRef.value = to
      tagsViewStore.addTabs(getSimpleRoute(route))
    },
    { immediate: true }
);

</script>

<template>
  <n-el class="tags" :class="{'tags-sidebar-collapse': collapse }">
    <n-tabs
        ref="tabs1"
        v-model:value="nameRef"
        type="card"
        :closable="true"
        :tab-style="{'min-width': '60px','justify-content':'center'}"
        @close="handleClose"
        @update:value="handleClick"
    >
      <template v-for="tab in tabsList">
        <n-tab
            v-if="tab.path != '/index'"
            closable
            :name="tab.fullPath"
            @contextmenu="handleContextMenu($event, tab)"
        >
          {{tab.meta.title}}
        </n-tab>

        <n-tab
            v-else
            :name="tab.fullPath"
            @contextmenu="handleContextMenu($event, tab)"
        >
          {{tab.meta.title}}
        </n-tab>
      </template>
      <template #prefix>
        <n-el class="prev" @click="scrollPrev">
          <n-icon size="16">
            <LeftOutlined></LeftOutlined>
          </n-icon>
        </n-el>
      </template>
      <template #suffix>
        <n-space>
          <n-el class="next" @click="scrollNext">
            <n-icon size="16">
              <RightOutlined></RightOutlined>
            </n-icon>
          </n-el>
          <n-dropdown trigger="hover" :options="options" @select="handleSelect">
            <n-el class="next">
              <n-icon size="16">
                <DownOutlined></DownOutlined>
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
      &:hover {
        border: 1px solid var(--primary-color) !important;
      }
    }
    .n-tabs-tab--active {
      border: 1px solid var(--primary-color) !important;
      //background-color: var(--n-item-color-active)!important;
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
    color: var(--text-color-1);
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