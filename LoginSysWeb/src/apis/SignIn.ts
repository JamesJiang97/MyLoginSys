import service from '@/request/index'

export function apiSignIn(userEmail: String, userPw: String) {
    return service({
        url: '/signIn',
        method: 'post',
        data: { "id": null, "name": null, "email": userEmail, "pw": userPw }
    })
}
