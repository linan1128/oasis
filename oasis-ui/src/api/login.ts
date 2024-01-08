import Axios from '@/utils/request.ts'

export const login = (username:string, password:string) =>{
    return Axios({
        url: '/login',
        method: 'post',
        data: {
            username,
            password
        }
    })
}
export const logout = () =>{
    return Axios({
        url: '/logout',
        method: 'post',
    })
}
export const getInfo = () =>{
    return Axios({
        url: '/getInfo',
        method: 'post',
    })
}