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