import { defineStore } from 'pinia'
import { RouteLocationNormalized } from 'vue-router';


export type RouteItem = Partial<RouteLocationNormalized> & {
    fullPath: string;
    name: string;
};

export type ITabsViewState = {
    tabsList: RouteItem[];
};

export const useTagsViewStore = defineStore({
    id: 'tagsView',
    state: () :ITabsViewState => ({
        tabsList: [
            {
                fullPath: "/index",
                hash: "",
                meta: {
                    icon:"dashboard",
                    title:"首页"
                },
                name: "Index",
                path:"/index"
            }
        ]
    }),
    actions: {
        initTabs(routes:RouteItem[]) {
            this.tabsList = routes;
        },
        addTabs(route: RouteItem): boolean {
            // 添加标签页
            const isExists = this.tabsList.some((item) => item.path == route.path);
            if (!isExists) {
                this.tabsList.push(route);
            } else {
                const index = this.tabsList.findIndex((item) => item.path == route.path);
                this.tabsList[index] = route
            }
            return true;
        },
        closeCurrentTab(route: RouteItem) {
            // 关闭当前页
            const index = this.tabsList.findIndex((item) => item.fullPath == route.fullPath);
            this.tabsList.splice(index, 1);
        },
    }
})