import httpRequest from '@/request/index'

export function apiSignIn(userEmail: String, userPw: String) {
    return httpRequest({
        url: '/emailExist',
        method: 'post',
        data: { "id": null, "name": null, "email": userEmail, "pw": userPw }
    })
}
