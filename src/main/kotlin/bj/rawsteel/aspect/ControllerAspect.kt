package bj.rawsteel.aspect

import bj.rawsteel.BaseContext
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/12 下午3:45
 */
@Aspect
@Component
class ControllerAspect : BaseContext() {

    @Before("execution(* bj.rawsteel.controller.ApiControllerAdvice.*(..))")
    fun doBeforeException(joinPoint: JoinPoint) {
        val exception = joinPoint.args[0] as Exception
        logger.warn("Exception: {}", exception.localizedMessage)
    }

    @Before("execution(* bj.rawsteel.controller.*Controller.*(..))")
    fun doBeforeControllerMethod(joinPoint: JoinPoint) {
        logger.info("Executing: {}", joinPoint.signature)
    }
}