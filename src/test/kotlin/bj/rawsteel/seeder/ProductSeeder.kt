package bj.rawsteel.seeder

import bj.rawsteel.service.ProductService
import bj.rawsteel.service.SkuService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:18
 */
@Component
class ProductSeeder {

    @Resource
    private lateinit var productService: ProductService

    @Resource
    private lateinit var skuService: SkuService

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun clear() {
        logger.info("Clear products ...")
        productService.destroyAll()
    }

    fun seed() {
        logger.info("Seed products ...")
        productService.create("Apple")
        productService.create("Banana")
        productService.create("Orange")
        productService.findAll().forEach {
            skuService.create("Small ${it.name}", it.id!!, 1880)
            skuService.create("Big ${it.name}", it.id!!, 2880)
            skuService.create("Huge ${it.name}", it.id!!, 3880)
        }
    }

    fun clearAndSeed() {
        clear()
        seed()
        logger.info("Products:")
        productService.findAll().forEach(::println)
    }
}

