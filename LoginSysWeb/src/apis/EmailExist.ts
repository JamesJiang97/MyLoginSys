import httpRequest from '@/request/index'

export function apiEmailExist(userEmail: String) {
    return httpRequest({
        url: '/emailExist',
        method: 'post',
        data: { "id": null, "name": null, "email": userEmail, "pw": null }
    })
}
