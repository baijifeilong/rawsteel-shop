package bj.rawsteel.repository

import bj.rawsteel.domain.Template
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

/**
 * Created by BaiJiFeiLong@gmail.com at 18-7-8 下午4:17
 */
interface TemplateRepository : JpaRepository<Template, Long>, QuerydslPredicateExecutor<Template>
