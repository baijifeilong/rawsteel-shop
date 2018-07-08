package bj.rawsteel.controller

import bj.rawsteel.domain.ApiFailure
import bj.rawsteel.domain.ApiPage
import bj.rawsteel.domain.ApiSuccess
import bj.rawsteel.domain.Template
import bj.rawsteel.service.TemplateService
import org.apache.catalina.servlet4preview.http.HttpServletRequest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 18-7-8 下午5:07
 */
@RestController
@RequestMapping("/api/admin/templates")
class AdminTemplateController {

    @Resource
    private lateinit var templateService: TemplateService

    @GetMapping
    fun index(
            @RequestParam(required = false, defaultValue = "0") page: Int,
            @RequestParam(required = false, defaultValue = "10") size: Int
    ): ApiSuccess<ApiPage<Template>> {
        val templatePage = templateService.findAll(PageRequest.of(page, size))
        return ApiSuccess.of(ApiPage.of(templatePage))
    }

    @PostMapping
    fun create(): ApiSuccess<Template> {
        val template = templateService.create()
        return ApiSuccess.of(template)
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Long): ApiSuccess<Template> {
        val template = templateService.findByIdOrThrow(id)
        return ApiSuccess.of(template)
    }

    @PatchMapping("{id}")
    fun update(@PathVariable id: Long): ApiSuccess<Template> {
        val template = templateService.findByIdOrThrow(id)
        return ApiSuccess.of(template)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        templateService.destroy(id)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun dataIntegrityViolationException(e: Exception, request: HttpServletRequest
    ): Any {
        if (request.method.equals(HttpMethod.POST.toString())) {
            return ApiFailure.of(1, "Template exist: ${e.localizedMessage}")
        } else if (request.method.equals(HttpMethod.PATCH.toString())) {
            return ApiFailure.of(1, "Template violation: ${e.localizedMessage}")
        } else {
            return ApiFailure.of(1, "Unexpected code execution !!!")
        }
    }
}
