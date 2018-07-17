package bj.rawsteel.repository

import bj.rawsteel.domain.Activity
import bj.rawsteel.domain.ActivityRule
import bj.rawsteel.domain.ActivitySku
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/17 下午1:06
 */

interface ActivityRepository : JpaRepository<Activity, Long>, QuerydslPredicateExecutor<Activity>

interface ActivityRuleRepository : JpaRepository<ActivityRule, Long>, QuerydslPredicateExecutor<ActivityRule>

interface ActivitySkuRepository : JpaRepository<ActivitySku, Long>, QuerydslPredicateExecutor<ActivitySku>

