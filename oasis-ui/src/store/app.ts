import { defineStore } from 'pinia'

export const useAppStore = defineStore({
    id: 'app',
    state: () => ({
        sidebarCollapse: false,
        darkMod:false
    }),
    actions: {
        switchSidebarCollapse(){
            this.sidebarCollapse = !this.sidebarCollapse
        },
        switchDarkMod(){
            this.darkMod = !this.darkMod
        }
    }
})