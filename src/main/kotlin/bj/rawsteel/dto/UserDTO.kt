package bj.rawsteel.dto

import bj.rawsteel.domain.User

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/12 上午9:38
 */

open class UserInfoDTO(user: User) {
    var id: Long? = null
    var username: String? = null

    init {
        this.id = user.id
        this.username = user.username
    }
}

open class UserInfoWithTokenDTO(user: User) : UserInfoDTO(user) {
    var token: String? = null

    init {
        this.token = user.token
    }
}

