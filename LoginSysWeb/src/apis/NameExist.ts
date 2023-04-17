import service from '@/request/index'

export function apiNameExist(userName: String) {
    return service({
        url: '/nameExist',
        method: 'post',
        data: { "id": null, "name": userName, "email": null, "pw": null }
    })
}



