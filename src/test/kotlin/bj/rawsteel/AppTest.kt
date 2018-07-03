package bj.rawsteel

import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午2:52
 */
@RunWith(SpringRunner::class)
@SpringBootTest(classes = [App::class])
open class AppTest {

    protected val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Test
    fun nothing() {
        logger.info("nothing")
        assert("true".toBoolean())
    }
}