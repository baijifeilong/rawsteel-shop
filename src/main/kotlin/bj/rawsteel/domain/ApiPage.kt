package bj.rawsteel.domain

import org.springframework.data.domain.Page

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/6 下午4:27
 */
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