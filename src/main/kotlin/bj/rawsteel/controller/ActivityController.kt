package bj.rawsteel.controller

import bj.rawsteel.domain.Activity
import bj.rawsteel.domain.ApiPage
import bj.rawsteel.domain.ApiSuccess
import bj.rawsteel.service.ActivityService
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午2:21
 */
@RestController
@RequestMapping("/api/activities")
class ActivityController {

    @Resource
    private lateinit var activityService: ActivityService

    @GetMapping
    fun index(
            @RequestParam("page", required = false, defaultValue = "0") page: Int,
            @RequestParam("size", required = false, defaultValue = "10") size: Int
    ): ApiSuccess<ApiPage<Activity>> {
        val activityPage = activityService.findAll(PageRequest.of(page, size))
        return ApiSuccess.of(ApiPage.of(activityPage))
    }
}