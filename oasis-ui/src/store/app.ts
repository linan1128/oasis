import { defineStore } from 'pinia'

export const useAppStore = defineStore({
    id: 'app',
    state: () => ({
        sidebarCollapse: false
    }),
    actions: {
        switchSidebarCollapse(){
            this.sidebarCollapse = !this.sidebarCollapse
        }
    }
})