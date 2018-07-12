package bj.rawsteel.seeder

import bj.rawsteel.service.TemplateService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/12 上午10:23
 */
@Component
class TemplateSeeder {

    @Resource
    private lateinit var templateService: TemplateService

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun clear() {
        logger.info("Clear templates ...")
        templateService.destroyAll()
    }

    fun seed() {
        logger.info("Seed templates ...")
        (1..11).forEach {
            templateService.create()
        }
    }

    fun clearAndSeed() {
        clear()
        seed()
        logger.info("Templates:")
        templateService.findAll().forEach(::println)
    }
}