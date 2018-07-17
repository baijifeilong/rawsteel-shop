package bj.rawsteel.service

import bj.rawsteel.domain.QSku
import bj.rawsteel.domain.Sku
import bj.rawsteel.repository.SkuRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:10
 */
@Service
class SkuService {

    @Resource
    private lateinit var skuRepository: SkuRepository;

    fun findAll(pageable: Pageable): Page<Sku> {
        val predicate = QSku.sku.isNotNull
        return skuRepository.findAll(predicate, pageable)
    }

    fun findAll(): List<Sku> {
        return skuRepository.findAll()
    }

    fun findById(id: Long): Optional<Sku> {
        return skuRepository.findById(id)
    }

    fun findByIdOrThrow(id: Long): Sku {
        return findById(id).orElseThrow { RuntimeException("Sku(id=$id) not exist") }
    }

    fun create(name: String, productId: Long, price: Long): Sku {
        val sku = Sku().apply {
            createdAt = Date()
            updatedAt = createdAt
            this.name = name
            this.productId = productId
            this.price = price
        }
        skuRepository.save(sku)
        return sku
    }

    fun update(id: Long): Sku {
        val sku = findByIdOrThrow(id).apply {
            updatedAt = Date()
        }
        skuRepository.save(sku)
        return sku
    }

    fun destroy(id: Long) {
        findByIdOrThrow(id)
        skuRepository.deleteById(id)
    }

    fun destroyAll() {
        skuRepository.deleteAll()
    }
}