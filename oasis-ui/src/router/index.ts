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
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router;