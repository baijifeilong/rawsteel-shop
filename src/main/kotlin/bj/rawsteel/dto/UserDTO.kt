package bj.rawsteel.dto

import bj.rawsteel.domain.User

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/12 上午9:38
 */

open class UserInfo(user: User) {
    var id: Long? = null
    var username: String? = null
    var nickname: String? = null
    var age: Int? = null
    var avatarUrl: String? = null

    init {
        this.id = user.id
        this.username = user.username
        this.nickname = user.nickname
        this.age = user.age
        this.avatarUrl = user.avatar
    }
}

open class UserInfoWithToken(user: User) : UserInfo(user) {
    var token: String? = null

    init {
        this.token = user.token
    }
}

