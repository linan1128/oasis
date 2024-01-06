import Axios from '@/utils/request.ts'

export const getDeptList = (data) =>{
    return Axios({
        url: '/dept/list',
        method: 'get',
        params:data
    })
}

export const addDept = (data) =>{
    return Axios({
        url: '/dept/add',
        method: 'post',
        data:data
    })
}