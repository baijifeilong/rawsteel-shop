package bj.rawsteel.repository

import bj.rawsteel.AppTest
import bj.rawsteel.domain.QUser
import bj.rawsteel.domain.User
import org.junit.Test
import org.springframework.data.domain.Example
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午5:08
 */
class UserRepositoryTest : AppTest() {

    @Resource
    private lateinit var userRepository: UserRepository

    @Test
    fun testFindAll() {
        logger.info("Testing findAll()")
        userRepository.findAll().forEach(::println)

        logger.info("Testing findAll(Example.of(User(1)))")
        userRepository.findAll(Example.of(User().apply { id = 1 })).forEach(::println)

        logger.info("Testing HQL")
        println(userRepository.myFindById(1))

        logger.info("Test QueryDSL")
        userRepository.findAll(QUser.user.isNotNull.and(QUser.user.id.gt(1))).forEach(::println)
    }
}