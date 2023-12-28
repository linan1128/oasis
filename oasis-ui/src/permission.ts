import router from '@/router/index.ts'
import {getToken} from "@/utils/auth.ts";

const whiteList = ['/login'];
router.beforeEach((to, from) => {
    const Loading = window['$loading'] || null;
    Loading && Loading.start();
    if(getToken()){
        if (to.path === '/login') {
            return { path: '/' }
        } else if (whiteList.indexOf(to.path) !== -1) {
            return
        } else {
            return 
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