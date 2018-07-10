package bj.rawsteel.controller

import bj.rawsteel.domain.ApiSuccess
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 下午6:31
 */
@RestController
@RequestMapping("/api")
@EnableSwagger2
class HomeController : BaseController() {

    @GetMapping("home")
    fun index(): ApiSuccess<Any> {
        return ApiSuccess.of(listOf(
                HomeEntry(HomeEntryType.BANNERS, listOf(
                        mapOf("imageUrl" to "http://lorempixel.com/800/400/people/", "linkUrl" to "http://www.baidu.com"),
                        mapOf("imageUrl" to "http://lorempixel.com/800/400/people/", "linkUrl" to "http://www.baidu.com"),
                        mapOf("imageUrl" to "http://lorempixel.com/800/400/people/", "linkUrl" to "http://www.baidu.com"),
                        mapOf("imageUrl" to "http://lorempixel.com/800/400/people/", "linkUrl" to "http://www.baidu.com")
                )),
                HomeEntry(HomeEntryType.HTML, mapOf("contentUrl" to "${siteIndexUrl()}/lorem/html/-1/400/Lorem")),
                HomeEntry(HomeEntryType.HTML, mapOf("contentUrl" to "${siteIndexUrl()}/lorem/html/-1/400/Ipsum")),
                HomeEntry(HomeEntryType.GOODS, mapOf(
                        "title" to "Foods",
                        "goodsItems" to listOf(
                                mapOf("title" to "Apple", "imageUrl" to "http://lorempixel.com/500/500/food/"),
                                mapOf("title" to "Banana", "imageUrl" to "http://lorempixel.com/500/500/food/"),
                                mapOf("title" to "Orange", "imageUrl" to "http://lorempixel.com/500/500/food/"),
                                mapOf("title" to "Grape", "imageUrl" to "http://lorempixel.com/500/500/food/"),
                                mapOf("title" to "Pineapple", "imageUrl" to "http://lorempixel.com/500/500/food/"),
                                mapOf("title" to "Watermelon", "imageUrl" to "http://lorempixel.com/500/500/food/")
                        ),
                        "moreGoodsUrl" to "http://www.baidu.com"
                )),
                HomeEntry(HomeEntryType.GOODS, mapOf(
                        "title" to "Animals",
                        "goodsItems" to listOf(
                                mapOf("title" to "Ant", "imageUrl" to "http://lorempixel.com/500/500/animals/"),
                                mapOf("title" to "Bee", "imageUrl" to "http://lorempixel.com/500/500/animals/"),
                                mapOf("title" to "Cat", "imageUrl" to "http://lorempixel.com/500/500/animals/"),
                                mapOf("title" to "Dog", "imageUrl" to "http://lorempixel.com/500/500/animals/"),
                                mapOf("title" to "Fox", "imageUrl" to "http://lorempixel.com/500/500/animals/"),
                                mapOf("title" to "Goat", "imageUrl" to "http://lorempixel.com/500/500/animals/")
                        ),
                        "moreGoodsUrl" to "http://www.baidu.com"
                )),
                HomeEntry(HomeEntryType.HTML, mapOf("htmlCodeUrl" to "${siteIndexUrl()}/lorem/html/-1/400/Dolor")),
                HomeEntry(HomeEntryType.HTML, mapOf("htmlCodeUrl" to "${siteIndexUrl()}/lorem/html/-1/400/Sit")),
                HomeEntry(HomeEntryType.HTML, mapOf("htmlCodeUrl" to "${siteIndexUrl()}/lorem/html/-1/400/Amet"))
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
