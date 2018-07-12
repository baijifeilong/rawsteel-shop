package bj.rawsteel

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.core.env.Environment
import java.net.InetAddress
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 下午2:33
 */
abstract class BaseContext {
    @Resource
    private lateinit var messageSource: MessageSource

    @Resource
    private lateinit var environment: Environment

    protected val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun getMessage(code: String, vararg args: Any?): String {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale())
    }

    private fun serverHost(): String = InetAddress.getLocalHost().hostName

    private fun serverPort(): Int = environment.getProperty("local.server.port")?.toInt() ?: 8080

    fun siteIndexUrl(): String = "http://${serverHost()}:${serverPort()}"
}