import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
import axios from  '@/request/index'

let app=createApp(App)
app.use(router)
app.mount('#app')
app.config.globalProperties.$axios=axios;