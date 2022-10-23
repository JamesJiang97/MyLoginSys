import httpRequest from '@/request/index'

export function apiNameExist(userName: String) {
    return httpRequest({
        url:'/users',
        method:'post',
        data: userName,
    })
}

