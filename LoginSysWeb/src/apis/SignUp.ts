import httpRequest from '@/request/index'

export function apiSignUp(userName: String, userEmail: String, userPw: String) {
    return httpRequest({
        url: '/signUp',
        method: 'post',
        data: { "id": null, "name": userName, "email": userEmail, "pw": userPw }
    })
}
