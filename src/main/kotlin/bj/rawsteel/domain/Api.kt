package bj.rawsteel.domain

import org.springframework.data.domain.Page

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

data class ApiPage<T>(
        var pageIndex: Int,
        var itemsPerPage: Int,
        var totalItems: Long,
        var totalPages: Int,
        var currentItemCount: Int,
        var items: List<T>

) {
    companion object {
        fun <T> of(page: Page<T>): ApiPage<T> {
            return ApiPage(
                    pageIndex = page.number + 1,
                    itemsPerPage = page.size,
                    totalItems = page.totalElements,
                    totalPages = page.totalPages,
                    currentItemCount = page.content.size,
                    items = page.content
            )
        }
    }
}