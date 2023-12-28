import Axios from '@/utils/request.ts'

export const login = (username:string, password:string) =>{
    return Axios({
        url: '/auth/login',
        method: 'post',
        data: {
            username,
            password
        }
    })
}
export const logout = () =>{
    return Axios({
        url: '/auth/logout',
        method: 'post',
    })
}
export const getInfo = () =>{
    return Axios({
        url: '/auth/getInfo',
        method: 'post',
    })
}