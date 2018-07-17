package bj.rawsteel.domain

import java.util.*
import javax.persistence.*

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 上午10:57
 */
@Entity
class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    var name: String? = null
    @Column
    var type: ActivityType? = null
    @Column
    var startedAt: Date? = null
    @Column
    var stoppedAt: Date? = null
    @Column
    var createdAt: Date? = null
    @Column
    var updatedAt: Date? = null

    override fun toString(): String {
        return "Activity(id=$id, name=$name, type=$type, startedAt=$startedAt, stoppedAt=$stoppedAt, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}

enum class ActivityType {
    SPECIAL_PRICE,
    MONEY_OFF,
    MONEY_OFF_PERCENT
}

@Entity
class ActivityRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column
    var specialPrice: Long? = null
    @Column
    var moneyOff: Long? = null
    @Column
    var moneyOffPercent: Int? = null
    @Column
    var createdAt: Date? = null
    @Column
    var updatedAt: Date? = null

    override fun toString(): String {
        return "ActivityRule(id=$id, specialPrice=$specialPrice, moneyOff=$moneyOff, moneyOffPercent=$moneyOffPercent, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}

@Entity
class ActivitySku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column
    var activityId: Long? = null
    @Column
    var skuId: Long? = null
    @Column
    var createdAt: Date? = null
    @Column
    var updatedAt: Date? = null

    override fun toString(): String {
        return "ActivitySku(id=$id, activityId=$activityId, skuId=$skuId, createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}