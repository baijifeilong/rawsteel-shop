package bj.rawsteel.seeder

import bj.rawsteel.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/12 上午10:41
 */
@Component
class UserSeeder {

    @Resource
    private lateinit var userService: UserService

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun clear() {
        logger.info("Clear users ...")
        userService.destroyAll()
    }

    fun seed() {
        logger.info("Seed users ...")
        for (username in arrayOf("foo", "bar", "baz")) {
            userService.create(username, username)
        }
    }

    fun clearAndSeed() {
        clear()
        seed()
        logger.info("Users:")
        userService.findAll().forEach(::println)
    }
}