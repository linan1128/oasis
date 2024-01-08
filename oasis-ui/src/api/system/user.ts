import Axios from '@/utils/request.ts'

export const getDeptTree = () =>{
    return Axios({
        url: '/system/user/deptTree',
        method: 'get'
    })
}

export const getUserList = (data:any) =>{
    return Axios({
        url: '/system/user/list',
        method: 'get',
        params:data
    })
}