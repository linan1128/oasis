import Axios from '@/utils/request.ts'

export const getMenuList = (data) =>{
    return Axios({
        url: '/menu/list',
        method: 'get',
        params:data
    })
}

export const addMenu = (data) =>{
    return Axios({
        url: '/menu/add',
        method: 'post',
        data:data
    })
}

// export const getRouters = () => {
//     return Axios({
//         url: '/menu/getRouters',
//         method: 'get'
//     })
// }