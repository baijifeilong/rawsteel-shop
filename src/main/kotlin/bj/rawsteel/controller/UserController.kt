package bj.rawsteel.controller

import bj.rawsteel.domain.ApiSuccess
import bj.rawsteel.domain.User
import bj.rawsteel.exception.RegisterException
import bj.rawsteel.service.UserService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.annotation.Resource
import javax.security.auth.login.LoginException

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 下午1:35
 */
@RestController
@RequestMapping("/api/users")
class UserController : BaseController() {

    private val tokenToUser = HashMap<String, User>()

    @Resource
    private lateinit var userService: UserService

    @PostMapping("register")
    fun register(
            @RequestParam("username") username: String,
            @RequestParam("password") password: String
    ): ApiSuccess<User> {
        val user = userService.registerAndLogin(username, password)
        return ApiSuccess.of(user)
    }

    @PostMapping("login")
    fun login(
            @RequestParam("username") username: String,
            @RequestParam("password") password: String
    ): ApiSuccess<User> {
        val user = userService.login(username, password)
        return ApiSuccess.of(user)
    }

    @GetMapping("current")
    fun current(@AuthenticationPrincipal user: User): ApiSuccess<User> {
        return ApiSuccess.of(user)
    }

    @GetMapping("logout")
    fun logout() {

    }
}