package bj.rawsteel.service

import bj.rawsteel.domain.QActivity
import bj.rawsteel.domain.Activity
import bj.rawsteel.domain.ActivityType
import bj.rawsteel.repository.ActivityRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:10
 */
@Service
class ActivityService {

    @Resource
    private lateinit var activityRepository: ActivityRepository;

    fun findAll(pageable: Pageable): Page<Activity> {
        val predicate = QActivity.activity.isNotNull
        return activityRepository.findAll(predicate, pageable)
    }

    fun findAll(): List<Activity> {
        return activityRepository.findAll()
    }

    fun findById(id: Long): Optional<Activity> {
        return activityRepository.findById(id)
    }

    fun findByIdOrThrow(id: Long): Activity {
        return findById(id).orElseThrow { RuntimeException("Activity(id=$id) not exist") }
    }

    fun create(name: String, type: ActivityType, startedAt: Date? = null, stoppedAt: Date? = null): Activity {
        val activity = Activity().apply {
            createdAt = Date()
            updatedAt = createdAt
            this.name = name
            this.type = type
            this.startedAt = startedAt ?: Date()
            this.stoppedAt = stoppedAt ?: Date.from(LocalDateTime.now().plusDays(7).atZone(ZoneId.systemDefault()).toInstant())
        }
        activityRepository.save(activity)
        return activity
    }

    fun update(id: Long): Activity {
        val activity = findByIdOrThrow(id).apply {
            updatedAt = Date()
        }
        activityRepository.save(activity)
        return activity
    }

    fun destroy(id: Long) {
        findByIdOrThrow(id)
        activityRepository.deleteById(id)
    }

    fun destroyAll() {
        activityRepository.deleteAll()
    }
}