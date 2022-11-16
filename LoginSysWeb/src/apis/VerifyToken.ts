import httpRequest from '@/request/index'

export function apiVerifyToken() {
    return httpRequest({
        url: '/verifyToken',
        method: 'post',
    })
}
