<script setup lang="ts">
import { useAppStore } from '@/store/app.ts'
const appStore = useAppStore()
const collapse = computed(() => appStore.sidebarCollapse);
</script>

<template>
  <div class="app-main" :class="{'app-main-sidebar-collapse': collapse}">
    <n-scrollbar>
      <div style="padding-left: 12px;padding-right: 12px">
        <router-view v-slot="{ Component, route }">
          <transition name="zoom-fade" mode="out-in" appear>
            <component :is="Component"/>
          </transition>
        </router-view>
      </div>
    </n-scrollbar>
  </div>
</template>

<style lang="scss" scoped>
.app-main {
  position: fixed;
  top: 64px;
  left: var(--sidebar-width);
  right: 0;
  bottom: 0;
  transition: left .3s cubic-bezier(.4, 0, .2, 1);
  :deep(.n-scrollbar-rail__scrollbar){
    width: 8px!important;
  }
}
.app-main-sidebar-collapse{
  left: var(--sidebar-collapse-width);
}
</style>