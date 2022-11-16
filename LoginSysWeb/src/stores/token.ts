import { defineStore } from 'pinia'

export const useTokenStore = defineStore('storeId', {

  state: () => {
    return {
        userId: localStorage.getItem('userId') ? localStorage.getItem('userId') : 0,
        userName: localStorage.getItem('userName') ? localStorage.getItem('userName') : null,
        token: localStorage.getItem('token') ? localStorage.getItem('token') : null,
    }
  },
  actions: {
    setUserName(userName: string){
        this.userName = userName
        localStorage.setItem('userName', userName)
    },
    setUserId(userId: number){
        this.userId = userId
        localStorage.setItem('userId', JSON.stringify(userId))
    },
    setToken(token: string){
        this.token = token
        localStorage.setItem('token', token)
    },
    logout() {
        localStorage.removeItem('token')
        this.token = null
        localStorage.removeItem('userName')
        this.userName = null
        localStorage.removeItem('userId')
        this.userId = null
    },
  },
})