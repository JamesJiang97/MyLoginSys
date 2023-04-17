import service from '@/request/index'

export function apiEmailExist(userEmail: String) {
    return service({
        url: '/emailExist',
        method: 'post',
        data: { "id": null, "name": null, "email": userEmail, "pw": null }
    })
}
