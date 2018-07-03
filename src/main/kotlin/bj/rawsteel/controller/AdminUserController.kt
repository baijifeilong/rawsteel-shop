package bj.rawsteel.controller

import bj.rawsteel.domain.User
import bj.rawsteel.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午7:13
 */
@RestController("/api/admin/users")
class AdminUserController {

    @Resource
    private lateinit var userService: UserService

    @GetMapping
    fun index(
            @RequestParam(required = false) username: String?,
            @RequestParam(required = false, defaultValue = "0") page: Int,
            @RequestParam(required = false, defaultValue = "10") size: Int
    ): Page<User> {
        return userService.findAll(username, PageRequest.of(page, size))
    }
}