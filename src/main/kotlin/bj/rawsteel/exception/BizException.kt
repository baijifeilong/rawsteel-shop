package bj.rawsteel.exception

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 上午11:48
 */
open class BizException(var code: Int, message: String) : RuntimeException(message) {
    override fun toString(): String {
        return "BizException(code=$code, message=$message)"
    }
}

class UnknownException(message: String) : BizException(1000, message)
class AuthException(message: String) : BizException(1001, message)
class RegisterException(message: String) : BizException(1002, message)
