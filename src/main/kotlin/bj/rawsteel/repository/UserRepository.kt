package bj.rawsteel.repository

import bj.rawsteel.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午5:06
 */
interface UserRepository : JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.id = ?1")
    fun myFindById(id: Long): User
}
