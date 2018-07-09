package bj.rawsteel.controller

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
    fun index(): Any {
        return listOf(
                HomeEntry(HomeEntryType.BANNERS, "hello"),
                HomeEntry(HomeEntryType.HTML, "hello"),
                HomeEntry(HomeEntryType.GOODS, "hello")
        )
    }

    data class HomeEntry(
            var type: HomeEntryType?,
            var data: Any?
    )

    enum class HomeEntryType {
        BANNERS,
        HTML,
        GOODS
    }
}
