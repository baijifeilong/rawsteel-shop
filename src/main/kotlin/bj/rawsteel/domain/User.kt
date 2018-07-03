package bj.rawsteel.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午3:43
 */
@Entity
data class User(@Id var id: Long?, @Column var username: String?) {
    constructor() : this(null, null)
}