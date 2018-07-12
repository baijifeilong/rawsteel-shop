package bj.rawsteel.controller

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import j2html.TagCreator
import j2html.TagCreator.*
import org.springframework.http.MediaType
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.nio.charset.Charset
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

    @GetMapping("image/{width}/{height}/{keyword}", produces = [MediaType.IMAGE_JPEG_VALUE])
    fun image(
            @PathVariable("width") width: Int,
            @PathVariable("height") height: Int,
            @PathVariable("keyword") keyword: String
    ): ByteArray {
        val restTemplate = RestTemplate().apply {
            messageConverters.filter { it is StringHttpMessageConverter }.map { it as StringHttpMessageConverter }.forEach { it.defaultCharset = Charset.forName("UTF-8") }
        }
        val objectMapper = ObjectMapper().apply {
            configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true)
        }
        val url = "https://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=&fp=result&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=-1&z=&ic=0&word=%s&s=&se=&tab=&width=%s&height=%s&face=0&istype=2&qc=&nc=1&fr=&pn=0&rn=999&gsm=1e&1531367226415="
                .format(keyword, width, height)
        val jsonText = restTemplate.getForObject(url, String::class.java)
        val imageUrl = objectMapper.readTree(jsonText)["data"].filter { it.size() > 0 }.map { it["middleURL"] }.shuffled().take(1)[0].asText()
        return restTemplate.getForObject(imageUrl, ByteArray::class.java)!!
    }
}