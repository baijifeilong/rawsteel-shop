package bj.rawsteel.controller

import bj.rawsteel.domain.ApiFailure
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/6 下午4:33
 */
@RestControllerAdvice
class ApiControllerAdvice {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun processException(exception: Exception) = ApiFailure.of(500, exception.localizedMessage)


    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun processNotFoundException(exception: Exception) = ApiFailure.of(404, exception.localizedMessage)
}