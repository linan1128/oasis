import { createWebHistory, RouteRecordRaw, createRouter } from 'vue-router'

import Layout from '@/layout/index.vue'

const routes: RouteRecordRaw[] = [
    {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login.vue')
    },
    {
        path: '',
        component: Layout,
        redirect: 'index',
        children:[
            {
                path: 'index',
                name: 'Index',
                component: () => import('@/views/index.vue'),
                meta: {
                    title: 'dashboard'
                }
            }
        ]
    },
    {
        path: '/system',
        component: Layout,
        children:[
            {
                path: 'user',
                name: 'User',
                component: () => import('@/views/system/user/index.vue'),
                meta: {
                    title: '用户管理'
                }
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router;