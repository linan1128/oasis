<script setup lang="ts">
import {
  MenuUnfoldOutlined,
  MenuFoldOutlined,
} from '@vicons/antd';
import { useAppStore } from '@/store/app.ts'
const appStore = useAppStore()
const collapse = computed(() => appStore.sidebarCollapse);
</script>

<template>
  <div class="navbar" :class="{'navbar-sidebar-collapse': collapse }">
    <div style="display: flex;padding: 19px" @click="appStore.switchSidebarCollapse()">
      <n-icon size="18" v-if="collapse">
        <MenuUnfoldOutlined />
      </n-icon>
      <n-icon size="18" v-else>
        <MenuFoldOutlined />
      </n-icon>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.navbar{
  height: var(--navbar-height);
  position: fixed;
  left: var(--sidebar-width);
  right: 0;
  box-shadow: 2px 0 8px 0 #f5f5f5;
  transition: left .3s cubic-bezier(.4, 0, .2, 1);
}
.navbar-sidebar-collapse{
  left: var(--sidebar-collapse-width);
}
</style>