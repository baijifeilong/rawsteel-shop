package bj.rawsteel

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 下午2:33
 */
abstract class BaseContext {
    @Resource
    private lateinit var messageSource: MessageSource

    fun getMessage(code: String, vararg args: Any?): String {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale())
    }
}