package bj.rawsteel.repository

import bj.rawsteel.App
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午5:08
 */
@RunWith(SpringRunner::class)
@SpringBootTest(classes = [(App::class)])
class UserRepositoryTest {

    @Resource
    private lateinit var userRepository: UserRepository

    @Test
    fun nothing() {
        userRepository.findAll().forEach(::println)
    }
}