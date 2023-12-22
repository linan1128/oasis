<script setup lang="ts">
window['$loading'] = useLoadingBar();
window['$loading'].finish();
window['$message'] = useMessage();
window['$notification'] = useNotification();
window['$dialog'] = useDialog();
</script>

<template>
  <slot name="default"></slot>
</template>

<style scoped>

</style>