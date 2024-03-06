import { defineStore } from 'pinia'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { login, logout, getInfo } from '@/api/login'

interface UserInfo {
    username: string,
    password: string
}

export const useUserStore = defineStore({
    id: 'user',
    state: () => ({
        token: getToken(),
        name: '',
    }),
    actions: {
        login(userInfo:UserInfo) {
            const username = userInfo.username.trim()
            const password = userInfo.password
            return new Promise<void>((resolve, reject) => {
                login(username, password).then((res) => {
                    console.log(res)
                    setToken(res.data.token)
                    this.token = res.data.token
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },
        logout() {

        },
        getUserInfo() {
            
        }
    }
})