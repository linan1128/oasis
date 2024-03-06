import router from '@/router/index.ts'
import {getToken} from "@/utils/auth.ts";
import {usePermissionStore} from '@/store/permission.ts'
const whiteList = ['/login'];
router.beforeEach(async (to, from) => {
    const Loading = window['$loading'] || null;
    Loading && Loading.start();
    if(getToken()){
        if (to.path === '/login') {
            return { path: '/' }
        } else if (whiteList.indexOf(to.path) !== -1) {
            return
        } else {
            if (usePermissionStore().sidebarMenus.length ===0){
                const routers = await usePermissionStore().initMenus()
                for (const route of routers) {
                    router.addRoute(route)
                }
                console.log(router.getRoutes())

                return to.fullPath
            }
            // return to.fullPath
        }
    } else {
        if (whiteList.indexOf(to.path) !== -1) {
            return
        } else if (to.path !== '/login'){
            return { path: '/login' }
        }
    }


    // ...
    // 返回 false 以取消导航
    // return false
})

router.afterEach((to, from) => {
    const Loading = window['$loading'] || null;
    Loading && Loading.finish();
})