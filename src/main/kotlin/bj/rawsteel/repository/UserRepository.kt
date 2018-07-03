package bj.rawsteel.repository

import bj.rawsteel.domain.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午5:06
 */
interface UserRepository : JpaRepository<User, Long> {
}