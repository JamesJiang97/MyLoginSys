import service from '@/request/index'

export function apiSignUp(userName: String, userEmail: String, userPw: String) {
    return service({
        url: '/signUp',
        method: 'post',
        data: { "id": null, "name": userName, "email": userEmail, "pw": userPw }
    })
}
