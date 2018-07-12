package bj.rawsteel.controller

import bj.rawsteel.domain.ApiSuccess
import bj.rawsteel.domain.User
import bj.rawsteel.dto.UserInfoDTO
import bj.rawsteel.dto.UserInfoWithTokenDTO
import bj.rawsteel.service.UserService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource
import javax.validation.Valid
import javax.validation.constraints.NotBlank

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/9 下午1:35
 */
@RestController
@RequestMapping("/api/users")
class UserController : BaseController() {

    @Resource
    private lateinit var userService: UserService

    class RegisterForm {
        @NotBlank
        var username: String? = null
        @NotBlank
        var password: String? = null
    }

    @PostMapping("register")
    fun register(@RequestBody @Valid form: RegisterForm): ApiSuccess<UserInfoWithTokenDTO> {
        val user = userService.registerAndLogin(form.username!!, form.password!!)
        return ApiSuccess.of(userService.constructUserInfoWithToken(user))
    }

    class LoginForm {
        @NotBlank
        var username: String? = null
        @NotBlank
        var password: String? = null
    }

    @PostMapping("login")
    fun login(@RequestBody @Valid form: LoginForm): ApiSuccess<UserInfoWithTokenDTO> {
        val user = userService.login(form.username!!, form.password!!)
        return ApiSuccess.of(userService.constructUserInfoWithToken(user))
    }

    @GetMapping("current")
    fun current(@AuthenticationPrincipal user: User): ApiSuccess<UserInfoDTO> {
        return ApiSuccess.of(userService.constructUserInfo(user))
    }

    @GetMapping("logout")
    fun logout() {
    }

    @PostMapping("updateInformation")
    fun updateInformation(
            @AuthenticationPrincipal user: User,
            @RequestParam("avatarUrl", required = false) avatarUrl: String?
    ): ApiSuccess<UserInfoDTO> {
        val newUser = userService.update(user.id!!, avatar = avatarUrl)
        return ApiSuccess.of(userService.constructUserInfo(newUser))
    }
}