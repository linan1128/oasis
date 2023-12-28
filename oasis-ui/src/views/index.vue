<script setup lang="ts">

</script>

<template>
  <div>
    <n-grid x-gap="12" cols="2 m:4 xl:8" responsive="screen" :collapsed="true" style="height: 108px">
      <n-gi>
        <div class="light-green" />
      </n-gi>
      <n-gi>
        <div class="green" />
      </n-gi>
      <n-gi>
        <div class="light-green" />
      </n-gi>
      <n-gi>
        <div class="green" />
      </n-gi>
      <n-gi>
        <div class="light-green" />
      </n-gi>
      <n-gi>
        <div class="green" />
      </n-gi>
      <n-gi>
        <div class="light-green" />
      </n-gi>
      <n-gi>
        <div class="green" />
      </n-gi>
    </n-grid>
    <n-grid x-gap="12" cols="2 m:2 xl:4" responsive="screen" :collapsed="true" style="margin-top: 16px;height: 168px">
      <n-gi>
        <div class="light-green" />
      </n-gi>
      <n-gi>
        <div class="green" />
      </n-gi>
      <n-gi>
        <div class="light-green" />
      </n-gi>
      <n-gi>
        <div class="green" />
      </n-gi>
    </n-grid>
    <n-grid x-gap="12" cols="1 m:2 xl:2" responsive="screen" :collapsed="true" style="margin-top: 16px;height: 268px">
      <n-gi>
        <div class="light-green" />
      </n-gi>
      <n-gi>
        <div class="green" />
      </n-gi>
    </n-grid>
  </div>
</template>

<style scoped>
.light-green {
  height: 100%;
  background-color: rgba(0, 128, 0, 0.12);
}
.green {
  height: 100%;
  background-color: rgba(0, 128, 0, 0.24);
}
</style>