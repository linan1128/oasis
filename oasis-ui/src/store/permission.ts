import { defineStore } from 'pinia'
import { getMenuList } from '@/api/system/menu.ts'
import Layout from "@/layout/index.vue";
interface MenuOption {
    label:any,
    key:any,
    children?:MenuOption[]
}
const modules:Record<string, () => Promise<Record<string, any>>> = import.meta.glob('../views/**/*.{vue,tsx}')

export const usePermissionStore = defineStore({
    id: 'permission',
    state: () => ({
        sidebarMenus: [] as Array<MenuOption>,
        routers: [] as Array<any>
    }),
    actions: {
        async initMenus(){
                const res = await getMenuList(null)
                res.data.map((item:any)=>{
                    if (item.parentId == 0){
                        item.path = '/' + item.path
                    }
                })
                this.sidebarMenus = [{label:'首页',key:'/index'}].concat(generateMenus(res.data))
                console.log(this.sidebarMenus)
                console.log(this.routers)
                return generateRouters(res.data)
        }
    }
})

const generateMenus = (routerMap: Array<any>,route:any = false) => {
    return routerMap.map((item)=>{
        const currentMenu:MenuOption = {
            label: item.menuName,
            key: route ?route+'/'+item.path:item.path,
        };
        if (item.children && item.children.length > 0) {
            currentMenu.children = generateMenus(item.children,currentMenu.key);
        }
        return currentMenu;
    })
}
const generateRouters = (routerMap: Array<any>) => {
    return routerMap.map((item)=>{
        const currentRouter:any = {}
        currentRouter.path = item.path
        currentRouter.meta = {
            title:item.menuName
        }
        currentRouter.component = item.parentId === 0?Layout:loadComponent(modules,item.component)
        if (item.children && item.children.length > 0) {
            currentRouter.children = generateRouters(item.children);
        }
        return currentRouter;
    })
}

const loadComponent = (viewsModules: Record<string, () => Promise<Record<string, any>>>, component: string) => {
    const keys = Object.keys(viewsModules).filter((key) => {
        let k = key.replace('../views/', '');
        const lastIndex = k.lastIndexOf('.');
        k = k.substring(0, lastIndex);
        return k === component;
    });
    if (keys?.length === 1) {
        const key = keys[0];
        return viewsModules[key];
    }
    if (keys?.length > 1) {
        console.warn(
            '.vue and .TSX files has same name'
        );
        return;
    }
};