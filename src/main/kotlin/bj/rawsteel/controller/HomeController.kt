package bj.rawsteel.controller

import bj.rawsteel.domain.ApiSuccess
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 下午6:31
 */
@RestController
@RequestMapping("/api")
@EnableSwagger2
class HomeController : BaseController() {

    @Resource
    private lateinit var loremController: LoremController

    @GetMapping("home")
    fun index(): ApiSuccess<Any> {
        return ApiSuccess.of(listOf(
                HomeEntry(HomeEntryType.BANNERS, arrayOf("nike", "adidas", "anta", "361").map {
                    mapOf("imageUrl" to "${siteIndexUrl()}/lorem/image/1680/1050/$it", "linkUrl" to "http://www.baidu.com")
                }),
                HomeEntry(HomeEntryType.HTML, loremController.html(-1, 400, "Lorem")),
                HomeEntry(HomeEntryType.GOODS, mapOf(
                        "title" to "Foods",
                        "goodsItems" to arrayOf("apple", "banana", "orange", "grape", "pineapple", "watermelon").map {
                            mapOf("title" to it.capitalize(), "imageUrl" to "${siteIndexUrl()}/lorem/image/500/500/$it")
                        },
                        "moreGoodsUrl" to "http://www.baidu.com"
                )),
                HomeEntry(HomeEntryType.HTML, loremController.html(-1, 400, "Ipsum")),
                HomeEntry(HomeEntryType.GOODS, mapOf(
                        "title" to "Animals",
                        "goodsItems" to arrayOf("ant", "bee", "cat", "dog", "fox", "goat").map {
                            mapOf("title" to it.capitalize(), "imageUrl" to "${siteIndexUrl()}/lorem/image/500/500/$it")
                        },
                        "moreGoodsUrl" to "http://www.baidu.com"
                )),
                HomeEntry(HomeEntryType.HTML, loremController.html(-1, 400, "Dolor")),
                HomeEntry(HomeEntryType.HTML, loremController.html(-1, 400, "Sit")),
                HomeEntry(HomeEntryType.HTML, loremController.html(-1, 400, "Amet"))
        ))
    }

    data class HomeEntry(
            var type: HomeEntryType?,
            var content: Any?
    )

    enum class HomeEntryType {
        BANNERS,
        HTML,
        GOODS
    }
}
