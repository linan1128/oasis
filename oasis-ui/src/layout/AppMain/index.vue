<script setup lang="ts">
import { useAppStore } from '@/store/app.ts'
const appStore = useAppStore()
const collapse = computed(() => appStore.sidebarCollapse);
const darkMod = computed(() => appStore.darkMod);
</script>

<template>
  <n-el tag="div" class="app-main" :class="{'app-main-sidebar-collapse': collapse}" :style="{'background-color':darkMod?'':'#f8f8fa'}">
    <n-scrollbar>
      <div style="padding-left: 12px;padding-right: 12px;padding-top: 16px">
        <router-view v-slot="{ Component, route }">
          <transition name="zoom-fade" mode="out-in" appear>
            <component :is="Component"/>
          </transition>
        </router-view>
      </div>
    </n-scrollbar>
  </n-el>
</template>

<style lang="scss" scoped>
.app-main {
  position: fixed;
  top: 108px;
  left: var(--sidebar-width);
  right: 0;
  bottom: 0;
  //background-color: #f3f5f7;
  background-color: var(--body-color);transition: .3s var(--cubic-bezier-ease-in-out);
  :deep(.n-scrollbar-rail__scrollbar){
    width: 8px!important;
  }
}
.app-main-sidebar-collapse{
  left: var(--sidebar-collapse-width);
}
</style>