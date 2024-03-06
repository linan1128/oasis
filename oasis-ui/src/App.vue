<script setup lang="ts">
import { zhCN, dateZhCN, darkTheme } from 'naive-ui'
import Content from "@/components/Application/content.vue";
import {useAppStore} from "@/store/app";
const appStore = useAppStore();
const darkMod = computed(() => appStore.darkMod);

const lightThemeOverrides = {
  common: {
    // bodyColor: '#f8f8fa'
  }
}

const darkThemeOverrides = {
  common: {

  }
}

</script>

<template>
  <n-config-provider :locale="zhCN" :date-locale="dateZhCN" :theme="darkMod?darkTheme:undefined" :theme-overrides="darkMod ? darkThemeOverrides : lightThemeOverrides">
    <n-loading-bar-provider>
      <n-dialog-provider>
        <n-notification-provider>
          <n-message-provider>
            <content>
              <router-view></router-view>
            </content>
          </n-message-provider>
        </n-notification-provider>
      </n-dialog-provider>
    </n-loading-bar-provider>
  </n-config-provider>
</template>

<style scoped>

</style>
