package bj.rawsteel.seeder

import bj.rawsteel.BaseContext
import bj.rawsteel.service.UserService
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/12 上午10:41
 */
@Component
class UserSeeder : BaseContext() {

    @Resource
    private lateinit var userService: UserService

    fun clear() {
        logger.info("Clear users ...")
        userService.destroyAll()
    }

    fun seed() {
        logger.info("Seed users ...")
        for (username in arrayOf("apple", "banana", "cherry")) {
            val user = userService.create(username, username)
            userService.update(
                    user.id!!,
                    nickname = username.toUpperCase(),
                    age = 18,
                    avatar = this.siteIndexUrl() + "/lorem/image/256/256/$username"
            )
        }
    }

    fun clearAndSeed() {
        clear()
        seed()
        logger.info("Users:")
        userService.findAll().forEach(::println)
    }
}