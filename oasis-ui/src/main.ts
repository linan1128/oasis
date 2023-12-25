import { createApp } from 'vue'
import './style.scss'
import App from './App.vue'
import router from "@/router";
import { createPinia } from 'pinia'


const app = createApp(App)
app.use(createPinia())
app.use(router)
app.mount('#app')