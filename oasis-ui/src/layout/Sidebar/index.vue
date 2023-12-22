<script setup lang="ts">
import { useAppStore } from '@/store/app.ts'
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

const handleUpdateValue = () => {

}
</script>

<template>
  <div class="sidebar" :class="{'sidebar-collapse': collapse}">

    <div class="logo" >
      <img src="@/assets/vue.svg" alt="">
      <transition name="fade">
        <h1 v-show="!collapse">OASIS</h1>
      </transition>

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
            :inverted="false"
            :value='selectedKeys'
            @update:value="handleUpdateValue"
            :options="menus"
        />
      </n-scrollbar>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.sidebar{
  width: var(--sidebar-width);
  position: fixed;
  top: 0;
  bottom: 0;
  box-shadow: 2px 0 8px 0 #f5f5f5;
  transition: width .3s cubic-bezier(.4, 0, .2, 1);
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