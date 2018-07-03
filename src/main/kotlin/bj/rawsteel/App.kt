package bj.rawsteel

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/3 下午2:40
 */
@SpringBootApplication
@RestController
open class App : ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun onApplicationEvent(event: ApplicationReadyEvent?) {
        println("here")
        jdbcTemplate.queryForList("SELECT * FROM user")
                .forEach(::println)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }
    }

    @RequestMapping("/")
    fun index(): Any {
        return "Hello world!";
    }
}