import service from '@/request/index'

export function apiVerifyToken() {
    return service({
        url: '/verifyToken',
        method: 'post',
    })
}
