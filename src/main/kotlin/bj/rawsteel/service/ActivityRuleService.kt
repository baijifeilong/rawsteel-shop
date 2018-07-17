package bj.rawsteel.service

import bj.rawsteel.domain.ActivityRule
import bj.rawsteel.domain.QActivityRule
import bj.rawsteel.repository.ActivityRuleRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:10
 */
@Service
class ActivityRuleService {

    @Resource
    private lateinit var activityRuleRepository: ActivityRuleRepository;

    fun findAll(pageable: Pageable): Page<ActivityRule> {
        val predicate = QActivityRule.activityRule.isNotNull
        return activityRuleRepository.findAll(predicate, pageable)
    }

    fun findAll(): List<ActivityRule> {
        return activityRuleRepository.findAll()
    }

    fun findById(id: Long): Optional<ActivityRule> {
        return activityRuleRepository.findById(id)
    }

    fun findByIdOrThrow(id: Long): ActivityRule {
        return findById(id).orElseThrow { RuntimeException("ActivityRule(id=$id) not exist") }
    }

    fun create(specialPrice: Long? = null, moneyOff: Long? = null, moneyOffPercent: Int? = null): ActivityRule {
        val activityRule = ActivityRule().apply {
            createdAt = Date()
            updatedAt = createdAt
            if (specialPrice != null) this.specialPrice = specialPrice
            if (moneyOff != null) this.moneyOff = moneyOff
            if (moneyOffPercent != null) this.moneyOffPercent = moneyOffPercent
        }
        activityRuleRepository.save(activityRule)
        return activityRule
    }

    fun update(id: Long): ActivityRule {
        val activityRule = findByIdOrThrow(id).apply {
            updatedAt = Date()
        }
        activityRuleRepository.save(activityRule)
        return activityRule
    }

    fun destroy(id: Long) {
        findByIdOrThrow(id)
        activityRuleRepository.deleteById(id)
    }

    fun destroyAll() {
        activityRuleRepository.deleteAll()
    }
}