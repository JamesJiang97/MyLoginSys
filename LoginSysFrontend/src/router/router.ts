import { createRouter,createWebHistory } from 'vue-router';

import LoginForm from '../components/LoginForm.vue'
import MyPage from '../components/MyPage.vue'

const routes = [
    {
        path: '/', 
        name: 'Login',
        component: LoginForm
    },

    {
        path: '/MyPage',
        name: 'MyPage',
        component: MyPage
    },
]

const router = createRouter({
    history: createWebHistory(), // HTML5 History モード
    routes,
})

export default router


