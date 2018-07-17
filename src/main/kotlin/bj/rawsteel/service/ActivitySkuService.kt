package bj.rawsteel.service

import bj.rawsteel.domain.QActivitySku
import bj.rawsteel.domain.ActivitySku
import bj.rawsteel.repository.ActivitySkuRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:10
 */
@Service
class ActivitySkuService {

    @Resource
    private lateinit var activitySkuRepository: ActivitySkuRepository;

    fun findAll(pageable: Pageable): Page<ActivitySku> {
        val predicate = QActivitySku.activitySku.isNotNull
        return activitySkuRepository.findAll(predicate, pageable)
    }

    fun findAll(): List<ActivitySku> {
        return activitySkuRepository.findAll()
    }

    fun findById(id: Long): Optional<ActivitySku> {
        return activitySkuRepository.findById(id)
    }

    fun findByIdOrThrow(id: Long): ActivitySku {
        return findById(id).orElseThrow { RuntimeException("ActivitySku(id=$id) not exist") }
    }

    fun create(activityId: Long, skuId: Long): ActivitySku {
        val activitySku = ActivitySku().apply {
            createdAt = Date()
            updatedAt = createdAt
            this.activityId = activityId
            this.skuId = skuId
        }
        activitySkuRepository.save(activitySku)
        return activitySku
    }

    fun update(id: Long): ActivitySku {
        val activitySku = findByIdOrThrow(id).apply {
            updatedAt = Date()
        }
        activitySkuRepository.save(activitySku)
        return activitySku
    }

    fun destroy(id: Long) {
        findByIdOrThrow(id)
        activitySkuRepository.deleteById(id)
    }

    fun destroyAll() {
        activitySkuRepository.deleteAll()
    }
}