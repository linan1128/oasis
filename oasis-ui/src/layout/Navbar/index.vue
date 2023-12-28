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
    <div style="display: flex;align-items: center;">
      <n-el style="display: flex;justify-content: center;align-items: center;color: var(--text-color-1);transition: .3s var(--cubic-bezier-ease-in-out);" @click="appStore.switchSidebarCollapse()">
        <n-icon size="18" v-if="collapse">
          <MenuUnfoldOutlined></MenuUnfoldOutlined>
        </n-icon>
        <n-icon size="18" v-else>
          <MenuFoldOutlined></MenuFoldOutlined>
        </n-icon>
      </n-el>
      <n-breadcrumb>
        <n-breadcrumb-item>
          系统设置
        </n-breadcrumb-item>
        <n-breadcrumb-item>
          角色管理
        </n-breadcrumb-item>
      </n-breadcrumb>
    </div>
    <div style="display: flex;justify-content: center;align-items: center">
      <n-space align="center">
        <div style="display: flex;justify-content: center;align-items: center">
          <n-button size="small" @click="appStore.switchDarkMod()">{{darkMod?'浅色':'深色'}}</n-button>
        </div>
        <n-el style="color: var(--text-color-base);transition: .3s var(--cubic-bezier-ease-in-out);">admin</n-el>
        <div style="width: 40px;height: 40px;background-color: #727c86;border-radius: 8px"></div>
      </n-space>
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
}
.navbar-sidebar-collapse{
  left: var(--sidebar-collapse-width);
}
</style>