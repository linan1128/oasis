import axios from 'axios'
import { getToken } from '@/utils/auth'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

const instance = axios.create({
    baseURL: import.meta.env.VITE_APP_BASE_API,
    timeout: 10000
});

instance.interceptors.request.use(function (config) {
    if(getToken()){
        config.headers['Authorization'] = 'Bearer ' + getToken()
    }



    // 在发送请求之前做些什么
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

// 添加响应拦截器
instance.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    return response.data;
}, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
});

export default instance