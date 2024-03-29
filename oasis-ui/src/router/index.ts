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
                    title: '首页'
                }
            }
        ]
    },
    {
        path: "/:pathMatch(.*)*",
        component: () => import('@/views/error/404/index.vue'),
    },
    // {
    //     path: '/system',
    //     component: Layout,
    //     children:[
    //         {
    //             path: 'user',
    //             name: 'User',
    //             component: () => import('@/views/system/user/index.vue'),
    //             meta: {
    //                 title: '用户管理'
    //             }
    //         },
    //         {
    //             path: 'dept',
    //             name: 'Dept',
    //             component: () => import('@/views/system/dept/index.vue'),
    //             meta: {
    //                 title: '部门管理'
    //             }
    //         },
    //         {
    //             path: 'menu',
    //             name: 'Menu',
    //             component: () => import('@/views/system/menu/index.vue'),
    //             meta: {
    //                 title: '菜单管理'
    //             }
    //         }
    //     ]
    // }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router;