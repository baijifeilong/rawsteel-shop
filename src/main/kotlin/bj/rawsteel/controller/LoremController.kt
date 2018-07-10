package bj.rawsteel.controller

import j2html.TagCreator
import j2html.TagCreator.*
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/10 上午9:34
 */
@RestController
@RequestMapping("/lorem")
class LoremController : BaseController() {

    @GetMapping("html/{width}/{height}/{text}", produces = [MediaType.TEXT_HTML_VALUE])
    fun html(
            @PathVariable("width") width: Int,
            @PathVariable("height") height: Int,
            @PathVariable("text") text: String
    ): String {
        val widthValue = if (width == -1) "100%" else "${width}px"
        val heightValue = if (height == -1) "100%" else "${height}px"
        val background = Random().nextInt(0xFFFFFF + 1)
        val backgroundValue = "%06X".format(background)
        val color = 0xFFFFFF - background
        val colorValue = "%06X".format(color)
        val size = Optional.ofNullable(listOf(width, height).filter { it > 0 }.min()).orElse(300)
        return html(body(
                div(TagCreator.text(text)).withStyle(
                        "display: flex; align-items: center; justify-content: center; " +
                                "width: $widthValue; height: $heightValue; " +
                                "font-size: ${size / 3}px; background: #$backgroundValue; color: #$colorValue"
                )
        ).withStyle("margin: 0")).render()
    }
}