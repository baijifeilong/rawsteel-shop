package bj.rawsteel.domain

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/6 下午4:26
 */
class ApiFailure private constructor(code: Int, message: String) {
    var error: Error

    init {
        this.error = ApiFailure.Error(code, message)
    }

    companion object {
        fun of(code: Int, message: String): ApiFailure {
            return ApiFailure(code, message)
        }
    }

    data class Error(val code: Int, val message: String)
}