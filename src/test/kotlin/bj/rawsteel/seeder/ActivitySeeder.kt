package bj.rawsteel.seeder

import bj.rawsteel.domain.ActivityType
import bj.rawsteel.service.ActivityRuleService
import bj.rawsteel.service.ActivityService
import bj.rawsteel.service.ActivitySkuService
import bj.rawsteel.service.SkuService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:20
 */
@Component
class ActivitySeeder {

    @Resource
    private lateinit var activityService: ActivityService

    @Resource
    private lateinit var activityRuleService: ActivityRuleService

    @Resource
    private lateinit var activitySkuService: ActivitySkuService

    @Resource
    private lateinit var skuService: SkuService

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun clear() {
        logger.info("Clear activitys ...")
        activityService.destroyAll()
    }

    fun seed() {
        logger.info("Seed activitys ...")

        val skus = skuService.findAll().shuffled()

        activityService.create("Apple special price", ActivityType.SPECIAL_PRICE).apply {
            activitySkuService.create(activityId = this.id!!, skuId = skus[0].id!!)
            activitySkuService.create(activityId = this.id!!, skuId = skus[1].id!!)
            activitySkuService.create(activityId = this.id!!, skuId = skus[2].id!!)
            activityRuleService.create(specialPrice = 990)
        }
        activityService.create("Banana money off", ActivityType.MONEY_OFF).apply {
            activitySkuService.create(activityId = this.id!!, skuId = skus[3].id!!)
            activitySkuService.create(activityId = this.id!!, skuId = skus[4].id!!)
            activityRuleService.create(moneyOff = 500)
        }
        activityService.create("Orange money off percent", ActivityType.MONEY_OFF_PERCENT).apply {
            activitySkuService.create(activityId = this.id!!, skuId = skus[5].id!!)
            activityRuleService.create(moneyOffPercent = 20)
        }
    }

    fun clearAndSeed() {
        clear()
        seed()
        logger.info("Activitys:")
        activityService.findAll().forEach(::println)
    }
}

