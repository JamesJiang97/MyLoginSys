import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
import axios from  '@/request/index'
import { createPinia } from "pinia";

const pinia = createPinia();

let app=createApp(App)
app.use(router)
app.use(pinia)
app.mount('#app')
app.config.globalProperties.$axios=axios;