import { createRouter, createWebHistory } from 'vue-router';

import LoginForm from '../components/LoginForm.vue'
import MyPage from '../components/MyPage.vue'
import { apiVerifyToken } from '@/apis/VerifyToken'

const routes = [
    {
        path: '/',
        name: 'Login',
        component: LoginForm
    },

    {
        path: '/mypage',
        name: 'MyPage',
        component: MyPage
    },
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,
})


router.beforeEach((to, from, next) => {
    if (to.path == '/') {
        localStorage.removeItem('token')
        localStorage.removeItem('userName')
        localStorage.removeItem('userId')
        next()
    } else {
        let userToken = localStorage.getItem('token')
        // console.log(userToken)
        if (userToken == null || userToken == '') {
            alert("Please sign in");
            return next('/');
        } else {
            apiVerifyToken().then((response)=>{
                if(response.data.code == 200){
                    next()
                }else{
                    localStorage.removeItem('token')
                    localStorage.removeItem('userName')
                    localStorage.removeItem('userId')
                    alert("Please sign in");
                    return next('/');
                }
            })
        }
    }
})

export default router


