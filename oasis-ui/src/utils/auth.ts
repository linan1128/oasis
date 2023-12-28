import Cookies from 'js-cookie'
const TokenKey = 'Oasis-Token'
export const getToken = () => {
    return Cookies.get(TokenKey)
}

export const setToken = (token:string) => {
    return Cookies.set(TokenKey, token)
}

export const removeToken = () => {
    return Cookies.remove(TokenKey)
}