package bj.rawsteel.controller

import bj.rawsteel.domain.ApiPage
import bj.rawsteel.domain.ApiSuccess
import bj.rawsteel.domain.Product
import bj.rawsteel.service.ProductService
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午2:22
 */
@RestController
@RequestMapping("/api/products")
class ProductController : BaseController() {

    @Resource
    private lateinit var productService: ProductService

    @GetMapping
    fun index(
            @RequestParam("page", required = false, defaultValue = "0") page: Int,
            @RequestParam("size", required = false, defaultValue = "10") size: Int
    ): ApiSuccess<ApiPage<Product>> {
        val products = productService.findAll(PageRequest.of(page, size))
        return ApiSuccess.of(ApiPage.of(products))
    }
}