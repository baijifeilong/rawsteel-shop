package bj.rawsteel.repository

import bj.rawsteel.AppTest
import org.junit.Test
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午5:08
 */
class UserRepositoryTest : AppTest() {

    @Resource
    private lateinit var userRepository: UserRepository

    @Test
    fun nothing() {
        userRepository.findAll().forEach(::println)
    }
}