import httpRequest from '@/request/index'

export function apiNameExist(userName: String) {
    return httpRequest({
        url: '/nameExist',
        method: 'post',
        data: { "id": null, "name": userName, "email": null, "pw": null }
    })
}



