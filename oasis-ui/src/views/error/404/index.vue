<script setup lang="ts">
import {useRouter} from "vue-router";

const router = useRouter();

</script>

<template>
  <n-result status="404" title="404 资源不存在" description="">
<!--    <template #footer>-->

<!--        <n-button @click="()=>router.replace('/index')" >找点乐子吧</n-button>-->

<!--    </template>-->
  </n-result>
</template>

<style scoped lang="scss">

</style>