<script setup lang="ts">
import { zhCN, dateZhCN } from 'naive-ui'
import Content from "@/components/Application/content.vue";
</script>

<template>
  <n-config-provider :locale="zhCN" :date-locale="dateZhCN">
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
