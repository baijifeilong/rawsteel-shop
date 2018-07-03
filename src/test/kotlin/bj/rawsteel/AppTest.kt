package bj.rawsteel

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午2:52
 */
@RunWith(SpringRunner::class)
@SpringBootTest(classes = [App::class])
open class AppTest {

    @Test
    fun main() {
        assert("true".toBoolean())
    }
}