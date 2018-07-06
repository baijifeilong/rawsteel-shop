package bj.rawsteel.domain

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/6 下午4:25
 */
class ApiSuccess<T> private constructor(var data: T) {

    companion object {
        fun <T> of(t: T): ApiSuccess<T> {
            return ApiSuccess(t)
        }
    }
}