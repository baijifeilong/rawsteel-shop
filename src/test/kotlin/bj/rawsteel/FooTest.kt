package bj.rawsteel

import bj.rawsteel.domain.ApiSuccess
import bj.rawsteel.exception.BizException
import org.junit.Test

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 上午11:56
 */
class FooTest {

    @Test
    fun testAlpha() {
        println(User(1))
    }
}

data class User(var id: Int) {
    var username = ""
}