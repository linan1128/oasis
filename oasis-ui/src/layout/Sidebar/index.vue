<script setup lang="ts">
import { useMessage,MenuInst  } from 'naive-ui'
import { useAppStore } from '@/store/app.ts'
import { useRoute, useRouter } from 'vue-router';
const route = useRoute();
const router = useRouter();
const appStore = useAppStore()
const collapse = computed(() => appStore.sidebarCollapse);
const menus = [
  {
    label: '首页',
    key: '/index',
  },
  {
    label: '系统管理',
    key: 'system',
    children: [
      {
        label: '用户管理',
        key: '/system/user'
      },
      {
        label: '部门管理',
        key: '/system/dept'
      },
      {
        label: '菜单管理',
        key: '/system/menu'
      },
      {
        label: '权限管理',
        key: '/system/role'
      }
    ]
  },
  {
    label: '菜单一',
    key: 'menu1',
    children: [
      {
        label: '子菜单1',
        key: 'subMenu1'
      },
      {
        label: '子菜单2',
        key: 'subMenu2'
      }
    ]
  },
]

const selectedKeys = ref<string>(route.path as string);
const handleUpdateValue = (key: any, item: any) => {
  router.push({ path: key });
}
import autoAnimate from "@formkit/auto-animate"
const logoRef = ref()
onMounted(() => {
  autoAnimate(logoRef.value,{duration: 100})
})
const darkMod = computed(() => appStore.darkMod);
const menuInstRef = ref<MenuInst | null>(null)
watch(
    () => route.fullPath,
    () => {
      selectedKeys.value =route.path as string;
      menuInstRef.value?.showOption(route.path as string)
    }
);
</script>

<template>
  <n-el tag="div" :style="{'background-color':darkMod?'':'rgb(0,20,40)'}" class="sidebar" :class="{'sidebar-collapse': collapse}">

    <div ref="logoRef" class="logo" >
      <div v-if="collapse" style="display: flex;height: 100%">
        <img src="@/assets/vue.svg" alt="" style="width: 36px">
      </div>
      <div v-else style="display: flex;height: 100%">
        <img src="@/assets/vue.svg" alt="" style="width: 36px">
        <n-el tag="div" style="display: flex;font-size: 30px;align-items: center;justify-content: center;color: var(--primary-color);transition: .3s var(--cubic-bezier-ease-in-out); ">OASIS</n-el>
      </div>
    </div>
    <div class="scrollbar">
      <n-scrollbar>
        <n-menu
            ref="menuInstRef"
            accordion
            :collapsed="collapse"
            :collapsed-width="54"
            :collapsed-icon-size="20"
            :indent="24"
            :inverted="true"
            :value='selectedKeys'
            @update:value="handleUpdateValue"
            :options="menus"
        />
      </n-scrollbar>
    </div>
  </n-el>
</template>

<style lang="scss" scoped>
.sidebar{
  width: var(--sidebar-width);
  position: fixed;
  top: 0;
  bottom: 0;
  box-sizing: border-box;
  background-color: var(--card-color);
  transition: .3s var(--cubic-bezier-ease-in-out);
  border-right: 1px solid var(--divider-color);
  .logo{
    height: 64px;
    display: flex;
    align-items: center;
    justify-content: center;
  }
}

.sidebar-collapse{
  width: var(--sidebar-collapse-width);
}
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

.fade-enter-to,
.fade-leave-from {
  opacity: 1;
}

.fade-enter-active{
  transition: opacity 1s ease;
}
</style>