<script setup lang="ts">
import {
  MenuUnfoldOutlined,
  MenuFoldOutlined,
} from '@vicons/antd';
import { useAppStore } from '@/store/app.ts'
const appStore = useAppStore()
const collapse = computed(() => appStore.sidebarCollapse);
const darkMod = computed(() => appStore.darkMod);
</script>

<template>
  <n-el tag="div" class="navbar" :class="{'navbar-sidebar-collapse': collapse }" style="display: flex;justify-content: space-between;padding-left: 20px;padding-right: 20px;">
    <div style="display: flex;justify-content: center;align-items: center" @click="appStore.switchSidebarCollapse()">
      <n-icon size="18" v-if="collapse">
        <n-el :tag="MenuUnfoldOutlined" class="collapseIcon" />
      </n-icon>
      <n-icon size="18" v-else>
        <n-el :tag="MenuFoldOutlined" class="collapseIcon" />
      </n-icon>
    </div>
    <div style="display: flex;justify-content: center;align-items: center">
      <n-button size="small" @click="appStore.switchDarkMod()">{{darkMod?'浅色':'深色'}}</n-button>
    </div>
  </n-el>

</template>

<style lang="scss" scoped>
.navbar{
  height: var(--navbar-height);
  position: fixed;
  left: var(--sidebar-width);
  right: 0;
  box-sizing: border-box;
  //box-shadow: 2px 0 8px 0 #f5f5f5;
  background-color: var(--card-color);
  transition: .3s var(--cubic-bezier-ease-in-out);
  border-bottom: 1px solid var(--divider-color);
  .collapseIcon{
    color: var(--text-color-base);
    transition: .3s var(--cubic-bezier-ease-in-out);
  }
}
.navbar-sidebar-collapse{
  left: var(--sidebar-collapse-width);
}
</style>